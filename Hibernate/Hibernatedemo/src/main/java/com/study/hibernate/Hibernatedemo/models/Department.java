package com.study.hibernate.Hibernatedemo.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dept_id;

	private String deptname;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private List<Student> students;

	public Department() {
	}

	public Department(String deptname) {
		super();
		this.deptname = deptname;
	}

	public int getDept_id() {
		return dept_id;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public List<Student> getStudent() {
		return students;
	}

	public void setStudent(List<Student> student) {
		this.students = student;
	}

	@Override
	public String toString() {
		return "Department [dept_id=" + dept_id + ", deptname=" + deptname + "]";
	}

}
