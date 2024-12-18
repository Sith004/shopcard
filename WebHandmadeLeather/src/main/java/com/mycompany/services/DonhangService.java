package com.mycompany.services;

import com.mycompany.models.DonhangModel;
import com.mycompany.repository.DonhangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonhangService {

    @Autowired
    private DonhangRepository DhRepository;

    public List<DonhangModel> getAllDonhang() {
        return this.DhRepository.findAll();
    }
   
    public Boolean addDonhang(DonhangModel product) {
        try {
        	this.DhRepository.save(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean editDonhang(DonhangModel product) {
        try {
        	this.DhRepository.save(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    public Boolean deleteDonhang(DonhangModel product) {
    	try { this.DhRepository.delete(product);
    	return true;
    	}
    	catch (Exception e) {
    		
    	}
    	return false;
    }
}