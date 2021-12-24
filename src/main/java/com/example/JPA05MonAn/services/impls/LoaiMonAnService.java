package com.example.JPA05MonAn.services.impls;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JPA05MonAn.models.LoaiMonAn;
import com.example.JPA05MonAn.repositories.ICongThucRepository;
import com.example.JPA05MonAn.repositories.ILoaiMonAnRepository;
import com.example.JPA05MonAn.repositories.IMonAnRepository;
import com.example.JPA05MonAn.services.ILoaiMonAnService;

@Service
public class LoaiMonAnService implements ILoaiMonAnService {
	@Autowired
	ILoaiMonAnRepository loaiMonAnRepository;
	
	@Autowired
	IMonAnRepository monAnRepository;
	
	@Autowired
	ICongThucRepository congThucRepository;
	
	
	@Override
	public boolean kiemTraLoaiMonAn(int loaiMonAnId) {
		Optional<LoaiMonAn> optional = Optional.empty();
		if(loaiMonAnRepository.findById(loaiMonAnId) != optional)
			return true;
		return false;
	}


	@Override
	public List<LoaiMonAn> getAll() {
		return loaiMonAnRepository.findAll();
	}

	@Override
	public void add(LoaiMonAn loaiMonAn) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();

		Set<ConstraintViolation<LoaiMonAn>> violations = validator.validate(loaiMonAn);
		violations.forEach(x -> {
			x.getMessage();
		});

		if (violations.size() == 0)
			loaiMonAnRepository.save(loaiMonAn);

	}

	@Override
	public void delete(LoaiMonAn loaiMonAn) {
		// Kiểm tra sự ràng buộc của loại món ăn với các bảng (quan hệ 1-n)
		// Nếu có thì xóa ràng buộc (khóa chính - khóa ngoại ) ở các bảng nhiều
		// Ràng buộc loaimonan -> monan -> congthuc
		// Xóa các liên quan từ các bảng kia trước sau đó mới xóa được trong loai món ăn
		
		loaiMonAn.getListMonAn().forEach(x -> {
			if(x.getLoaiMonAn() == loaiMonAn) {// Kiểm tra loại món ăn nằm trong bảng món ăn
				x.getListCongThuc().forEach(y -> {
					if(y.getMonAn() == x)   //Kiểm tra món ăn đang tồn tại trong bảng công thức			
						congThucRepository.delete(y);  // xóa công thức có tồn tại món ăn đang xét
				});
				monAnRepository.delete(x); // xóa món ăn có chứa loại món ăn đó
			}
				
		});
		loaiMonAnRepository.delete(loaiMonAn);
	}

	@Override
	public LoaiMonAn getOne(int loaimonanid) {
		return loaiMonAnRepository.getById(loaimonanid);
	}

	
}
