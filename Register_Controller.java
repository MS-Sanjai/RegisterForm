package com.example.Registration_form;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.web.exchanges.HttpExchange.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;







@Controller
public class Register_Controller {
	
	
	
	@Autowired
	 Register_Repository  reg;
	
	
	@Autowired
	Recover_Repository recover;
	
    static final String Admin="Redmi";
    static final String AdminPassword="sanjai1321";
	
	
	
	
	
	public Register_Controller(Register_Repository reg, Recover_Repository recover) {
		super();
		this.reg = reg;
		this.recover = recover;
		
	}
	@GetMapping("/")
	public String RegisterFormGet(Model model) {
		Register_Model regis=new Register_Model();
		 model.addAttribute("registerModel", regis);	
			
		return "form";
	}
	
	@PostMapping("/register")
	public String RegisterSumit(@ModelAttribute ("registerModel") Register_Model regis) {
		
		reg.save(regis);
		
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String LoginPage(Model model) {
	    
	    Register_Model regis = new Register_Model();
	    model.addAttribute("registerModel", regis);
	    return "login";
	}

	@PostMapping("/login")
	public String LoginPageForm(@RequestParam ("Username") String Username,@RequestParam ("password") String password) {
		if(Admin.equals(Username) && AdminPassword.equals(password)) {
			return "redirect:/ListView";
		}else {
			return "redirect:/UserList";
		}
		
	}
	@GetMapping("/UserList")
	public String Userdetails(Model model, Principal principal){
		String username=principal.getName();
		Register_Model regis=reg.findByUsername(username);
		model.addAttribute("registerModel",regis);
		 return "UserList";
	}

	
	 @GetMapping("/ListView")
	    public String ListViewForm(Model model) {
	        List<Register_Model> listmodel = reg.findAll();
	        model.addAttribute("reglists", listmodel);
	        return "List"; // Return "List" instead of "List.html"
	    }
	
	 @GetMapping("/edit/{id}")
	 public String EditId(@PathVariable("id") int id, Model model) {
			Register_Model exitRecord=reg.findById(id).orElse(null);
	     if (exitRecord == null) {
	         return "redirect:/ListView";
	     }
	     model.addAttribute("registerModel", exitRecord);
	     return "edit";
	 }

	 @PostMapping("/update/{id}")
	 public String Edit(@PathVariable("id") int id, @ModelAttribute("registerModel") Register_Model UpdateRecord) {
	     Register_Model exitRecord = reg.findById(id).orElse(null);
	     if (exitRecord == null) {
	         return "redirect:/ListView";
	     }
	     //exitRecord.setUsername(UpdateRecord.getUsername());
	     //exitRecord.setMail(UpdateRecord.getMail());
	     exitRecord.setMobile(UpdateRecord.getMobile());
	     exitRecord.setCity(UpdateRecord.getCity());
	     exitRecord.setPassword(UpdateRecord.getPassword());
	     reg.save(exitRecord);
	     return "redirect:/ListView";
	 }
    
	 @GetMapping("/delete/{id}")
	 public String deleteRecord(@PathVariable("id") int id, Model model) {
	     Register_Model exitRecord = reg.findById(id).orElse(null);
	     if (exitRecord == null) {
	         return "redirect:/ListView";
	     }
	     model.addAttribute("registerModel", exitRecord);
	     return "DeleteConfrim";
	 }


	 @PostMapping("/delete/{id}")
	 public String confirmDelete(@PathVariable("id") int id) {
		 Register_Model exitRecord = reg.findById(id).orElse(null);
	        if (exitRecord == null) {
	            return "redirect:/ListView";
	        }
	        
	        
	        
	        Recover_Model redelete=new Recover_Model(exitRecord.getUsername(),exitRecord.getMail(),exitRecord.getMobile(),
	        		exitRecord.getCity(),exitRecord.getPassword());
	          recover.save(redelete);
	        reg.deleteById(id);
	        return "redirect:/ListView";
	 }
	 
	 
	 @GetMapping("/recover")
		public String DeteleRecover(Model model) {
			
			List<Recover_Model> recoverRecord=recover.findAll();
			model.addAttribute("RecoverList",recoverRecord);
			
			
			
			return "recover";
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}