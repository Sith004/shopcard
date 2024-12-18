package com.mycompany.services;


import com.mycompany.models.TaikhoanModel;
import com.mycompany.repository.TaikhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaikhoanService {

    @Autowired
    private TaikhoanRepository taikhoanRepository;

    public List<TaikhoanModel> getAllTaikhoan() {
        return taikhoanRepository.findAll();
    }

    public Boolean addTaikhoan(TaikhoanModel taikhoan) {
    	try { this.taikhoanRepository.save(taikhoan);
    	return true;
    	}
    	catch (Exception e) {
    		
    	}
    	return false;
    }
    public Boolean editTaikhoan(TaikhoanModel taikhoan) {
    	try { this.taikhoanRepository.save(taikhoan);
    	return true;
    	}
    	catch (Exception e) {
    		
    	}
    	return false;
    }
    public Boolean deleteTaikhoan(TaikhoanModel taikhoan) {
    	try { this.taikhoanRepository.delete(taikhoan);
    	return true;
    	}
    	catch (Exception e) {
    		
    	}
    	return false;
    }
    public boolean kiemTraDangNhap(String maDangNhap, String matKhau) {
        
        TaikhoanModel taiKhoan = taikhoanRepository.findByMaDangNhapAndMatKhau(maDangNhap, matKhau);
        return taiKhoan != null;  
    }
    
}
