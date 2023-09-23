package com.example.demo.Model;


import java.sql.Date;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToOne;
@Entity
public class Fruit {
	@Id
	@GeneratedValue
	private int tid;
	private int amount;
	private Date date;
	private String status;
	public int gettid() {
		return tid;
	}
	public void settid(int tid) {
		this.tid = tid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getdate() {
		return date;
	}
	public void setDonation_date(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Fruit(int tid, int amount, Date date, String status) {
		super();
		this.tid = tid;
		this.amount = amount;
		this.date = date;
		this.status = status;
	}
	public Fruit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}