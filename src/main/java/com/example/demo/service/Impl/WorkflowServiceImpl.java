package com.example.demo.service.Impl;

import com.example.demo.Dto.WorkflowDto;
import com.example.demo.model.Workflow;
import com.example.demo.repository.WorkflowRepository;
import com.example.demo.service.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorkflowServiceImpl implements WorkflowService {
    @Autowired
    private WorkflowRepository workflowRepository;

    @Override
    public List<WorkflowDto> getWorkflowsByName(String name) {
        List<Workflow> workflows = workflowRepository.findByName(name).orElse(new ArrayList<>());
        List<WorkflowDto> workflowDtos = new ArrayList<>();
        workflows.forEach((workflow) -> {
            workflowDtos.add(new WorkflowDto(workflow));
        });
        return workflowDtos;
    }

    @Override
    public List<WorkflowDto> getWorkflowsByCategories(List<Long> ids) {
        List<Workflow> workflows =  workflowRepository.getWorkflowsByCategories(ids);
        List<WorkflowDto> workflowDtos = new ArrayList<>();
        workflows.forEach((workflow) -> {
            workflowDtos.add(new WorkflowDto(workflow));
        });
        return workflowDtos;
    }

    @Override
    public List<WorkflowDto> getWorkflowsByStatus(Boolean enabled) {
        List<Workflow> workflows = workflowRepository.findByEnabled(enabled).orElse(new ArrayList<>());
        List<WorkflowDto> workflowDtos = new ArrayList<>();
        workflows.forEach((workflow) -> {
            workflowDtos.add(new WorkflowDto(workflow));
        });
        return workflowDtos;
    }
}
