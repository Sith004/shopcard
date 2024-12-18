package com.mycompany.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nhacungcap")
public class NhacungcapModels {

    @Id
    private String Mancc;
    private String tenncc;
    private String thongtinlienlac;

    public NhacungcapModels() {
    }

    // Constructor có tham số
    public NhacungcapModels(String Mancc, String tenncc, String thongtinlienlac) {
        super();
       this.Mancc = Mancc;
       this.tenncc = tenncc;
       this.thongtinlienlac = thongtinlienlac;
       
    }

	public String getMancc() {
		return Mancc;
	}

	public void setMancc(String mancc) {
		Mancc = mancc;
	}

	public String getTenncc() {
		return tenncc;
	}

	public void setTenncc(String tenncc) {
		this.tenncc = tenncc;
	}

	public String getThongtinlienlac() {
		return thongtinlienlac;
	}

	public void setThongtinlienlac(String thongtinlienlac) {
		this.thongtinlienlac = thongtinlienlac;
	}

    
}

