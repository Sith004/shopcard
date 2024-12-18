package com.mycompany.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hanghoa")
public class HanghoaModel {

    @Id
    private String Mahh; 
    private String ten; 
    private String mota; 
    private String gia; 
    private String soluongton;
    private String anh; 
    private String Mancc; 
    private Date createdAt;

    // Getter và Setter
    public String getMahh() {
        return Mahh;
    }

    public void setMahh(String Mahh) {
        this.Mahh = Mahh;
    }

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getGia() {
		return gia;
	}

	public void setGia(String gia) {
		this.gia = gia;
	}

	public String getSoluongton() {
		return soluongton;
	}

	public void setSoluongton(String soluongton) {
		this.soluongton = soluongton;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public String getMancc() {
		return Mancc;
	}

	public void setMancc(String mancc) {
		Mancc = mancc;
	}

	public HanghoaModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	

	public HanghoaModel(String Mahh, String ten, String mota, String gia, String soluongton, String anh, String Mancc, Date createdAt) {
		super();
		this.Mahh = Mahh;
		this.ten = ten;
		this.mota = mota;
		this.gia = gia;
		this.soluongton = soluongton;
		this.anh = anh;
		this.Mancc = Mancc;
		this.createdAt = createdAt;
	}
	
    
}