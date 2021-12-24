package com.example.JPA05MonAn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JPA05MonAn.models.NguyenLieu;
import com.example.JPA05MonAn.services.INguyenLieuService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/nguyenlieu")
public class NguyenLieuControlller {
	@Autowired
	INguyenLieuService nguyenLieuService;
	
	@GetMapping(value="/hienthi", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<NguyenLieu> hienThiNguyenLieu() {
		return nguyenLieuService.getAll();
	}
	
	
	@PostMapping(value="/them", produces = MediaType.APPLICATION_JSON_VALUE)
	public void themNguyenLieu(@RequestBody String nguyenLieu) {
		Gson gson = new Gson();
		NguyenLieu nguyenLieuMoi = gson.fromJson(nguyenLieu, NguyenLieu.class);
		
		nguyenLieuService.add(nguyenLieuMoi);
	}
}
