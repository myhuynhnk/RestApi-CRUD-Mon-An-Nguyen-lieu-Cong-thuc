package com.example.JPA05MonAn.services.impls;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.JPA05MonAn.models.CongThuc;
import com.example.JPA05MonAn.models.MonAn;
import com.example.JPA05MonAn.repositories.ICongThucRepository;
import com.example.JPA05MonAn.repositories.IMonAnRepository;
import com.example.JPA05MonAn.repositories.INguyenLieuRepository;

import org.springframework.stereotype.Service;

import com.example.JPA05MonAn.services.ICongThucService;

@Service
public class CongThucService implements ICongThucService{
	@Autowired 
	ICongThucRepository congThucRepository;
	
	@Autowired
	IMonAnRepository monAnRepository;
	
	@Autowired
	INguyenLieuRepository nguyenLieuRepository;

	@Override
	public List<CongThuc> getAll() {
		return congThucRepository.findAll();
	}

	@Override
	public void add(CongThuc congThuc) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();

		Set<ConstraintViolation<CongThuc>> violations = validator.validate(congThuc);
		violations.forEach(x -> {
			x.getMessage();
		});

		if (violations.size() == 0) {
			congThucRepository.save(congThuc);
			MonAn monAnHienTai = monAnRepository.getById(congThuc.getMonAn().getMonAnID());
			monAnHienTai.setCachLam( monAnHienTai.getCachLam() + // Thêm được một nguyên liệu thì cộng dồn nguyên liệu tiếp theo khác
					nguyenLieuRepository.getById(congThuc.getNguyenLieu().getNguyenLieuID()).getTenNguyenLieu()
					+" : "+ congThuc.getSoLuong() +" "+congThuc.getDonViTinh()+ ", ");
			monAnRepository.save(monAnHienTai);
		}
	}
}
