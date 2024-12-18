package com.mycompany.controllers.HomeController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.mycompany.models.NhacungcapModels;
import com.mycompany.repository.NhacungcapRepository;
import com.mycompany.services.Nhacungcap;

import java.util.List;

@Controller
@RequestMapping("/")
public class NhacungcapController {

@Autowired
private Nhacungcap nhacungcapService;
@Autowired
private NhacungcapRepository nhacungcapRepo;


@GetMapping
public String index(Model model) {
    List<NhacungcapModels> NCCList = nhacungcapService.getAllNhacungcap();
    model.addAttribute("NCCList", NCCList);
    return "templates/admin/ncc"; 
}

@GetMapping("/ncc")
public String showForm(Model model) {
	List<NhacungcapModels> NCCList = this.nhacungcapService.getAllNhacungcap();
	model.addAttribute("NCClist", NCCList); 
   
    return "/admin/create-nhacungcap";  
}

@PostMapping("/ncc")
public String addNhacungcap(@ModelAttribute("Mancc") NhacungcapModels nhacungcap) {
    this.nhacungcapService.addNhacungcap(nhacungcap);  
    return "redirect:/nhacungcap";  
}

@GetMapping("/nhacungcap-edit/{Mancc}")
public String editNhacungcap(@PathVariable("Mancc") String Mancc, Model model)
{
	NhacungcapModels NCCList = this.nhacungcapRepo.findById(Mancc).get();
	model.addAttribute("NCClist",NCCList);
	return "admin/edit-nhacungcap";
}
@PostMapping("/nhacungcap-edit") 
public String edit(@ModelAttribute("Nhacungcap") NhacungcapModels nhacungcap, Model model){ 
try { 

if(this.nhacungcapService.editNhacungcap(nhacungcap)) { 
return "redirect:/nhacungcap"; 
} 
} catch (Exception e) { 
        e.printStackTrace(); 
    } 
return "redirect:/nhacungcap/nhacungcap-edit"; 
}

@GetMapping("/nhacungcap-delete/{Mancc}") 
 public String deleteNhacungcap(@PathVariable("Mancc") NhacungcapModels nhacungcap, Model model) { 
 model.addAttribute("product", nhacungcapService.deleteNhacungcap(nhacungcap)); 
 return "redirect:/nhacungcap"; 
 }

}