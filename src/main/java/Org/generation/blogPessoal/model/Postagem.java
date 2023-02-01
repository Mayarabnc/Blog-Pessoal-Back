package Org.generation.blogPessoal.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity //Indica que se trata de uma entidade 
@Table(name = "tb_postagem") //Indica e cria uma tabela com o nome indicado no atributo name
public class Postagem {
	
	@Id			/*Como ele se comportará na base de dados?*/
	@GeneratedValue(strategy = GenerationType.IDENTITY)
						/*Ele se transformará em uma Primary key e será gerada automaticamente*/
	private long id;
	
		
	@NotNull  //Não permite um valor vazio
	@Size(min = 5, max = 100)  // Define o numero de caracteres 
	private String titulo;
	
	@NotNull
	@Size(min = 5, max = 500)
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP)   //Indica para o jpa hibernate que estamos trabalhando com tempo 
	private Date date = new java.sql.Date(System.currentTimeMillis());
	  								  /*captura exatamente o dia, a hora, os minutos, os segundos e o milésimo que o dado passou por essa classe*/

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
