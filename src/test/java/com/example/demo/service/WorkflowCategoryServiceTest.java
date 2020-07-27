package com.example.demo.service;

import com.example.demo.model.WorkflowCategory;
import com.example.demo.repository.WorkflowCategoryRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doAnswer;

@SpringBootTest
public class WorkflowCategoryServiceTest {
    @Mock
    private WorkflowCategoryRepository workflowCategoryRepository;

    @Autowired
    private WorkflowCategoryService workflowCategoryService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        doAnswer(new Answer<List<WorkflowCategory>>() {
            @Override
            public List<WorkflowCategory> answer(InvocationOnMock invocation) throws Throwable {
                List<WorkflowCategory> list = new ArrayList<>();
                WorkflowCategory workflowCategory1 = new WorkflowCategory();
                workflowCategory1.setName("workflowCategory1");
                workflowCategory1.setEnabled(true);
                workflowCategory1.setDescription("the first workflowCategory");
                list.add(workflowCategory1);

                WorkflowCategory workflowCategory2 = new WorkflowCategory();
                workflowCategory2.setName("workflowCategory2");
                workflowCategory2.setEnabled(true);
                workflowCategory2.setDescription("the second workflowCategory");
                list.add(workflowCategory2);
                return list;
            }
        }).when(workflowCategoryRepository).findAll();
    }

    @Test
    public void testWorkflowsByName() {
        assertEquals(workflowCategoryService.getAllWorkflowsCategories().size(), 2);
    }
}
