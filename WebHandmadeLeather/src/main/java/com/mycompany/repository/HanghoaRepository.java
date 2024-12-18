package com.mycompany.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mycompany.models.HanghoaModel;

@Repository
public interface HanghoaRepository extends JpaRepository<HanghoaModel, String> {
}