import java.util.Scanner;

public class EmployeeSalaryManager {

	private String name;
	private double baseSalary;
	private double bonusPercentage;
	private double totalSalary;
	private static int employeeCount = 0;

	 public EmployeeSalaryManager(String name, double baseSalary, double bonusPercentage) {
	        this.name = name;
	        this.baseSalary = baseSalary;
	        this.bonusPercentage = bonusPercentage;
	        settotalSalary();
	        employeeCount++;
	    }


	public void setname(String name){
		this.name = name;
		
	}
	
	public void setbaseSalary(double baseSalary){
		this.baseSalary = baseSalary;
		settotalSalary();
		
	}
	public void setbonusPercentage(double bonusPercentage){
		this.bonusPercentage = bonusPercentage;
		settotalSalary();
	}
	public void settotalSalary(){
		this.totalSalary = baseSalary + (baseSalary * (bonusPercentage/100));
		
	}
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return baseSalary;
	}
	public double getbonusPercentage() {
		return bonusPercentage;
	}
	
	public double gettotalSalary() {
		return totalSalary;
	}
	
    public static int getEmployeeCount() {
        return employeeCount;
    }
    
	public String getPerformanceLevel() {
		if(totalSalary >= 90000) {
			return "Excellent";
		}
		
		else if(totalSalary < 90000 && totalSalary >= 70000 ) {
			return "Good";
		}
		else if(totalSalary < 70000 && totalSalary >=30000 ) {
			return"Average";
		}
		else if(totalSalary < 30000 && totalSalary > 0) {
			return"Need Improvment";
		}
		
		else {
			return"invalid input";
		}

	}
	public String getMotivationSentence() {
		switch(getPerformanceLevel()) {
		case "Excellent":
			return "You are perfect, keep going!";
		case "Good":
			return "You are making good job!";
	case "Average":
			return "You are not bad but you can develop yourself!";
		default:
			return "With enough effort, you can achieve anything you want.";
		}
		

	}
	
	
	public void printEmployee() {
		System.out.println(name + "'s total salary: " + totalSalary);
		System.out.println(name + "'s Performance level: "  + getPerformanceLevel());
		System.out.println(getMotivationSentence());
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		
		for (int i=-1; i < employeeCount ;i++) {
			System.out.print("Please enter name: ");
			String name = scanner.nextLine();
			 System.out.print("Please enter base salary: ");
			double baseSalary = scanner.nextDouble();
			
			 System.out.print("Enter bonus percentage: ");
			double bonusPercentage = scanner.nextDouble();
			
			EmployeeSalaryManager employee = new EmployeeSalaryManager(name, baseSalary, bonusPercentage);
            employee.printEmployee();
            scanner.nextLine();
        	System.out.println("Total employee count: " + EmployeeSalaryManager.getEmployeeCount());
		}
		
		
		
		
	}

}
