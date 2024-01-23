package com.springpeople.hibernate.mapping.HibernateSample.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
//import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="projects")
public class Projects {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="project_name", nullable = false, unique = true)
	private String projectName;
	
	@Column(name="start_date", nullable = false)
	private LocalDate startDate;
	
	@Column(name="end_date", nullable = false)
	private LocalDate endDate;
	
	@OneToMany(mappedBy = "projects", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	private List<Employee> employees;
	
	public Projects() {}

	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long projectId) {
		this.id = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Projects(String projectName, LocalDate startDate, LocalDate endDate) {
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(endDate, id, projectName, startDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projects other = (Projects) obj;
		return Objects.equals(endDate, other.endDate) && id == other.id
				&& Objects.equals(projectName, other.projectName) && Objects.equals(startDate, other.startDate);
	}

	@Override
	public String toString() {
		return "Projects [projectId=" + id + ", projectName=" + projectName + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
	
}
