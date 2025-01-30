package funcionarios;

public class Gerente extends Funcionario {
	private String senha;
	
	public Gerente(String nome, String sobrenome, String cpf) {
		super(nome, sobrenome, cpf);
		super.setFuncao("Gerente");
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
