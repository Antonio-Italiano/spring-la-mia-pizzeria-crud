package org.java.demo;

import org.java.demo.pojo.Pizza;
import org.java.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {

	@Autowired
	private PizzaService pizzaService;
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Pizza p = new Pizza("margherita", "descrizioneeeeee", "https://www.agricolapiano.com/blogpiano/wp-content/uploads/2022/10/Pizza-contemporanea.jpeg", 12.45);
		Pizza p1 = new Pizza("carbonara", "descrizioneeeeee", "https://latteriasorrentina.com/wp-content/uploads/2019/06/come-fare-la-vera-pizza-1764x882.jpg", 12.45);
		Pizza p2 = new Pizza("messinese", "descrizioneeeeee", "https://media-assets.lacucinaitaliana.it/photos/61fae816034a68e68c6375e0/1:1/pass/undefined", 12.45);
		Pizza p3 = new Pizza("capricciosa", "descrizioneeeeee", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTMA55QHkG9zUWvw_h9NJhGD2FWlosbJpRHy-Qh8bmZauQt8efr_NAyUnymxkN84O8xWd0&usqp=CAU", 12.45);
		Pizza p4 = new Pizza("napoletana", "descrizioneeeeee", "https://foodohfood.it/wp-content/uploads/pizza-alta-soffice-facile-ricetta.jpg", 12.45);
		System.out.println(p);
		
		pizzaService.save(p);
		pizzaService.save(p1);
		pizzaService.save(p2);
		pizzaService.save(p3);
		pizzaService.save(p4);
	}
}
