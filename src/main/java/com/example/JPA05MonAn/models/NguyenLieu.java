package com.example.JPA05MonAn.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
public class NguyenLieu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nguyenLieuID;
	
	@Column
	@Size(max = 20, message = "ten nguyen lieu khong duoc qua 20 ky tu")
	private String tenNguyenLieu;
	
	@Column
	private String ghiChu;
	
	@OneToMany(mappedBy = "nguyenLieu", fetch = FetchType.EAGER)
	@JsonIgnoreProperties(value="nguyenLieu")
	private List<CongThuc> listCongThuc;

	public int getNguyenLieuID() {
		return nguyenLieuID;
	}

	public void setNguyenLieuID(int nguyenLieuID) {
		this.nguyenLieuID = nguyenLieuID;
	}

	public String getTenNguyenLieu() {
		return tenNguyenLieu;
	}

	public void setTenNguyenLieu(String tenNguyenLieu) {
		this.tenNguyenLieu = tenNguyenLieu;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public List<CongThuc> getListCongThuc() {
		return listCongThuc;
	}

	public void setListCongThuc(List<CongThuc> listCongThuc) {
		this.listCongThuc = listCongThuc;
	}
	
	
}