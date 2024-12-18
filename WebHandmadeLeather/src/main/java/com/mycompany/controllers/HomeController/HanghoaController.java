package com.mycompany.controllers.HomeController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.mycompany.models.HanghoaDto;
import com.mycompany.models.HanghoaModel;
import com.mycompany.models.NhacungcapModels;
import com.mycompany.repository.HanghoaRepository;
import com.mycompany.repository.NhacungcapRepository;
import com.mycompany.services.HanghoaService;
import com.mycompany.services.Nhacungcap;


@Controller 
@RequestMapping("/admin") 
public class HanghoaController {
	@Autowired
	private HanghoaService hanghoaService; 
	@Autowired
	private HanghoaRepository HanghoaModelRe;
	
	@Autowired
	private Nhacungcap nccService; 
	@Autowired
	private NhacungcapRepository nccReposi;


	@GetMapping("/HanghoaModel")  
	public String adminHanghoaModel(Model model) { 
	List<HanghoaModel> lstPro=this.hanghoaService.getAll();   

	model.addAttribute("lstPro",lstPro); 
	return "admin/Tranghanghoa"; 
	} 
	@GetMapping("/HanghoaModel-add") 
	public String admin_HanghoaModel_add(Model model) { 
	    HanghoaDto hanghoaDto = new HanghoaDto();
	    List<NhacungcapModels> lstNcc = this.nccService.getAllNhacungcap();   
	    model.addAttribute("lstNcc", lstNcc); 
	    model.addAttribute("hanghoaDto", hanghoaDto); 
	    return "admin/create-hanghoa"; 
	}

	
	@PostMapping("/HanghoaModel-add") 
    public String add(@ModelAttribute("HanghoaModel") HanghoaModel pro,  @ModelAttribute HanghoaDto HanghoaDto, BindingResult result){ 
		if (HanghoaDto.getImageFile().isEmpty())
		{
			result.addError (new FieldError ("HanghoaDto", "imageFile", "The image file is required"));	
			}
		if (result.hasErrors())
		{
			return "HanghoaModel/HanghoaModel-add";
		}
		MultipartFile image = HanghoaDto.getImageFile();
		Date createdAt = new Date();
		String storageFileName = createdAt.getTime() +"_" + image.getOriginalFilename ();
		try {
			String uploadDir = "public/images/";
			Path uploadPath = Paths.get(uploadDir);

			if (!Files.exists(uploadPath)) 
			{ Files.createDirectories (uploadPath); }
			try (InputStream inputStream = image.getInputStream()) {
				Files.copy(inputStream, Paths.get(uploadDir + storageFileName), StandardCopyOption.REPLACE_EXISTING);
				}
				} 
				catch (Exception ex) {
				System.out.println("Exception: "+ ex.getMessage());
				}
			
			
	  try { 
		  HanghoaModel HanghoaModel= new HanghoaModel();
		  HanghoaModel.setMahh (HanghoaDto.getMahh());
		  HanghoaModel.setMota (HanghoaDto.getMota());
		  HanghoaModel.setSoluongton(HanghoaDto.getSoluongton()) ;
		  HanghoaModel.setTen (HanghoaDto.getTen());
		  HanghoaModel.setGia (HanghoaDto.getGia());
		  HanghoaModel.setMancc (HanghoaDto.getMancc());
		  HanghoaModel.setCreatedAt (createdAt);
		  HanghoaModel.setAnh(storageFileName);
		  HanghoaModelRe.save(HanghoaModel);
		  return "redirect:/admin/HanghoaModel";

	  } catch (Exception e) { 
	            e.printStackTrace(); 
	        } 
	  return "redirect:/admin/HanghoaModel-add"; 
	    }
		
