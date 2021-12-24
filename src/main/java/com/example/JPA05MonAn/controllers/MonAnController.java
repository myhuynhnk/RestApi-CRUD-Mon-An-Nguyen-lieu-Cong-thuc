package com.example.JPA05MonAn.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.JPA05MonAn.models.MonAn;
import com.example.JPA05MonAn.services.ILoaiMonAnService;
import com.example.JPA05MonAn.services.IMonAnService;
import com.google.gson.Gson;


@RestController
@RequestMapping("/monan")
public class MonAnController {
	@Autowired
	IMonAnService monAnService;
	
	@Autowired
	ILoaiMonAnService loaiMonAnService;
	
	@GetMapping(value="/hienthi", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MonAn> hienThiMonAn() {
		return monAnService.getAll();
	}
	
	@PostMapping(value="/themmonan", produces = MediaType.APPLICATION_JSON_VALUE)
	public String themMonAn(@RequestBody String monan) {
		Gson gson = new Gson();
		MonAn monAnMoi = gson.fromJson(monan, MonAn.class);

		if(!loaiMonAnService.kiemTraLoaiMonAn(monAnMoi.getLoaiMonAn().getLoaiMonAnID()))
			return "Loại món ăn không tồn tại";
		else
			monAnService.add(monAnMoi);
		return "Thêm món ăn "+monAnMoi.getTenMon() +" thành công";
	}
	
	@GetMapping(value="/timkiem")
	public List<MonAn> timKiemMonAn(@RequestParam String tenMonAn , String tenNguyenLieu) {
		return monAnService.timKiemMonAn(tenMonAn, tenNguyenLieu);

	}
}
