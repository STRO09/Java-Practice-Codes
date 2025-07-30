package com.study.hibernate.Hibernatedemo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.study.hibernate.Hibernatedemo.models.Course;
import com.study.hibernate.Hibernatedemo.models.Department;
import com.study.hibernate.Hibernatedemo.models.IdCard;
import com.study.hibernate.Hibernatedemo.models.Student;
import com.study.hibernate.Hibernatedemo.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App {

	public static void insertData(int roll, String name) {
		// create
		Student student = new Student(name, roll);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		// insert
		session.persist(student);
		transaction.commit();
		session.close();

		System.out.println("Student saved successfully.");

	}

	public static void returnData(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Student student = session.get(Student.class, id);
		session.close();
		if (student != null) {
			System.out.println("Student ID: " + student.getId() + ", Name: " + student.getName() + ", Marks: "
					+ student.getRoll());
		} else {
			System.out.println("Student not found");
		}
	}

	public static void updateData(int id, int newroll, String newname) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Student student = session.get(Student.class, id); // FETCHED OBJ BECOME PERSISTENT. MEANING CHANGES TO THE
															// OBJECT WILL BE AUTOMATICALLY PERSISTED(insert)
		Transaction transaction = session.beginTransaction();
		if (student != null) {
			// if you want to allow nulls use Integer for roll
			if (newroll != 0) {
				student.setRoll(newroll);
			}
			if (newname != null) {
				student.setName(newname);
			}
			// session.update(student); Optional — Hibernate auto tracks changes
			transaction.commit();
			System.out.println("Student Updated Successfully");
		} else {
			transaction.rollback();
			System.out.println("No student with given ID found");
		}

		session.close();
	}

	public static void readData() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			List<Student> studentList = session.createQuery("FROM Student", Student.class).getResultList();
			if (studentList.isEmpty()) {
				System.out.println("No Data present in Student Table");
			} else {
				System.out.println("Reading student table....");
				studentList.forEach(System.out::println);
			}
			session.close();
		} catch (Exception e) {
			e.printStackTrace(); // Add this to get full error
		}

	}

	public static void deleteData(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Student student = session.get(Student.class, id);
		Transaction transaction = session.beginTransaction();
		if (student != null) {

			session.delete(student);
			transaction.commit();
			System.out.println("Student Deleted Successfully");
		} else {
			transaction.rollback();
			System.out.println("No student with given ID found");
		}

		session.close();
	}

	public static void assignCard(int id, String cardname) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Student student = session.get(Student.class, id);
		if (student != null) {
			IdCard card = new IdCard(cardname);
			card.setStudent(student);
			student.setCard(card);

			Transaction transaction = session.beginTransaction();
			session.persist(student);
			transaction.commit();
			session.close();
			System.out.println("Id Card assigned successfully");
		} else {
			System.out.println("No Student with given ID found");
		}
	}

	public static void createDepartment(String deptname) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Department department = new Department(deptname);
		Transaction transaction = session.beginTransaction();
		session.persist(department);
		transaction.commit();
		session.close();
		System.out.println("Department inserted successfully");

	}

	public static void assignDepartment(int studentid, int deptid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Student student = session.get(Student.class, studentid);
		Department department = session.get(Department.class, deptid);

		if (student != null) {

			if (department != null) {

				Transaction transaction = session.beginTransaction();
				student.setDepartment(department);
				session.update(student);
				transaction.commit();
				session.close();
				System.out.println("Assigned department - " + department.getDeptname() + " to " + student.getName());
			} else {
				System.out.println("No such department found with given id");
			}
		} else {
			System.out.println("No student found with given id");
		}
	}

	public static void fetchAllStudentsInDept(int deptid) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Department department = session.get(Department.class, deptid);
			List<Student> studentlistfordept = department.getStudent();
			System.out.println("Fetching all students from department: "+department.getDeptname());
			studentlistfordept.forEach(System.out::println);
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void createCourses(String coursename) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Course course = new Course();
		course.setCoursename(coursename);
		Transaction transaction = session.beginTransaction();
		session.persist(course);
		transaction.commit();
		session.close();
		System.out.println("Course created successfully");
	}

	public static void assignCourses(int studentid, List<String> courses) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		try {
			Student student = session.get(Student.class, studentid);

			if (student != null) {

				for (String cname : courses) {
					Course course = (Course) session.createQuery("FROM Course where coursename = :cname")
							.setParameter("cname", cname).uniqueResult();
					if (course != null) {

						student.getCourses().add(course);
						System.out.println("Student assigned with given course");

					} else {
						System.out.println("Given Course: " + cname + " does not exist");

					}
				}

				session.persist(student);

				transaction.commit();

			} else {
				System.out.println("NO such student  found with the given id");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			session.close();
		}
	}

	public static void main(String[] args) {

//		insertData(99, "Theseus");
//
//		returnData(1);
//		returnData(54);
////
//		updateData(1, 95, null);
//		returnData(1);
//
//		readData();
//		deleteData(2);
//		returnData(2);
//		readData();
//		assignCard(1, "S123");
//		getStudentIdDetails(1);
//		insertData(90, "Stro");
//		insertData(97, "Sagar");
////
////		createDepartment("Information Technology");
////		createDepartment("Computer Science");
////		createDepartment("MEchanical Engineering");
////		createDepartment("EXTC");
////		
//		assignDepartment(2,2);
//		assignDepartment(3,4);
		readData();
		fetchAllStudentsInDept(2);
//		createCourses("OS");
//		createCourses("ADSA");
//		createCourses("DSA");
//		assignCourses(2, Arrays.asList("OS", "DSA", "AIML"));
	}
}