		@GetMapping("/HanghoaModel-edit/{Mahh}") 
		 public String admin_HanghoaModel_edit(@PathVariable("Mahh") String Mahh, Model 
		model) { 
			HanghoaModel HanghoaModel = HanghoaModelRe.findById(Mahh).get();
		List<HanghoaModel> lstCat = hanghoaService.getAll();
		
			 
			model.addAttribute("HanghoaModel",HanghoaModel);

			
			try {
				
				HanghoaDto HanghoaDto= new HanghoaDto();
				HanghoaDto.setGia (HanghoaModel.getGia());
				HanghoaDto.setMahh(HanghoaModel.getMahh());
				HanghoaDto.setMancc(HanghoaModel.getMancc());
				HanghoaDto.setMota (HanghoaModel.getMota());
				HanghoaDto.setSoluongton(HanghoaModel.getSoluongton());
				HanghoaDto.setTen(HanghoaModel.getTen());
				
				model.addAttribute("HanghoaDto", HanghoaDto);

			}
			catch(Exception ex) {
				System.out.println ("Exception: " + ex.getMessage());
				return "redirect:/HanghoaModel";
			}
		  return "admin/edit-hanghoa";
		}
		
		@PostMapping("/HanghoaModel-edit/{Mahh}") 
	    public String edit(Model model, @PathVariable("Mahh") String Mahh,  @ModelAttribute HanghoaDto HanghoaDto,
	    		BindingResult result ){  
	  try { 
	     
		  HanghoaModel HanghoaModel = HanghoaModelRe.findById(Mahh).get();
			model.addAttribute("HanghoaModel", HanghoaModel);
			
			if(result.hasErrors())
			{return "admin/edit-hanghoa";
		}
			
				if (!HanghoaDto.getImageFile().isEmpty()) {
				// delete old image
				String uploadDir = "public/images/";
				Path oldImagePath = Paths.get(uploadDir + HanghoaModel.getAnh());
				try {
				Files.delete (oldImagePath);
				}
				catch (Exception ex) {
				System.out.println("Exception: "+ ex.getMessage());
				}
				// save new image file
				MultipartFile image = HanghoaDto.getImageFile();
				Date createdAt = new Date();
				String storageFileName = createdAt.getTime() + " " + image.getOriginalFilename();
						
				 try (InputStream inputStream = image.getInputStream()){ 
				Files.copy(inputStream, Paths.get(uploadDir + storageFileName), StandardCopyOption.REPLACE_EXISTING);
				}
				 HanghoaModel.setAnh (storageFileName);
				}
						HanghoaModel.setMahh (HanghoaDto.getMahh()); 
						HanghoaModel.setTen(HanghoaDto.getTen()) ;
						HanghoaModel.setMota(HanghoaDto.getMota());
						HanghoaModel.setGia (HanghoaDto.getGia());
						HanghoaModel.setSoluongton (HanghoaDto.getSoluongton());
						HanghoaModel.setMancc (HanghoaDto.getMancc());
						
						HanghoaModelRe.save(HanghoaModel);
						return "redirect:/admin/HanghoaModel";
			
			  } catch (Exception e) { 
			            e.printStackTrace(); 
			        } 
			  return "redirect:/admin/HanghoaModel-add"; 
			    }
				
				@GetMapping ("/HanghoaModel-delete/{Mahh}")
				public String delecteHanghoaModel (@PathVariable String Mahh)
				{
					try {
						HanghoaModel HanghoaModel = HanghoaModelRe.findById(Mahh).get();
						// delete HanghoaModel image
						Path imagePath = Paths.get("public/images/" + HanghoaModel.getAnh());
						try {
						Files.delete(imagePath);
						}
						catch (Exception ex) {
						System.out.println("Exception: "+ ex.getMessage());
						}
						// delete the HanghoaModel
						HanghoaModelRe.delete(HanghoaModel);
					}
					catch (Exception ex) {
						System.out.println("Exception: " + ex.getMessage());	}
					return "redirect:/admin/HanghoaModel";
					}
//				@GetMapping("/HanghoaModel-delete/{id}") 
//				 public String admin_HanghoaModel_delete(@PathVariable("id") HanghoaModel pro, Model 
//				 model) { 
//				 model.addAttribute("HanghoaModel", HanghoaModelService.delete(pro)); 
//				 return "redirect:/admin/HanghoaModel"; 
//				 }
}
