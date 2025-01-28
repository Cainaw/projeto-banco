package banco;

import gerencia.*;

public class ControleDeBonificacao {
	public void bonificar(Funcionario [] funcionarios) {
		for (Funcionario funcionario : funcionarios) {
			Double novoSalario = funcionario.getSalario() * (funcionario.getBonificacao() + 1.0);
			funcionario.setSalario(novoSalario);
		}
	}
	
	public double getBonificacao(Funcionario funcionario) {
		return funcionario.getBonificacao();
	}

	public void setBonificacao(Funcionario funcionario, double bonificacao) {
		funcionario.setBonificacao(bonificacao);
	}
}
