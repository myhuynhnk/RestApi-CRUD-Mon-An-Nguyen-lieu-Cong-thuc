package com.example.JPA05MonAn.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.JPA05MonAn.models.LoaiMonAn;
import com.example.JPA05MonAn.services.ILoaiMonAnService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/loaimonan")
public class LoaiMonAnController {
	@Autowired
	ILoaiMonAnService loaiMonAnService;
	
	
	@GetMapping(value="/hienthi", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LoaiMonAn> hienThiLoaiMonAn() {
		return loaiMonAnService.getAll();
	}
	
	@PostMapping(value="/themloaimonan", produces = MediaType.APPLICATION_JSON_VALUE)
	public void themLoaiMonAn(@RequestBody String loaimonan) {
		Gson gson = new Gson();
		LoaiMonAn loaiMonAnMoi = gson.fromJson(loaimonan, LoaiMonAn.class);
		loaiMonAnService.add(loaiMonAnMoi);
	}
	
	@DeleteMapping(value="/xoa")
	public String xoaLoaiMonAn(@RequestParam int loaiMonAnId) {
		if(!loaiMonAnService.kiemTraLoaiMonAn(loaiMonAnId))
			return "Loại món ăn không tồn tại";
		else
			loaiMonAnService.delete(loaiMonAnService.getOne(loaiMonAnId));
		return "Loại món ăn "+loaiMonAnId+ " đã được xóa ";
		
//		monAnRepository.findAll().forEach(x -> {
//			if(x.getLoaiMonAn().getLoaiMonAnID() == loaiMonAnId) {// Kiểm tra loại món ăn nằm trong bảng món ăn
//				congThucRepository.findAll().forEach(y -> {
//					if(y.getMonAn() == x) ////Kiểm tra món ăn đang tồn tại trong bảng công thức
//						congThucRepository.delete(y);// xóa công thức có tồn tại món ăn đang xét
//				});
//				monAnRepository.delete(x);// xóa món ăn có chứa loại món ăn đó
//			}	
//		});
//		loaiMonAnRepository.deleteById(loaiMonAnId);
	}
}
