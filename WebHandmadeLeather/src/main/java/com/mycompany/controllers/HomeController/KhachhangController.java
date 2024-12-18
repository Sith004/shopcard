package com.mycompany.controllers.HomeController;

import com.mycompany.models.KhachhangModel;
import com.mycompany.repository.KhachhangRepository;
import com.mycompany.services.KhachhangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/khachhang")
public class KhachhangController {

    @Autowired
    private KhachhangService khachhangService;  
    @Autowired
    private KhachhangRepository khachhangRepo;

    @GetMapping
    public String index(Model model) {
        List<KhachhangModel> khachhangList = khachhangService.getAllProducts();  
        model.addAttribute("productList", khachhangList);
        return "/admin/trangkhachhang";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        KhachhangModel khachhang = new KhachhangModel();  
        model.addAttribute("khachhang", khachhang);
        return "/admin/create-khachhang";
    }

    @PostMapping("/form")
    public String addKhachHang(@ModelAttribute("khachhang") KhachhangModel khachhang) {
        khachhangService.addProduct(khachhang);  
        return "redirect:/khachhang";
    }

    @GetMapping("/khachhang-edit/{makh}")
    public String editKhachHang(@PathVariable("makh") String maKh, Model model) {
        KhachhangModel khachhang = khachhangRepo.findById(maKh).orElse(null);
        if (khachhang != null) {
            model.addAttribute("khachhang", khachhang);
            return "/admin/edit-trangkhachhang";
        }
        return "redirect:/khachhang";
    }

    @PostMapping("/khachhang-edit")
    public String editKhachHang(@ModelAttribute("khachhang") KhachhangModel khachhang) {
        try {
            if (khachhangService.editKhachhang(khachhang)) {
                return "redirect:/khachhang";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/khachhang";
    }
    @GetMapping("/khachhang-delete/{makh}") 
	 public String admin_product_delete(@PathVariable("makh") KhachhangModel khachhang, Model 
	 model) { 
	 model.addAttribute("product", khachhangService.deleteKhachhang(khachhang)); 
	 return "redirect:/khachhang"; 
	 }
}
