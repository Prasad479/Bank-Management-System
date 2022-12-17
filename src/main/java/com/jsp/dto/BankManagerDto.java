package com.jsp.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BankManager")
public class BankManagerDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String gmail;
	private long cno;
	private String status;
	
	@ManyToOne
	@JoinColumn
	private AdminDto admin;
	
	@OneToMany(mappedBy = "bankManager")
	private List<CustomerDto> customer;

	public List<CustomerDto> getCustomer() {
		return customer;
	}

	public void setCustomer(List<CustomerDto> customer) {
		this.customer = customer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public AdminDto getAdmin() {
		return admin;
	}

	public void setAdmin(AdminDto admin) {
		this.admin = admin;
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

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public long getCno() {
		return cno;
	}

	public void setCno(long cno) {
		this.cno = cno;
	}

	public AdminDto getAdminDto() {
		return admin;
	}

	public void setAdminDto(AdminDto adminDto) {
		this.admin = adminDto;
	}
}
