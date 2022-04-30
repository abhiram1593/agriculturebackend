package net.javaguides.springboot.model;
import javax.persistence.*;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.*;
import javax.persistence.spi.*;

@Entity
@Table(name="profiles")

public class profile{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long loanid;
	
	@Column(name = "name")
	private String name;
	@Column(name = "ph_number")
	private long ph_number;
	@Column(name = "email_id")
	private String email_id;
	@Column(name = "Address")
	private String Address;
	@Column(name = "monthlyemi")
	private long monthlyemi;


	
	
	public profile() {
		
	}
	
	public profile(String name, long ph_number, String email_id, String address, long monthlyemi) {
		super();
		this.name = name;
		this.ph_number = ph_number;
		this.email_id = email_id;
		this.Address = address;
		this.monthlyemi = monthlyemi;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPh_number() {
		return ph_number;
	}
	public void setPh_number(long Ph_number) {
		this.ph_number = Ph_number;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public long getLoanid() {
		return loanid;
	}
	public void setLoanid(int loanid) {
		this.loanid = loanid;
	}
	public long getMonthlyemi() {
		return monthlyemi;
	}
	public void setMonthlyemi(long monthlyemi) {
		this.monthlyemi = monthlyemi;
	}

}
