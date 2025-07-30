package com.study.hibernate.Hibernatedemo.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Studentname", nullable = false)
	private String name;
	@Column(name = "rollno")
	private int roll;

	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
	private IdCard card;

	@ManyToOne
	@JoinColumn(name = "dept_id")
	private Department department;

	@ManyToMany
	@JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> courses;

	public Student() {
	}

	public Student(String name, int roll) {
		super();
		this.name = name;
		this.roll = roll;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public IdCard getCard() {
		return card;
	}

	public void setCard(IdCard card) {
		this.card = card;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", roll=" + roll + ", card=" + card + ", department="
				+ department + ", courses=" + courses+ "]";
	}


}
