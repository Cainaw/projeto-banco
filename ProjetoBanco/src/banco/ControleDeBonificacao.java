package banco;

import funcionarios.*;

public class ControleDeBonificacao {
	public void bonificar(Funcionario [] funcionarios) {
		for (Funcionario funcionario : funcionarios) {
			if (funcionario != null)
				funcionario.bonificar();
		}
	}
	
	public double getBonificacao(Funcionario funcionario) {
		return funcionario.getBonificacao();
	}

	public void setBonificacao(Funcionario funcionario, double bonificacao) {
		funcionario.setBonificacao(bonificacao);
	}
}
