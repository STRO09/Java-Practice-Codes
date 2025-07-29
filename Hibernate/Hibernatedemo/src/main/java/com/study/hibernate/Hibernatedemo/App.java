package com.study.hibernate.Hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.study.hibernate.Hibernatedemo.models.IdCard;
import com.study.hibernate.Hibernatedemo.models.Student;
import com.study.hibernate.Hibernatedemo.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App {

	public static void insertData(int marks, String name) {
		// create
		Student student = new Student(name, marks);
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
					+ student.getMarks());
		} else {
			System.out.println("Student not found");
		}
	}

	public static void updateData(int id, int newmarks, String newname) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Student student = session.get(Student.class, id); // FETCHED OBJ BECOME PERSISTENT. MEANING CHANGES TO THE OBJECT WILL BE AUTOMATICALLY PERSISTED(insert)
		Transaction transaction = session.beginTransaction();
		if (student != null) {
			// if you want to allow nulls use Integer for marks
			if (newmarks != 0) {
				student.setMarks(newmarks);
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
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Student> studentList = session.createQuery("from Student", Student.class).getResultList();
		session.close();
		if (studentList.isEmpty()) {
			System.out.println("No Data present in Student Table");
		} else {
			studentList.forEach(System.out::println);
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

	public static void getStudentIdDetails(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Student student = session.get(Student.class, id);
		if (student != null) {

			System.out.println(student);
		} else {

			System.out.println("No Student with given ID found");
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
		getStudentIdDetails(1);

	}
}
