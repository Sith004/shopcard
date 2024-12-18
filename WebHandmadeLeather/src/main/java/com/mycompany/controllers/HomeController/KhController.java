package com.mycompany.controllers.HomeController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KhController {
    @RequestMapping("/index") 
    public String Index() {
        return "/khachhang/trangchu"; // 
    }
    @RequestMapping("/sanpham")
    public String sanpham() {
        return "/khachhang/sanpham"; 
    }
    @RequestMapping("/lienhe")
    public String lienhe() {
        return "khachhang/lienhe"; 
    }
    @RequestMapping("/dangky")
    public String dangky() {
        return "khachhang/dangky"; 
    }
    @RequestMapping("/dangnhap")
    public String dangnhap() {
        return "khachhang/dangnhap"; 
    }
    @RequestMapping("/giohang")
    public String giohang() {
        return "khachhang/giohang"; 
    }
    @RequestMapping("/trangchuadmin") 
    public String trangchuanadmin() {
        return "/templateadmin/admintemplate"; // 
    }
    @RequestMapping("/tintuc") 
    public String tintuc() {
        return "/khachhang/tintuc"; // 
    }
    @RequestMapping("/xemngay") 
    public String xemngay() {
        return "/khachhang/Xemngay"; // 
    }
    @RequestMapping("/sanphamniemphong") 
    public String sanphamniemphong() {
        return "/khachhang/sanphamniemphong"; // 
    }
    @RequestMapping("/bosuutap") 
    public String bosuutap() {
        return "/khachhang/bosuutap"; // 
    }
}
