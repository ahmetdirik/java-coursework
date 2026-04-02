import java.util.Scanner;

public class Student {
	private String name;
	public static int studentCount;
	
	public static int getStudentCount(){
		return studentCount;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public Student(String name) {
		this.name = name;
		studentCount++;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner (System.in);
		while(true) {
			System.out.println("Please enter a Student: ");
			Student student = new Student(scanner.nextLine());
			System.out.println("Total students registered: " + studentCount);
		}
		


	}

}
