package com.example.navigation.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.navigation.dto.request.CompanyLoginRequest;
import com.example.navigation.dto.request.SaveCompanyRequest;
import com.example.navigation.dto.response.CompanyInfo;
import com.example.navigation.entity.user.Company;
import com.example.navigation.exception.BusinessException;
import com.example.navigation.repository.CompanyRepository;
import com.example.navigation.service.CompanyService;
import com.example.navigation.util.UserUtil;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public CompanyInfo saveCompany(SaveCompanyRequest entity) {
        if (entity == null) {
            throw new BusinessException(400, "公司实体不能为空");
        }

        String companyName = entity.companyName();
        if (companyName == null || companyName.isEmpty()) {
            throw new BusinessException(401, "公司名称不能为空");
        }

        companyRepository.findByCompanyName(companyName).ifPresent(company -> {
            throw new BusinessException(401, company.getCompanyName() + "已经被使用，请更换名称");
        });

        String certificateImageUrl = entity.businessLicense();
        if (certificateImageUrl == null || certificateImageUrl.isEmpty()) {
            throw new BusinessException(401, "公司营业执照不能为空");
        }

        String companyLogoUrl = entity.companyLogoUrl();
        if (companyLogoUrl == null || companyLogoUrl.isBlank()) {
            throw new BusinessException(401, "请上传公司logo");
        }

        // 随机公司账号
        String randomAccount = UserUtil.generateAccount("1023");

        Company newCompany = new Company(

                entity.companyName(),
                randomAccount,
                entity.password(),
                entity.companyLogoUrl(),
                entity.businessLicense());

        Company company = companyRepository.save(newCompany);
        return companyTransformCompanyInfo(company);
    }

    @Override
    public List<CompanyInfo> findAllCompany() {
        List<CompanyInfo> list = companyRepository
                .findAll()
                .stream()
                .map(this::companyTransformCompanyInfo)
                .toList();

        return list;
    }

    @Override
    public CompanyInfo companyLogin(CompanyLoginRequest entity) {
        if (entity.companyAccount() == null || entity.companyAccount().isEmpty()) {
            throw new BusinessException(403, "账号不能为空");
        }

        if (entity.password() == null || entity.password().isEmpty()) {
            throw new BusinessException(403, "请输入密码");
        }

        Company company = companyRepository
                .findByCompanyAccountAndPassword(entity.companyAccount(), entity.password())
                .orElseThrow(() -> new BusinessException(401, "账号或密码错误"));

        return companyTransformCompanyInfo(company);
    }

    private CompanyInfo companyTransformCompanyInfo(Company company) {
        return new CompanyInfo(
                company.getCompanyId(),
                company.getCompanyName(),
                company.getCompanyAccount(),
                company.getAvatarUrl(),
                company.getBusinessLicense());
    }
}
