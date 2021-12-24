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
public class LoaiMonAn {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loaiMonAnID;
	
	@Column
	@Size(max = 20, message = "ten loai khong duoc qua 20 ky tu")
	private String tenLoai;
	
	@Column
	private String moTa;
	
	@OneToMany(mappedBy = "loaiMonAn", fetch = FetchType.EAGER)
	@JsonIgnoreProperties(value="loaiMonAn")
	private List<MonAn> listMonAn;

	public int getLoaiMonAnID() {
		return loaiMonAnID;
	}

	public void setLoaiMonAnID(int loaiMonAnID) {
		this.loaiMonAnID = loaiMonAnID;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public List<MonAn> getListMonAn() {
		return listMonAn;
	}

	public void setListMonAn(List<MonAn> listMonAn) {
		this.listMonAn = listMonAn;
	}
	
	
}

