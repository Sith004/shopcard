package com.mycompany.repository;
import com.mycompany.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachhangRepository extends JpaRepository<KhachhangModel, String> {
}