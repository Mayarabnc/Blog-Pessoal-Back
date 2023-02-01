package Org.generation.blogPessoal.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_tema")
public class Tema {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String descricao;
	
				  /*Indica qual atributo estamos mapiando, nesse caso é o atributo tema de tb_postagem*/
	@OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)  //Indica que a relação é de um para muitos
									  /*Faz com que todas as postagens que pertençam a esse tema sofreram alteração, logo se deletarmos um tema todas as postagens relacionados a ele também serão deletadas*/
	@JsonIgnoreProperties("tema")
	private List<Postagem> postagem;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
}
