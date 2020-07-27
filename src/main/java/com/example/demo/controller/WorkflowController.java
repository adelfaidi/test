package com.example.demo.controller;

import com.example.demo.service.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequestMapping("workflow/api")
public class WorkflowController {
    @Autowired
    private WorkflowService workflowService;

    @GetMapping(value = "/getWorkflowsByName/{name}")
    public ResponseEntity<?> getWorkflowsByName(@PathVariable String name){
        return new ResponseEntity<>(workflowService.getWorkflowsByName(name), HttpStatus.OK);
    }

    @GetMapping(value = "/getWorkflowsByCategories")
    public ResponseEntity<?> getWorkflowsByCategories(@RequestParam List<Long> ids){
        return new ResponseEntity<>(workflowService.getWorkflowsByCategories(ids), HttpStatus.OK);
    }

    @GetMapping(value = "/getWorkflowsByStatus/{enabled}")
    public ResponseEntity<?> getWorkflowsByStatus(@PathVariable Boolean enabled){
        return new ResponseEntity<>(workflowService.getWorkflowsByStatus(enabled), HttpStatus.OK);
    }
}
