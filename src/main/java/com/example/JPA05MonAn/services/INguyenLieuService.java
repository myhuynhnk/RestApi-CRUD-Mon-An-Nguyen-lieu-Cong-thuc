package com.example.JPA05MonAn.services;

import java.util.List;

import com.example.JPA05MonAn.models.NguyenLieu;

public interface INguyenLieuService {
	List<NguyenLieu> getAll();
	void add(NguyenLieu nguyenLieu);
}
