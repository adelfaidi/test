package com.example.demo.service.Impl;

import com.example.demo.Dto.WorkflowCategoryDto;
import com.example.demo.model.WorkflowCategory;
import com.example.demo.repository.WorkflowCategoryRepository;
import com.example.demo.service.WorkflowCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorkflowCategoryServiceImpl implements WorkflowCategoryService {
    @Autowired
    private WorkflowCategoryRepository workflowCategoryRepository;

    @Override
    public List<WorkflowCategoryDto> getAllWorkflowsCategories() {
        List<WorkflowCategory> workflowCategories = workflowCategoryRepository.findAll();
        List<WorkflowCategoryDto> workflowCategoryDtos = new ArrayList<>();
        workflowCategories.forEach((workflowCategory) -> {
            workflowCategoryDtos.add(new WorkflowCategoryDto(workflowCategory));
        });
        return workflowCategoryDtos;
    }
}
