package com.stephen.repository;

import com.stephen.model.Freelance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FreelanceRepository extends JpaRepository<Freelance, Long> {
    List<Freelance> findByServiceCategoriesContaining(String category);
}
