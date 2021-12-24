package com.example.JPA05MonAn.services.impls;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JPA05MonAn.models.MonAn;
import com.example.JPA05MonAn.repositories.IMonAnRepository;
import com.example.JPA05MonAn.services.IMonAnService;

@Service
public class MonAnService implements IMonAnService {
	@Autowired
	IMonAnRepository monAnRepository;
	
	public boolean kiemTraMonAn(int monAnId) {
		Optional<MonAn> optional = Optional.empty();
		if(monAnRepository.findById(monAnId) != optional)
			return true;
		return false;
	}
	
	@Override
	public List<MonAn> getAll() {
		return monAnRepository.findAll();
	}

	@Override
	public void add(MonAn monAn) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();

		Set<ConstraintViolation<MonAn>> violations = validator.validate(monAn);
		violations.forEach(x -> {
			x.getMessage();
		});

		if (violations.size() == 0)
			monAnRepository.save(monAn);
	}

	@Override
	public List<MonAn> timKiemMonAn(String tenMon, String tenNguyenLieu) {
		List<MonAn> listMonAn = new ArrayList<MonAn>();
		monAnRepository.findAll().forEach(x -> {
			if(x.getTenMon().toLowerCase().contains(tenMon.toLowerCase())) {
//				phương án backup để tìm kiếm khi xóa 1 field công thức nào đó
//				if(x.getCachLam().toLowerCase().contains(tenNguyenLieu.toLowerCase()))
//					listMonAn.add(x);
				
				x.getListCongThuc().forEach(y -> {
					if(y.getNguyenLieu().getTenNguyenLieu().toLowerCase()
							.contains(tenNguyenLieu.toLowerCase()))
						listMonAn.add(x);
				});
			}
		});
		return listMonAn;
	}
	
}
