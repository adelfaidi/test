package com.example.demo.repository;

import com.example.demo.Dto.WorkflowDto;
import com.example.demo.model.Workflow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface WorkflowRepository extends JpaRepository<Workflow, Long> {
    Optional<List<Workflow>> findByName(String name);

    @Query(value = "SELECT DISTINCT w.* FROM workflow.workflow as w\n" +
            "left join workflow.workflow_workflowcategory as ww\n" +
            "on w.id = ww.workflow_id\n" +
            "where ww.workflowcategory_id in ?1", nativeQuery = true)
    List<Workflow> getWorkflowsByCategories(List<Long> ids);

    Optional<List<Workflow>> findByEnabled(Boolean enabled);
}
