import java.util.Scanner;

public class CourseGradingSystem {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//we define a scanner
		Scanner sc1 = new Scanner(System.in);
		 
		System.out.println("Enter number of students: ");
		//for a loop until count of students
		int studentNumber = sc1.nextInt();
		sc1.nextLine();    
		//We define a array for Different student types
		Student[] students = new Student[studentNumber];
		for (int i=0;i<studentNumber;i++) {
			//firstly we take student's names
			System.out.println("Please enter the student name: ");
            String name = sc1.nextLine();
            
          
			System.out.println("Is the student (1) Undergraduate, (2) Graduate, (3) International? ");
            int type = sc1.nextInt();
            //we take student type with scanner and we use a switch loop
            sc1.nextLine();     
            switch (type) {
            case 1:
            	students[i] = new UndergraduateStudent(name);
            	break;
            case 2:
            	students[i] = new GraduateStudent(name);
            	break;
            case 3:
            	students[i] = new InternationalStudent(name);
            	break;
            default:
                System.out.println("Invalid input");
                break;
            }
            
            //we take student's midterms and final grades
            System.out.println("Enter grades for 3 courses (Midterm and Final):");	
            for(int x=0;x<3;x++) {
            System.out.print("Course " + (x+1) + ": ");
            int mid = sc1.nextInt();
            int fin = sc1.nextInt();
            sc1.nextLine();    
            students[i].setGrades(x, mid, fin);
            
            }
         // Display studentInfo and getGradeCategory
            students[i].displayInfo();
            students[i].getGradeCategory();
            System.out.println();
		
		}
		
		
	
	}

}

abstract class Student{
	String name;
	int[][] grades;
	
	//we calculate students average points with a loop take values from Multi-dimensional Arrays

	int calculateAvarage() {
		int sum =0;
		for (int i=0;i<grades.length;i++) {
			for(int j=0;j<grades[i].length;j++) {
				sum += grades[i][j];
			}
		}
		return sum/=6;
	}
	//we use a constructor and we define a Multi-dimensional array with 3 courses and 2 columns
	public Student(String name) {
        this.name = name;
        this.grades = new int[3][2];
    }
	//we set midterm and final grades from array's columns
	public void setGrades(int courseIndex, int midterm, int finals) {
        grades[courseIndex][0] = midterm;
        grades[courseIndex][1] = finals;
    }
	
	//we define a abstract method in order to override it each different class
	abstract void getGradeCategory();
	//to getting info
	void displayInfo() {
		System.out.println("Name: "+ name);
		System.out.println("Avarage: "+ calculateAvarage());
		
	}
}
//Subclass for undergraduate students
class UndergraduateStudent extends Student{
	public UndergraduateStudent(String name) {
        super(name);
    }
	@Override
	void getGradeCategory() {
		// TODO Auto-generated method stub
		// Determine grade category and print result
		double avarage = calculateAvarage();
		if (avarage>= 85) {
			System.out.println("Excellent");
		}
		else if(avarage>= 70 &&avarage<85) {
			System.out.println("Good");
		}
		else if(avarage>= 50 && avarage<70) {
			System.out.println("Average");
		}
		else {
			System.out.println("fail");
		}
	}
	
}
//– InternationalStudent

//Subclass for GraduateStudent students
class GraduateStudent extends Student{
	public GraduateStudent(String name) {
        super(name);
    }
	@Override
	void getGradeCategory() {
		// TODO Auto-generated method stub
		double avarage = calculateAvarage();
		if (avarage>= 85) {
			System.out.println("Excellent");
		}
		else if(avarage>= 70 && avarage<85) {
			System.out.println("Good");
		}
		else if(avarage>= 50 && avarage<70) {
			System.out.println("Average");
		}
		else {
			System.out.println("fail");
		}
	}
	
}
class InternationalStudent extends Student{
	public InternationalStudent(String name) {
        super(name);
    }
	@Override
	void getGradeCategory() {
		// TODO Auto-generated method stub
		double avarage = calculateAvarage();
		if (avarage>= 85) {
			System.out.println("Excellent");
		}
		else if(avarage>= 70 && avarage<85) {
			System.out.println("Good");
		}
		else if(avarage>= 50 && avarage<70) {
			System.out.println("Average");
		}
		else {
			System.out.println("fail");
		}
	}
	
}


