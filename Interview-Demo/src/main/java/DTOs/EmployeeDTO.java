package DTOs;

import java.util.Set;


public class EmployeeDTO {

	private long id;
	private String name;
	private String email;
	private Set<ProjectDTO>projects;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<ProjectDTO> getProjects() {
		return projects;
	}
	public void setProjects(Set<ProjectDTO> projects) {
		this.projects = projects;
	}
	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
