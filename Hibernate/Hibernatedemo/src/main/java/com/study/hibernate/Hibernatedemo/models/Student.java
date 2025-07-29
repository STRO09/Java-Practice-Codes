package com.study.hibernate.Hibernatedemo.models;

import javax.persistence.*;

@Entity
@Table(name="Student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Studentname", nullable = false)
	private String name;
	@Column(name = "marks")
	private int marks;

	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
	private IdCard card;
	
	public Student() {}

	public Student(String name, int marks) {
		super();
		this.name = name;
		this.marks = marks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public IdCard getCard() {
		return card;
	}

	public void setCard(IdCard card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + ", card=" + card + "]";
	}

}
