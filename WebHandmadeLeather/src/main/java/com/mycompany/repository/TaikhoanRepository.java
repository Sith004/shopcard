package com.mycompany.repository;

import com.mycompany.models.TaikhoanModel;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface TaikhoanRepository extends JpaRepository<TaikhoanModel, String> {
	TaikhoanModel findByMaDangNhapAndMatKhau(String maDangNhap, String matKhau);
}
