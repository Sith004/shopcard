package com.mycompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.models.DonhangModel;

public interface DonhangRepository extends JpaRepository <DonhangModel, Integer> {

}
