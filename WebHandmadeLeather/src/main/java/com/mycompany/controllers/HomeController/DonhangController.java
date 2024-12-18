package com.mycompany.controllers.HomeController;

import com.mycompany.models.DonhangModel;
import com.mycompany.models.KhachhangModel;
import com.mycompany.repository.DonhangRepository;
import com.mycompany.repository.KhachhangRepository;
import com.mycompany.services.DonhangService;
import com.mycompany.services.KhachhangService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/donhang")
public class DonhangController {

@Autowired
private DonhangService DonhangService;
@Autowired
private DonhangRepository DonhangRepo;

@Autowired
private KhachhangService khachhangService;
@Autowired
private KhachhangRepository khachhangRepo;

@GetMapping
public String index(Model model) {
    List<DonhangModel> DonhangList = DonhangService.getAllDonhang();
    model.addAttribute("DonhangList", DonhangList);
    return "/admin/trangdonhang"; 
}

@GetMapping("/donhangcr")
public String showForm(Model model) {
	List<DonhangModel> lisDonhang = this.DonhangService.getAllDonhang();
	List<KhachhangModel> lisKhach = this.khachhangService.getAllProducts();
;        model.addAttribute("lisDonhang", lisDonhang); 
         model.addAttribute("lisKhach", lisKhach);
    return "/admin/create-donhang";  
}

@PostMapping("/donhangcr")
public String addDonhang(@ModelAttribute("Donhang") DonhangModel Donhang) {
    this.DonhangService.addDonhang(Donhang);  
    return "redirect:/donhang";  
}

@GetMapping("/Donhang-edit/{Sodh}")
public String editDonhang(@PathVariable("Sodh") int Sodh, Model model)
{
	DonhangModel Donhang = this.DonhangRepo.findById(Sodh).get();
	model.addAttribute("Donhang",Donhang);
	return "admin/edit-donhang";
}
@PostMapping("/Donhang-edit") 
public String edit(@ModelAttribute("Donhang") DonhangModel Donhang, Model model){ 
try { 

if(this.DonhangService.editDonhang(Donhang)) { 
return "redirect:/donhang"; 
} 
} catch (Exception e) { 
        e.printStackTrace(); 
    } 
return "redirect:/donhang/Donhang-edit"; 
}

@GetMapping("/Donhang-delete/{Sodh}") 
 public String admin_product_delete(@PathVariable("Sodh") DonhangModel Donhang, Model model) { 
 model.addAttribute("product", DonhangService.deleteDonhang(Donhang)); 
 return "redirect:/donhang"; 
 }

}