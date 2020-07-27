package com.example.demo.Dto;

import com.example.demo.model.WorkflowCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkflowCategoryDto {
    private Long id;
    private String name;
    private String description;
    private String logo;
    private Date createdAt;
    private Date modifiedAt;
    private Boolean enabled;
    private String parentCategoryName;
    private Set<String> workflowsNames;

    public WorkflowCategoryDto(WorkflowCategory workflowCategory) {
        this.id = workflowCategory.getId();
        this.name = workflowCategory.getName();
        this.description = workflowCategory.getDescription();
        this.logo = workflowCategory.getLogo();
        this.createdAt = workflowCategory.getCreatedAt();
        this.modifiedAt = workflowCategory.getModifiedAt();
        this.enabled = workflowCategory.getEnabled();
        if (workflowCategory.getParentCategory()!=null)
            this.parentCategoryName = workflowCategory.getParentCategory().getName();
        if (workflowCategory.getWorkflows()!=null) {
            Set<String> workflows_names = new HashSet<>();
            workflowCategory.getWorkflows().forEach((workflow) -> {
                workflows_names.add(workflow.getName());
            });
            this.workflowsNames = workflows_names;
        }
    }
}
