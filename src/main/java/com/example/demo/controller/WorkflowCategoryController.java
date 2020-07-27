package com.example.demo.controller;

import com.example.demo.service.WorkflowCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("workflow/category/api")
public class WorkflowCategoryController {
    @Autowired
    private WorkflowCategoryService workflowCategoryService;

    @GetMapping(value = "/getAllWorkflowCategories")
    public ResponseEntity<?> getAllWorkflowsCategories(){
        return new ResponseEntity<>(workflowCategoryService.getAllWorkflowsCategories(), HttpStatus.OK);
    }
}
