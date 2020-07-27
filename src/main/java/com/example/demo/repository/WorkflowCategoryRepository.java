package com.example.demo.repository;

import com.example.demo.model.WorkflowCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkflowCategoryRepository extends JpaRepository<WorkflowCategory, Long> {
}
