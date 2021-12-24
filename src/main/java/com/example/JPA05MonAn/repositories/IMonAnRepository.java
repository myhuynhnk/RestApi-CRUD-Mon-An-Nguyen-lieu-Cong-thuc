package com.example.JPA05MonAn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.JPA05MonAn.models.MonAn;

@Repository
public interface IMonAnRepository extends JpaRepository<MonAn, Integer> {

}
