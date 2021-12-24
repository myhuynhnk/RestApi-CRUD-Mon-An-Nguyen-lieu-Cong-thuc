package com.example.JPA05MonAn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.JPA05MonAn.models.CongThuc;

@Repository
public interface ICongThucRepository extends JpaRepository<CongThuc, Integer> {

}
