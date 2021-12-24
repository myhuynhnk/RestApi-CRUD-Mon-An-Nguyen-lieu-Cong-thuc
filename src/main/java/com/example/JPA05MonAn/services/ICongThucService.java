package com.example.JPA05MonAn.services;

import java.util.List;

import com.example.JPA05MonAn.models.CongThuc;

public interface ICongThucService {
	List<CongThuc> getAll();
	void add(CongThuc congThuc);
}
