package com.example.navigation.service;

import com.example.navigation.entity.CertificateType;
import com.example.navigation.repository.CertificateTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateTypeService {

    @Autowired
    private CertificateTypeRepository certificateTypeRepository;

    /**
     * 根据ID查询证书类型
     */
    public CertificateType findById(Integer id) {
        return certificateTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("证书类型不存在，ID：" + id));
    }

    /**
     * 查询所有证书类型
     */
    public List<CertificateType> findAll() {
        return certificateTypeRepository.findAll();
    }

    /**
     * 新增证书类型
     */
    public CertificateType save(CertificateType type) {
        return certificateTypeRepository.save(type);
    }

    /**
     * 更新证书类型
     */
    public CertificateType update(CertificateType type) {
        return certificateTypeRepository.save(type);
    }

    /**
     * 删除证书类型
     */
    public void deleteById(Integer id) {
        certificateTypeRepository.deleteById(id);
    }
}