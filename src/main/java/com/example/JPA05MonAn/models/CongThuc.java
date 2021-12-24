package com.example.JPA05MonAn.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
public class CongThuc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int congThucID;
	
	@Column
	private int soLuong;
	
	@Column
	@Size(max = 10, message = "don vi tinh khong duoc qua 10 ky tu")
	private String donViTinh;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="monAnID", foreignKey = @ForeignKey(name="fk_monan_congthuc"))
	@JsonIgnoreProperties(value="listCongThuc")
	private MonAn monAn;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="nguyenLieuID", foreignKey = @ForeignKey(name="fk_nguyenlieu_congthuc"))
	@JsonIgnoreProperties(value="listCongThuc")
	private NguyenLieu nguyenLieu;

	public int getCongThucID() {
		return congThucID;
	}

	public void setCongThucID(int congThucID) {
		this.congThucID = congThucID;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public MonAn getMonAn() {
		return monAn;
	}

	public void setMonAn(MonAn monAn) {
		this.monAn = monAn;
	}

	public NguyenLieu getNguyenLieu() {
		return nguyenLieu;
	}

	public void setNguyenLieu(NguyenLieu nguyenLieu) {
		this.nguyenLieu = nguyenLieu;
	}
	
	
}