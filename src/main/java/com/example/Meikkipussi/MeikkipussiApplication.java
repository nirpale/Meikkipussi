package com.example.Meikkipussi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.Meikkipussi.domain.Category;
import com.example.Meikkipussi.domain.CategoryRepository;
import com.example.Meikkipussi.domain.Meikki;
import com.example.Meikkipussi.domain.MeikkiRepository;
import com.example.Meikkipussi.domain.User;
import com.example.Meikkipussi.domain.UserRepository;


@SpringBootApplication
public class MeikkipussiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeikkipussiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner meikkiDemo(MeikkiRepository mrepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			
			//kategorioiden luonti
			
			crepository.save(new Category("Meikkivoide"));
			crepository.save(new Category("Puuteri"));
			crepository.save(new Category("Eyeliner"));
			crepository.save(new Category("Ripsiväri"));
			crepository.save(new Category("Kulmakynä/-pomade"));
			crepository.save(new Category("Luomiväri"));
			
			//luodaan kaksi testiesimerkkiä
			
			mrepository.save(new Meikki(0, "Naked Basics", "Urban Decay", "7,8g", "30,50€",
					crepository.findByName("Luomiväri").get(0)));
			mrepository.save(new Meikki(1, "Nordic Chic irtopuuteri", "Lumene", "8g", "19,95€",
					crepository.findByName("Puuteri").get(0)));
			
		//käyttis user, salasana user
			User user = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@one.com", "USER");
			urepository.save(user);
		};
	}
}
