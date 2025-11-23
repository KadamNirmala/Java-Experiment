package DTOs;

import java.util.Set;

public class ProjectDTO {

	private long id;
	private String projectName;
	private Set<EmployeeDTO> employees;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Set<EmployeeDTO> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<EmployeeDTO> employees) {
		this.employees = employees;
	}
	public ProjectDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
