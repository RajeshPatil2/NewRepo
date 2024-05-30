package com.application.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Addmission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    @Column(length = 999999999)
    private byte[] tenMarksheet;

    @Lob
    @Column(length = 999999999)
    private byte[] twelveMarksheet;

    @Lob
    @Column(length = 999999999)
    private byte[] aadharCard;

    @Lob
    @Column(length = 999999999)
    private byte[] panCard;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getTenMarksheet() {
		return tenMarksheet;
	}

	public void setTenMarksheet(byte[] tenMarksheet) {
		this.tenMarksheet = tenMarksheet;
	}

	public byte[] getTwelveMarksheet() {
		return twelveMarksheet;
	}

	public void setTwelveMarksheet(byte[] twelveMarksheet) {
		this.twelveMarksheet = twelveMarksheet;
	}

	public byte[] getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(byte[] aadharCard) {
		this.aadharCard = aadharCard;
	}

	public byte[] getPanCard() {
		return panCard;
	}

	public void setPanCard(byte[] panCard) {
		this.panCard = panCard;
	}
}
