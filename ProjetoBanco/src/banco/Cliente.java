package banco;

import util.Autenticavel;
import util.Pessoa;

public class Cliente extends Pessoa implements Autenticavel {
	private String senha;
	
	public Cliente(String nome, String sobrenome, String cpf) {
		super.setNome(nome);
		super.setSobrenome(sobrenome);
		super.setCpf(cpf);
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
