package com.mycompany.models;

import jakarta.persistence.*;

@Entity
@Table(name = "taikhoan")
public class TaikhoanModel {

    @Id
    @Column(name = "MaDangNhap", length = 20)
    private String maDangNhap;

    @Column(name = "MatKhau", length = 20, nullable = false)
    private String matKhau;

    @Column(name = "Makh", length = 20, nullable = false)
    private String maKh;

    // Getters và Setters
    public String getMaDangNhap() {
        return maDangNhap;
    }

    public void setMaDangNhap(String maDangNhap) {
        this.maDangNhap = maDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }
    public TaikhoanModel() {
    	super();
    	// TODO Auto-generated constructor stub
    }

	public TaikhoanModel(String maDangNhap, String matKhau, String maKh) {
		super();
		this.maDangNhap = maDangNhap;
		this.matKhau = matKhau;
		this.maKh = maKh;
	}
    
}
