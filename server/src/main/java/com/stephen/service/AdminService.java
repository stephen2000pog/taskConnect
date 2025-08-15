package com.stephen.service;

import com.stephen.dto.AdminDTO;
import com.stephen.mapper.AdminMapper;
import com.stephen.model.Admin;
import com.stephen.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

    public AdminService(AdminRepository repo, AdminMapper mapper) {
        this.adminRepository = repo;
        this.adminMapper = mapper;
    }

    public AdminDTO createAdmin(AdminDTO dto) {
        Admin entity = adminMapper.toEntity(dto);
        Admin saved = adminRepository.save(entity);
        return adminMapper.toDto(saved);
    }

    public List<AdminDTO> getAllAdmin() {
        return adminRepository.findAll()
                .stream()
                .map(adminMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<AdminDTO> getAdminById(Long id) {
        return adminRepository.findById(id)
                .map(adminMapper::toDto);
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
