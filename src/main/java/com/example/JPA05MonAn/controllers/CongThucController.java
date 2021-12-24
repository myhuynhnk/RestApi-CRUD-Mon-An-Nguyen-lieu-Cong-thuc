package com.example.JPA05MonAn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import com.example.JPA05MonAn.models.CongThuc;
import com.example.JPA05MonAn.services.ICongThucService;
import com.example.JPA05MonAn.services.IMonAnService;
import com.google.gson.Gson;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/congthuc")
public class CongThucController {
	@Autowired
	ICongThucService congThucService;
	
	@Autowired
	IMonAnService monAnService;
	
	@GetMapping(value="/hienthi", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CongThuc> hienThiCongThuc() {
		return congThucService.getAll();
	}
	
	@PostMapping(value="/themcongthuc", produces = MediaType.APPLICATION_JSON_VALUE)
	public String themCongThucChoMonAn(@RequestBody String congthuc) {
		Gson gson = new Gson();
		CongThuc congThucMoi = gson.fromJson(congthuc, CongThuc.class);
		
		if(!monAnService.kiemTraMonAn(congThucMoi.getMonAn().getMonAnID()))
			return "Món ăn không tồn tại";
		else
			congThucService.add(congThucMoi);
		return "Thêm công thức cho món ăn thành công";	
	}
}
