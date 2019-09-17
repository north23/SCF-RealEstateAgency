package people;

import java.util.Scanner;

public class Employee {
	
	private String empId;
	
	Scanner scanner = new Scanner (System.in);
	
	public int salary(int salary)
	{
		int salary1;
		int hours;
		//System.out.println("Please enter your base salary: ");
		salary = scanner.nextInt();
		System.out.println("Please enter the hours you have worked: ");
		hours = scanner.nextInt();
		
		salary1 = salary * hours;
		
		return salary1;
	}
	
	public Employee (String empId)
	{
		this.empId = empId;
	}
	
	public void salesConsultant () {
		
	}
	
	public void propertyManagers ()
	{
		
	}
	
	public void branchAdmin
	
	
	
	
}
