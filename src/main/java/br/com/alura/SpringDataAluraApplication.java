package br.com.alura;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.orm.Cargo;
import br.com.alura.repository.CargoRepository;

@SpringBootApplication
public class SpringDataAluraApplication implements CommandLineRunner{
	
	private final CargoRepository repository;
	

	public SpringDataAluraApplication(CargoRepository repository) {
		super();
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Cargo cargo = new Cargo("Desenvolvedor de software");
		
		repository.save(cargo);
	}

}
