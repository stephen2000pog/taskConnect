package com.stephen.service;

import com.stephen.dto.FreelanceDTO;
import com.stephen.mapper.FreelanceMapper;
import com.stephen.model.Freelance;
import com.stephen.repository.FreelanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FreelanceService {

    private final FreelanceRepository freelanceRepository;
    private final FreelanceMapper freelanceMapper;

    public FreelanceService(FreelanceRepository repo, FreelanceMapper mapper) {
        this.freelanceRepository = repo;
        this.freelanceMapper = mapper;
    }

    public List<FreelanceDTO> getAllFreelances() {
        return freelanceRepository.findAll()
                .stream()
                .map(freelanceMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<FreelanceDTO> getFreelanceById(Long id) {
        return freelanceRepository.findById(id)
                .map(freelanceMapper::toDto);
    }

    public FreelanceDTO createFreelance(FreelanceDTO dto) {
        Freelance entity = freelanceMapper.toEntity(dto);
        Freelance saved = freelanceRepository.save(entity);
        return freelanceMapper.toDto(saved);
    }

    public void deleteFreelance(Long id) {
        freelanceRepository.deleteById(id);
    }
}
