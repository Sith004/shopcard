package com.mycompany.models;

import org.springframework.web.multipart.MultipartFile;

public class HanghoaDto {
	  private String Mahh; 
	    private String ten; 
	    private String mota; 
	    private String gia; 
	    private String soluongton;
	    private String anh; 
	    private String Mancc; 
	    private MultipartFile imageFile;
		public String getMahh() {
			return Mahh;
		}
		public void setMahh(String mahh) {
			Mahh = mahh;
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
		public MultipartFile getImageFile() {
			return imageFile;
		}
		public void setImageFile(MultipartFile imageFile) {
			this.imageFile = imageFile;
		}
	    
}
