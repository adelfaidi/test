package com.example.demo.repository;

import com.example.demo.Dto.WorkflowDto;
import com.example.demo.model.Workflow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface WorkflowRepository extends JpaRepository<Workflow, Long> {
    Optional<List<Workflow>> findByName(String name);

    @Query("select new com.example.demo.Dto.WorkflowDto(w) from Workflow w where w.id in ?1")
    List<WorkflowDto> getWorkflowsByCategories(List<Long> ids);

    Optional<List<Workflow>> findByEnabled(Boolean enabled);
}
