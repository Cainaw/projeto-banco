package banco;

import util.Pessoa;

public class Cliente extends Pessoa {
	public Cliente(String nome, String sobrenome, String cpf) {
		super.setNome(nome);
		super.setSobrenome(sobrenome);
		super.setCpf(cpf);
	}
}
