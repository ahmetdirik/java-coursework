public class Student {
	public String studentName;
	public int studentId;
	public double gga;
	
	public Student(String studentName, int studentId, double gga) {
		this.studentName=studentName;
		this.studentId=studentId;
		this.gga=gga;
	}

	public String getName() {
		return studentName;
	}

	public int getId() {
		return studentId;
	}

	public double getGPA() {
		return gga;
	}

	public void updateGPA(double newGPA) {
		gga=newGPA;
	}
}

public class ImplementStudent {

	public static void main(String[] args) {
		Student s1 = new Student("Aloc", 101, 3.2);
		System.out.println("student name: " + s1.getName());
		System.out.println(" student id:" + s1.getId());
		System.out.println(" student gpa: " + s1.getGPA());
		
		s1.updateGPA(4.0);

		System.out.println(" updated gpa: " + s1.getGPA());
	}
}