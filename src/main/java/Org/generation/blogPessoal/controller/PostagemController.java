package Org.generation.blogPessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Org.generation.blogPessoal.model.Postagem;
import Org.generation.blogPessoal.repository.PostagemRepository;
import jakarta.validation.Valid;

@RestController   //Indica para o spring que essa classe se trata de um controlador
@RequestMapping("/postagens")  //Defina por qual URI que essa classe será acessada
@CrossOrigin("*")   //Faz com que essa classe aceite requisisões de qualquer origem  
public class PostagemController {

	@Autowired //Notação de injeção de dependencia  
	private PostagemRepository repository;
	
	//Método findALL
	@GetMapping  //Indica que esse método se trada de um GET, para ser disparado caso haja uma requsição desse médoto
	public ResponseEntity<List<Postagem>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	//Método findById
	@GetMapping("/{id}")  //Indica que esse método se trada de um GET, e que se espera um parametro que será enviado pelo usuário, nesse caso Id
	public ResponseEntity<Postagem> GetById(@PathVariable long id){
												/*O valor da variável id, vai vir como uma variável do caminho da URI*/
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	//Método findByTitulo
	@GetMapping("/titulo/{titulo}") //Usado para não haver duplicidade de endpoint 
	public ResponseEntity<List<Postagem>> GetBytitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping	//Indica que esse método se trada de um POST, para ser disparado caso haja uma requsição desse médoto
	public ResponseEntity<Postagem> post(@RequestBody Postagem postagem){
												/*Pega o que vem no corpo da requisição */
		
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	
	@PutMapping //Indica que esse método se trada de um PUT, obs.: no postman não esquecer de colocar o id no body 
	public ResponseEntity<Postagem> put(@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}
	
	@DeleteMapping("/{id}")	//Indica que esse método se trada de um DELETE
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
