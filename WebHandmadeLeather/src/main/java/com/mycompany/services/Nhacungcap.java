package com.mycompany.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.repository.NhacungcapRepository;
import com.mycompany.models.NhacungcapModels;
import java.util.List;

@Service
public class Nhacungcap {

    @Autowired
    private NhacungcapRepository NCCRepository;

    public List<NhacungcapModels> getAllNhacungcap() {
        return this.NCCRepository.findAll();
    }
   
    public Boolean addNhacungcap(NhacungcapModels nhacungcap) {
        try {
        	this.NCCRepository.save(nhacungcap);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean editNhacungcap(NhacungcapModels nhacungcap) {
        try {
        	this.NCCRepository.save(nhacungcap);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    public Boolean deleteNhacungcap(NhacungcapModels nhacungcap) {
    	try { this.NCCRepository.delete(nhacungcap);
    	return true;
    	}
    	catch (Exception e) {
    		
    	}
    	return false;
    }
}