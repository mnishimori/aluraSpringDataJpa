package br.com.alura.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.orm.Cargo;
import br.com.alura.repository.CargoRepository;

@Service
public class CrudCargoService {
	
	private Boolean system = true;
	private final CargoRepository cargoRepository;

	public CrudCargoService(CargoRepository cargoRepository) {
		super();
		this.cargoRepository = cargoRepository;
	}
	
	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual operacao voce quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Cadastrar cargo");
			System.out.println("2 - Atualizar cargo");
			System.out.println("3 - Listar cargos");
			System.out.println("4 - Excluir cargo");
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				this.salvar(scanner);
				break;
			case 2:
				this.atualizar(scanner);
				break;
			case 3:
				this.visualizar();
				break;
			case 4:
				this.deletar(scanner);
				break;
			default:
				system = false;
				break;
			}
		}
	}
	
	private void salvar(Scanner scanner) {
		System.out.println("Descricao do cargo");
		String descricao = scanner.next();
		
		Cargo cargo = new Cargo(descricao);
		cargoRepository.save(cargo);
		System.out.println("Cargo salvo");
	}
	
	private void visualizar() {
		List<Cargo> cargos = cargoRepository.findAll();
		cargos.forEach(c -> System.out.println(c));
	}
	
	private void atualizar(Scanner scanner) {
		System.out.println("Digite o id do cargo");
		Integer id = scanner.nextInt();
		System.out.println("Digite a descricao do cargo");
		String descricao = scanner.next();
		
		Cargo cargo = new Cargo(descricao);
		cargo.setId(id);
		
		cargoRepository.save(cargo);
		System.out.println("Cargo atualizado");
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("Digite o id do cargo");
		Integer id = scanner.nextInt();
		
		cargoRepository.deleteById(id);
		System.out.println("Cargo deletado");
	}

}
