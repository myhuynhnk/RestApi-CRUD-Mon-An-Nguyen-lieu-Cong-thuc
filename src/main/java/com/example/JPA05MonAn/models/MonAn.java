package com.example.JPA05MonAn.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
public class MonAn {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int monAnID;
	
	@Column
	@Size(max = 20, message = "Ten mon an khong duoc qua 20 ly tu")
	private String tenMon;
	
	@Column
	private double giaBan;
	
	@Column
	private String gioiThieu;
	
	@Column
	private String cachLam;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="loaiMonAnID", foreignKey = @ForeignKey(name="fk_loaimonan_monan"))
	@JsonIgnoreProperties(value="listMonAn")
	private LoaiMonAn loaiMonAn;
	
	@OneToMany(mappedBy = "monAn")
	@JsonIgnoreProperties(value="monAn")
	private List<CongThuc> listCongThuc;

	public int getMonAnID() {
		return monAnID;
	}

	public void setMonAnID(int monAnID) {
		this.monAnID = monAnID;
	}

	public String getTenMon() {
		return tenMon;
	}

	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public String getGioiThieu() {
		return gioiThieu;
	}

	public void setGioiThieu(String gioiThieu) {
		this.gioiThieu = gioiThieu;
	}

	public String getCachLam() {
		return cachLam;
	}

	public void setCachLam(String cachLam) {
		this.cachLam = cachLam;
	}

	public LoaiMonAn getLoaiMonAn() {
		return loaiMonAn;
	}

	public void setLoaiMonAn(LoaiMonAn loaiMonAn) {
		this.loaiMonAn = loaiMonAn;
	}

	public List<CongThuc> getListCongThuc() {
		return listCongThuc;
	}

	public void setListCongThuc(List<CongThuc> listCongThuc) {
		this.listCongThuc = listCongThuc;
	}
	
	
}