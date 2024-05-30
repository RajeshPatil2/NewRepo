package com.application.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Result {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Lob
	@Column(length = 999999999)
	private byte[] sem1;

	@Lob
	@Column(length = 999999999)
	private byte[] sem2;

	@Lob
	@Column(length = 999999999)
	private byte[] sem3;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getSem1() {
		return sem1;
	}

	public void setSem1(byte[] sem1) {
		this.sem1 = sem1;
	}

	public byte[] getSem2() {
		return sem2;
	}

	public void setSem2(byte[] sem2) {
		this.sem2 = sem2;
	}

	public byte[] getSem3() {
		return sem3;
	}

	public void setSem3(byte[] sem3) {
		this.sem3 = sem3;
	}
}
