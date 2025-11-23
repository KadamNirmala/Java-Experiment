package Helper;

import java.util.List;
import com.example.demo.Entity.Employee;

public class EmployeeRequest {

    private Employee employee;  // The Employee object
    private List<Long> projectIds;  // IDs of projects to assign

    // Getters and Setters
    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    public List<Long> getProjectIds() { return projectIds; }
    public void setProjectIds(List<Long> projectIds) { this.projectIds = projectIds; }
	public EmployeeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
