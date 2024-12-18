package com.mycompany.controllers.HomeController;

import com.mycompany.models.TaikhoanModel;
import com.mycompany.repository.TaikhoanRepository;
import com.mycompany.services.TaikhoanService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/taikhoan")
public class TaikhoanController {

    @Autowired
    private TaikhoanService taikhoanService;
    @Autowired
    private TaikhoanRepository taikhoanRepo;

    
    @GetMapping
    public String index(Model model) {
        List<TaikhoanModel> taikhoanList = taikhoanService.getAllTaikhoan();
        model.addAttribute("taikhoanList", taikhoanList);
        return "/admin/trangtaikhoan"; 
    }

    @GetMapping("/formtk")
    public String showForm(Model model) {
    	List<TaikhoanModel> listaikhoan = this.taikhoanService.getAllTaikhoan()
;        model.addAttribute("listaikhoan", listaikhoan); 
        return "/admin/create-taikhoan";  
    }
    
    @PostMapping("/formtk")
    public String addTaikhoan(@ModelAttribute("taikhoan") TaikhoanModel taikhoan) {
        this.taikhoanService.addTaikhoan(taikhoan);  
        return "redirect:/taikhoan";  
    }

    @GetMapping("/taikhoan-edit/{maDangNhap}")
    public String editTaiKhoan(@PathVariable("maDangNhap") String maDangNhap, Model model)
    {
    	TaikhoanModel taikhoan = this.taikhoanRepo.findById(maDangNhap).get();
    	model.addAttribute("taikhoan",taikhoan);
    	return "admin/edit-trangtk";
    }
    @PostMapping("/taikhoan-edit") 
    public String edit(@ModelAttribute("taikhoan") TaikhoanModel taikhoan, Model model){ 
  try { 

   if(this.taikhoanService.editTaikhoan(taikhoan)) { 
    return "redirect:/taikhoan"; 
   } 
  } catch (Exception e) { 
            e.printStackTrace(); 
        } 
  return "redirect:/taikhoan/taikhoan-edit"; 
    }
    
    @GetMapping("/taikhoan-delete/{maDangNhap}") 
	 public String admin_product_delete(@PathVariable("maDangNhap") TaikhoanModel taikhoan, Model 
	 model) { 
	 model.addAttribute("product", taikhoanService.deleteTaikhoan(taikhoan)); 
	 return "redirect:/taikhoan"; 
	 }
    @GetMapping("/dangnhapadmin")
    public ModelAndView hienThiDangNhap() {
        return new ModelAndView("/admin/dangnhap");  
    }

    @PostMapping("/dangnhapadmin")
    public ModelAndView dangNhap(
            @RequestParam("maDangNhap") String maDangNhap,
            @RequestParam("matKhau") String matKhau,
            HttpSession session) {

        boolean isAuthenticated = taikhoanService.kiemTraDangNhap(maDangNhap, matKhau);
        if (isAuthenticated) {
            session.setAttribute("maDangNhap", maDangNhap);
            return new ModelAndView("redirect:/trangchuadmin");
        } else {
            ModelAndView mav = new ModelAndView("/admin/dangnhap");
            mav.addObject("error", "Mã đăng nhập hoặc mật khẩu không đúng.");
            return mav;
        }
    }
}
