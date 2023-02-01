package Org.generation.blogPessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Org.generation.blogPessoal.model.Postagem;

@Repository //Indica que se trata de uma classe de repositorio
															/*Tipo de entidade que estamos trabalhando*/
public interface PostagemRepository extends JpaRepository<Postagem, Long>{
																	  /*Tipagem do ID*/
	
	//Metodo de consulta pelo titulo da postagem não levando em consideração caracteres maiúsculo e minúsculo
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo); 
}
