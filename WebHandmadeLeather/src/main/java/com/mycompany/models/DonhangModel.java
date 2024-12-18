package com.mycompany.models;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "donhang")
public class DonhangModel {

    @Id
    private int Sodh;
    private String Makh;
    private LocalDate ngaydat;
    private String trangthai;

    // Constructor mặc định (không tham số)
    public DonhangModel() {
    }

    // Constructor có tham số
    public DonhangModel(int Sodh, String Makh, LocalDate ngaydat, String trangthai) {
        super();
        this.Sodh = Sodh;
        this.Makh = Makh;
        this.ngaydat = ngaydat;
        this.trangthai = trangthai;
    }

    // Getter và Setter
    public int getSodh() {
        return Sodh;
    }

    public void setSodh(int sodh) {
        Sodh = sodh;
    }

    public String getMakh() {
        return Makh;
    }

    public void setMakh(String makh) {
        Makh = makh;
    }

    public LocalDate getNgaydat() {
        return ngaydat;
    }

    public void setNgaydat(LocalDate ngaydat) {
        this.ngaydat = ngaydat;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
}
