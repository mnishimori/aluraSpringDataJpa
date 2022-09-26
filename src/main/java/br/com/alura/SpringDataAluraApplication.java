package br.com.alura;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.orm.Cargo;
import br.com.alura.repository.CargoRepository;
import br.com.alura.service.CrudCargoService;

@SpringBootApplication
public class SpringDataAluraApplication implements CommandLineRunner{
	
	private Boolean system = true;
	
	private final CrudCargoService cargoService;

	
	public SpringDataAluraApplication(CrudCargoService cargoService) {
		super();
		this.cargoService = cargoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		while (system) {
			System.out.println("Qual operacao voce quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			
			int action = scanner.nextInt();
			if (action == 1) {
				cargoService.inicial(scanner);
			} else {
				system = false;
			}
		}
	}
}
