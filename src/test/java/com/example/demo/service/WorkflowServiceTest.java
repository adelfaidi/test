package com.example.demo.service;

import com.example.demo.model.Workflow;
import com.example.demo.model.WorkflowCategory;
import com.example.demo.repository.WorkflowRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import org.mockito.stubbing.Answer;

@SpringBootTest
public class WorkflowServiceTest {
    @Mock
    private WorkflowRepository workflowRepository;

    @Autowired
    private WorkflowService workflowService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testWorkflowsByName() {
        doAnswer(new Answer<List<Workflow>>() {
            @Override
            public List<Workflow> answer(InvocationOnMock invocation) throws Throwable {
                List<Workflow> list = new ArrayList<>();
                Workflow w1 = new Workflow();
                w1.setName("workflow1");
                w1.setEnabled(true);
                w1.setDescription("the first workflow");
                w1.setVariantes(new HashSet<>());
                list.add(w1);
                return list;
            }
        }).when(workflowRepository).findByName(anyString());
        assertEquals(workflowService.getWorkflowsByName("workflow1").size(), 1);
    }

    @Test
    public void testWorkflowsByCategories() {
        doAnswer(new Answer<List<Workflow>>() {
            @Override
            public List<Workflow> answer(InvocationOnMock invocation) throws Throwable {
                Workflow w1 = new Workflow();
                w1.setId(1L);
                w1.setName("workflow1");
                w1.setEnabled(true);
                w1.setDescription("the first workflow");
                w1.setVariantes(new HashSet<>());

                List<WorkflowCategory> listOfCategories = new ArrayList<>();
                WorkflowCategory workflowCategory1 = new WorkflowCategory();
                workflowCategory1.setId(1L);
                workflowCategory1.setName("workflowCategory1");
                workflowCategory1.setEnabled(true);
                workflowCategory1.setDescription("the first workflowCategory");
                workflowCategory1.setWorkflows(new HashSet<Workflow>(Arrays.asList(w1)));
                listOfCategories.add(workflowCategory1);

                Set<Workflow> listOfWorkflow = new HashSet<>();
                listOfCategories.forEach(workflowCategory -> {
                    if (workflowCategory.getWorkflows().contains(w1) && !listOfWorkflow.contains(w1))
                        listOfWorkflow.add(w1);
                });
                return new ArrayList<>(listOfWorkflow);
            }
        }).when(workflowRepository).getWorkflowsByCategories(anyList());
        assertEquals(workflowService.getWorkflowsByCategories(Arrays.asList(new Long[]{1L})).size(), 1);
    }

    @Test
    public void testWorkflowsByStatus() {
        doAnswer(new Answer<List<Workflow>>() {
            @Override
            public List<Workflow> answer(InvocationOnMock invocation) throws Throwable {
                List<Workflow> listOfWorkflow = new ArrayList<>();
                Workflow w1 = new Workflow();
                w1.setName("workflow1");
                w1.setEnabled(true);
                w1.setDescription("the first workflow");
                w1.setVariantes(new HashSet<>());
                listOfWorkflow.add(w1);

                Workflow w2 = new Workflow();
                w2.setName("workflow2");
                w2.setEnabled(true);
                w2.setDescription("the second workflow");
                w2.setVariantes(new HashSet<>());
                listOfWorkflow.add(w2);

                Workflow w3 = new Workflow();
                w3.setName("workflow3");
                w3.setEnabled(true);
                w3.setDescription("the third workflow");
                w3.setVariantes(new HashSet<>());
                listOfWorkflow.add(w3);

                return listOfWorkflow;
            }
        }).when(workflowRepository).findByEnabled(anyBoolean());
        assertEquals(workflowService.getWorkflowsByStatus(true).size(), 3);
    }
}
