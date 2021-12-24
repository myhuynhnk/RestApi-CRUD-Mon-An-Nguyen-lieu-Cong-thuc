package com.example.JPA05MonAn.services.impls;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.JPA05MonAn.models.NguyenLieu;
import com.example.JPA05MonAn.repositories.INguyenLieuRepository;
import com.example.JPA05MonAn.services.INguyenLieuService;

@Service
public class NguyenLieuService implements INguyenLieuService {
	@Autowired
	INguyenLieuRepository nguyenLieuRepository;
	
	@Override
	public List<NguyenLieu> getAll() {
		return nguyenLieuRepository.findAll();
	}

	@Override
	public void add(NguyenLieu nguyenLieu) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();

		Set<ConstraintViolation<NguyenLieu>> violations = validator.validate(nguyenLieu);
		violations.forEach(x -> {
			x.getMessage();
		});

		if (violations.size() == 0)
			nguyenLieuRepository.save(nguyenLieu);
	}
	
}
