package banco;

import gerencia.*;

public class ControleDeBonificacao {
	public void bonificar(Funcionario [] funcionario) {
		
	}
	
	public double getBonificacao(Funcionario funcionario) {
		return funcionario.getBonificacao();
	}

	public void setBonificacao(String funcao, double bonificacao) {
		Funcionario funcionario;
		
		if (funcao.equalsIgnoreCase((funcionario = (new Funcionario(null, null, null))).getFuncao())) {
			funcionario.setBonificacao(bonificacao);
			return;
		}
	}
}
