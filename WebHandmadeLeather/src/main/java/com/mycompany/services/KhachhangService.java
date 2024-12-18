package com.mycompany.services;

import com.mycompany.models.KhachhangModel;
import com.mycompany.repository.KhachhangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachhangService {

    @Autowired
    private KhachhangRepository productRepository;

    public List<KhachhangModel> getAllProducts() {
        return productRepository.findAll();
    }
   
    public Boolean addProduct(KhachhangModel product) {
        try {
            productRepository.save(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean editKhachhang(KhachhangModel product) {
        try {
            productRepository.save(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    public Boolean deleteKhachhang(KhachhangModel product) {
    	try { this.productRepository.delete(product);
    	return true;
    	}
    	catch (Exception e) {
    		
    	}
    	return false;
    }
}
