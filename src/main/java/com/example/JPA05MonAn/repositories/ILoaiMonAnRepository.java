package com.example.JPA05MonAn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.JPA05MonAn.models.LoaiMonAn;

@Repository
public interface ILoaiMonAnRepository extends JpaRepository<LoaiMonAn, Integer> {

}
