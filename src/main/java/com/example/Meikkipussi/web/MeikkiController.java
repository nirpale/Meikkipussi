package com.example.Meikkipussi.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Meikkipussi.domain.CategoryRepository;
import com.example.Meikkipussi.domain.Meikki;
import com.example.Meikkipussi.domain.MeikkiRepository;


@Controller
public class MeikkiController {
	
	@Autowired
	private MeikkiRepository mrepository; 
	
	@Autowired
	private CategoryRepository crepository;
	
	//sisäänkirjaus
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
	
	//näyttää kaikki meikit
	@RequestMapping(value="/meikkipussi")
	public String meikitList(Model model) {
		model.addAttribute("meikit", mrepository.findAll());
		
		return "meikkipussi";
	}
	
	//REST-palvelu, näyttää meikit
	@RequestMapping(value="/meikit", method = RequestMethod.GET)
    public @ResponseBody List<Meikki> meikitListRest() {	
        return (List<Meikki>) mrepository.findAll();
    }
	
	// REST-palvelu, hakee meikin id:n avulla
    @RequestMapping(value="/meikki/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Meikki> findMeikkiRest(@PathVariable("id") Long meikkiId) {	
    	return mrepository.findById(meikkiId);
    }
	
	//lisää uusi tuote
	@RequestMapping(value = "/add")
	public String addMeikki(Model model){
		model.addAttribute("meikki", new Meikki());
		model.addAttribute("categories", crepository.findAll());
		
		return "lisaa";
	}
	
	//tallennus
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Meikki meikki){
		mrepository.save(meikki);
		
		return "redirect:meikkipussi";
	}
	
	//poista meikki id:n avulla
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long meikkiId, Model model) {
		mrepository.deleteById(meikkiId);
		
		return "redirect:../meikkipussi";
	}
	
	//muokkaa tuotetta
	@RequestMapping(value = "/edit/{id}")
	public String addMeikki(@PathVariable("id") Long meikkiId, Model model){
	model.addAttribute("meikki", mrepository.findById(meikkiId));
	model.addAttribute("categories", crepository.findAll());
	
		return "muokkaa";
	}

}
