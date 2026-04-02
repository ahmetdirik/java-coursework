
import java.util.Scanner;

public class AvarageGrades {
	
	public String name;
	private double grade;
	
	public AvarageGrades(String name, double grade) {
		this.name = name;
		this.grade = grade;
	}

	public void setGrades(double grade) {
		this.grade = grade;
	}
	public double getGrades() {
		return grade;
	}
	
	public void printStudents(String name, double grade) {
		System.out.printf("Student %s has %.2f%n grade " ,name , grade);
	}
	public static void main(String[] args) {
		System.out.println("Enter your quiz note ,please:");
		
		Scanner scanner = new Scanner(System.in);
		
		double quiz = scanner.nextDouble();
		System.out.println("Enter your visa note ,please:");

		double visa = scanner.nextDouble();
		System.out.println("Enter your final note ,please:");

		double finl = scanner.nextDouble();
		
		double grade = ((quiz * 20) / 100) + ((visa * 30) / 100) + ((finl * 50) / 100);
		
		scanner.nextLine();

		System.out.println("Enter your name: ");
		
		String name = scanner.nextLine();
		
		AvarageGrades student = new AvarageGrades(name, grade);
		
		student.printStudents(name, grade);
		
		if (grade > 50) {
			System.out.println("passed");
		}
	}

}
