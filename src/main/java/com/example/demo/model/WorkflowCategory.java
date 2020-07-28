package com.example.demo.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "workflowCategory")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkflowCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String description;

	private String logo;

	@Column(nullable = false, updatable = false)
	@CreatedDate
	private Date createdAt;

	@LastModifiedDate
	private Date modifiedAt;

	private Boolean enabled;

	@OneToOne(fetch = FetchType.LAZY)
	private WorkflowCategory parentCategory;

	@ManyToMany
	@JoinTable(
			name = "workflow_workflowcategory",
			joinColumns = @JoinColumn(name = "workflowcategory_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "workflow_id", referencedColumnName = "id")
	)
	private Set<Workflow> workflows;
}
