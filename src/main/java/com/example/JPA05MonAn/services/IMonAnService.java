package com.example.JPA05MonAn.services;

import java.util.List;

import com.example.JPA05MonAn.models.MonAn;

public interface IMonAnService {
	List<MonAn> getAll();
	void add(MonAn monAn);
	boolean kiemTraMonAn(int monAnId);
	List<MonAn> timKiemMonAn(String tenMon, String tenNguyenLieu);
}
