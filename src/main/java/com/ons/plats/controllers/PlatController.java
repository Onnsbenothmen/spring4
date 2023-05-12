package com.ons.plats.controllers;

import java.text.ParseException;




import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ons.plats.entities.Plat;
import com.ons.plats.entities.Type;
import com.ons.plats.service.PlatService;
import com.ons.plats.service.TypeService;

import jakarta.validation.Valid;

@Controller
public class PlatController {

	@Autowired
	PlatService platService;
	
	@Autowired
	TypeService typeService;
	
	
	
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) 	
	{
		List<Type> tps = platService.getAllTypes();
		Plat pl = new Plat();
		Type tp = new Type();
		tp = tps.get(0);
		pl.setType(tp);
	modelMap.addAttribute("plat", new Plat());
	modelMap.addAttribute("mode", "new");
	modelMap.addAttribute("types",tps);
	modelMap.addAttribute("page",0 	);
	return "formPlat";
	}
	
	
	@RequestMapping("/savePlat")
	public String savePlat(@Valid Plat plat,
			  BindingResult bindingResult,
			  @ModelAttribute("page") String pageFromPrevious,
			  @RequestParam (name="size", defaultValue = "4") int size,
			  RedirectAttributes redirectAttributes,
			  ModelMap modelMap
			)
	{
		int page;
	    if (bindingResult.hasErrors()) 
	    {
	    	List<Type> tp = platService.getAllTypes();
	    	modelMap.addAttribute("types", tp);
	    	//même on est en mode ajout (mode="new"), en passe le mode edit pour garder la catégorie 
	    	//selectionnée dans la liste, pour mieux le comprendre essayer de passer le mode "new"
	    	 modelMap.addAttribute("mode", "edit");
			return "formPlat";
	    }
	   
	    if (plat.getIdPlat()==null) //adding
	        page = platService.getAllPlats().size()/size; // calculer le nbr de pages
	    else //updating
	        page = Integer.parseInt(pageFromPrevious);		  
	 
	    platService.savePlat(plat);
	    
	    redirectAttributes.addAttribute("page", page);
	    return "redirect:/ListePlats";
	}
	

	
	@RequestMapping("/modifierPlat")
	public String editerPlat(@RequestParam("id") Long id,
				@RequestParam("page") String page,
				ModelMap modelMap)
	{
		int s=Integer.parseInt(page);
	Plat p= platService.getPlat(id);
	List<Type> tps = platService.getAllTypes();
	modelMap.addAttribute("plat", p);
	modelMap.addAttribute("mode", "edit");
	modelMap.addAttribute("page",s);
	modelMap.addAttribute("types",tps);
	System.out.println(" page "+page);
		return "formPLat";
	}
	
	/*@RequestMapping("/updatePlat")
	public String updatePlat(@ModelAttribute("plat") Plat plat,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "4") int size,
	@RequestParam("date") String date,
	 ModelMap modelMap) throws ParseException 
	{
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date datePreparation = dateformat.parse(String.valueOf(date));
	 plat.setDatePreparation(datePreparation);
	 
	 platService.updatePlat(plat);
	 Page<Plat> pls = platService.getAllPlatsParPage(page,size);
	 modelMap.addAttribute("plats", pls);
	 modelMap.addAttribute("pages", new int[pls.getTotalPages()]);
	 modelMap.addAttribute("currentPage",page);
	 modelMap.addAttribute("size", size);
	 
	return "ListePlats";
	}*/
	
	@RequestMapping("/ListePlats")
	public String listePlats(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "4") int size)
	{
	Page<Plat> pls = platService.getAllPlatsParPage(page, size);
	modelMap.addAttribute("plats", pls);
	modelMap.addAttribute("pages", new int[pls.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listePlats";
	}
	
	@RequestMapping("/supprimerPlat")
	public String supprimerPlat(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "4") int size)
	{
	platService.deletePlatById(id);
	int totalPages = platService.getAllPlatsParPage(page, size).getTotalPages();
	if (totalPages <= page) {
	    page = totalPages - 1;
	}
	Page<Plat> pls = platService.getAllPlatsParPage(page, size);
	modelMap.addAttribute("plats", pls);
	modelMap.addAttribute("pages", new int[pls.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listePlats";
	}
	
	
	
	


	
	
}
