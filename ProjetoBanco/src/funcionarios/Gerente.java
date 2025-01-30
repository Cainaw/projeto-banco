package funcionarios;

import util.Autenticavel;

public class Gerente extends Funcionario implements Autenticavel {
	private String senha;
	
	public Gerente(String nome, String sobrenome, String cpf) {
		super(nome, sobrenome, cpf);
		//super.setFuncao("Gerente");
	}
	
	@Override
	public Boolean autenticar(String senha) {
		if (this.senha.equals(senha))
			return true;
		return false;
	}

	@Override
	public String getSenha() {
		return this.senha;
	}

	@Override
	public void setSenha(String novaSenha) {
		if (novaSenha != null)
			this.senha = novaSenha;
	}
	
}
