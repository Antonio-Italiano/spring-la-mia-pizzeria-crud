package org.java.demo.controller;


import java.util.List;
import java.util.Optional;

import org.java.demo.pojo.Pizza;
import org.java.demo.service.PizzaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class pizzaController {

	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/")
	public String index(Model model) {
		
		List<Pizza> pizze = pizzaService.findAll();
		
		model.addAttribute("pizze", pizze);
		
		return "index";
	}
	
	
	@GetMapping("/pizza/{id}")
	public String show(
			Model model,
			@PathVariable("id") int id
	) {
		
		Optional<Pizza> optPizza = pizzaService.findById(id);
		Pizza pizza = optPizza.get();
		
		model.addAttribute("pizza", pizza);
		
		return "show";
	}	

	@GetMapping("pizza/create")
	public String getCreate() {
		
		return "create";
	}
	
	@PostMapping("pizza/create")
	public String storeBook(@ModelAttribute Pizza pizza) {
		
		pizzaService.save(pizza);
		
		return "redirect:/pizza";
	}
	
	@PostMapping("/pizza/filter")
	public String indexFiltro(Model model,@RequestParam(required = false) String nome) {
		
		List<Pizza> pizze = pizzaService.findByNome(nome);
		
		model.addAttribute("pizze", pizze);
		model.addAttribute("nome",nome);
		
		return "pizzaIndex";
	}
}

