package com.example.demo.util;

import com.example.demo.model.Workflow;
import com.example.demo.model.WorkflowCategory;
import com.example.demo.repository.WorkflowCategoryRepository;
import com.example.demo.repository.WorkflowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class DataBaseGenerator {
    @Autowired
    WorkflowRepository workflowRepository;

    @Autowired
    WorkflowCategoryRepository workflowCategoryRepository;

    @PostConstruct
    public void init() {
        // save workflows
        Workflow w2 = new Workflow(2L, "workflow2", "the second workflow", true, null);
        workflowRepository.save(w2);
        Workflow w3 = new Workflow(3L, "workflow3", "the third workflow", true, null);
        workflowRepository.save(w3);
        Workflow w1 = new Workflow(1L, "workflow1", "the first workflow", true, new HashSet<>(Arrays.asList(w2,w3)));
        workflowRepository.save(w1);


        // save workflowCategories
        WorkflowCategory workflowCategory1 = new WorkflowCategory(1L, "workflowCategory1", "the first workflow", "logo1", new Date(), new Date(),
        true, null, new HashSet<>(Arrays.asList(w3)));
        workflowCategoryRepository.save(workflowCategory1);
        WorkflowCategory workflowCategory2 = new WorkflowCategory(2L, "workflowCategory2", "the second workflow", "logo2", new Date(), new Date(),
                true, workflowCategory1, new HashSet<>(Arrays.asList(w1,w2)));
        workflowCategoryRepository.save(workflowCategory2);
    }
}
