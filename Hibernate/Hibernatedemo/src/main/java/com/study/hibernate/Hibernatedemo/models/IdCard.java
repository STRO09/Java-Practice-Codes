package com.study.hibernate.Hibernatedemo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class IdCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cardid;
	
	private String cardName;
	
	
	@OneToOne
	@JoinColumn(name="student_id")
	private Student student;
	
	public IdCard() {}

	public IdCard(String cardName) {
		super();
		this.cardName = cardName;
	}

	public int getCardid() {
		return cardid;
	}


	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "IdCard [cardid=" + cardid + ", cardName=" + cardName + "]";
	}

	
}
