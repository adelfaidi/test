package com.example.demo.Dto;

import com.example.demo.model.Workflow;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkflowDto {
    private Long id;
    private String name;
    private String description;
    private Boolean enabled;
    private Set<String> variantesNames;

    public WorkflowDto(Workflow workflow) {
       this.id = workflow.getId();
       this.name = workflow.getName();
       this.description = workflow.getDescription();
       this.enabled = workflow.getEnabled();
       if (workflow.getVariantes()!=null) {
           Set<String> variantes_names = new HashSet<>();
           workflow.getVariantes().forEach((variante) -> {
               variantes_names.add(variante.getName());
           });
           this.variantesNames = variantes_names;
       }
    }
}
