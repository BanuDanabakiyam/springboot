package com.springboot.curddemo;

import com.springboot.curddemo.dao.StudentDAO;
import com.springboot.curddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CurddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
			deleteAll(studentDAO);
		};
	}
	public  void deleteAll(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count " + numRowsDeleted);
	}
	public void  deleteStudent(StudentDAO studentDAO) {
		int studentId = 2;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	public void updateStudent(StudentDAO studentDAO) {
//		retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

//		change first name
		System.out.println("updating student ");
		myStudent.setFirstName("XXXX");
//		update the student
		studentDAO.update(myStudent);
//		display the updated student
		System.out.println("Updated student : " + myStudent);

	}

	public void queryForStudentsByLastName(StudentDAO studentDAO) {
//		get a list of students
		List<Student> theStudents = studentDAO.findByLastName("bakiyam");
//		display list of students
		for(Student temp: theStudents) {
			System.out.println(temp);
		}
	}

	public void queryForStudents(StudentDAO studentDAO) {
//		get a list of students
		List<Student> theStudents = studentDAO.findAll();
//		display list of students
		for(Student temp: theStudents) {
			System.out.println(temp);
		}


	}

	public  void readStudent(StudentDAO studentDAO) {
//		create a student object
		System.out.println("Creating student obj");
		Student tempStudent = new Student("Dinesh","Kumar","123@gmail.com");

//      save tha student
		System.out.println("Saving student");
		studentDAO.save(tempStudent);

//		display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student . Generated Id: " + theId);


//		retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

//		display student
		System.out.println("Found the student: " + myStudent);


	}

	private  void createMultipleStudents(StudentDAO studentDAO) {
//		create multiple student
		Student tempStudent1 = new Student("Dhanam","Bakiyam","321@gmail.com");
		Student tempStudent2 = new Student("Dinesh","kumar","456@gmail.com");
		Student tempStudent3 = new Student("Chandra","sekar","777@gmail.com");

        System.out.println("inside");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);


	}
	private void createStudent(StudentDAO studentDAO) {
//		create the student object
		System.out.println("create a new student object..");
		Student tempStudent = new Student("Banu","Priya","123@gmail.com");
//		save the student object
		System.out.println("Save");
		studentDAO.save(tempStudent);
//		display  id of the saved student
		System.out.println("saved student detail: " + tempStudent.getId());
	}
}
