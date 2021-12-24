package com.example.JPA05MonAn.services;

import java.util.List;

import com.example.JPA05MonAn.models.LoaiMonAn;

public interface ILoaiMonAnService {
	List<LoaiMonAn> getAll();
	void add(LoaiMonAn loaiMonAn);
	void delete (LoaiMonAn loaiMonAn);
	LoaiMonAn getOne(int loaimonanid);
	boolean kiemTraLoaiMonAn(int loaiMonAnId);
}
