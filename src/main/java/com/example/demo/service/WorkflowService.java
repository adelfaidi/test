package com.example.demo.service;

import com.example.demo.Dto.WorkflowDto;
import java.util.List;

public interface WorkflowService {
    List<WorkflowDto> getWorkflowsByName(String userName);

    List<WorkflowDto> getWorkflowsByCategories(List<Long> ids);

    List<WorkflowDto> getWorkflowsByStatus(Boolean enabled);
}
