package app;


public class PartTimeEmp extends Employee {
	
	private String empId;
	private String name;
	
	
	public PartTimeEmp (String empId) {
		super(empId);
	}
	
	@Override
	public int salary (int salary)
	{
		return 0;
	}
	
	@Override 
	public void salesConsultant()
	{
		
	}
	@Override 
	public void propertyManagers() {
		
	}
	@Override 
	public void branchAdministrator() {
		
	}
}
