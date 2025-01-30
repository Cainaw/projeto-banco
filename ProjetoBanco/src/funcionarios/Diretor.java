package funcionarios;

import util.Autenticavel;

public class Diretor extends Funcionario implements Autenticavel {
	private String senha;

	Diretor(String nome, String sobrenome, String cpf) {
		super(nome, sobrenome, cpf);
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
