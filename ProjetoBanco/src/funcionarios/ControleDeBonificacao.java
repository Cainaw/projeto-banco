package funcionarios;

public class ControleDeBonificacao {
	private Double registroBonificacao;
	
	public ControleDeBonificacao() {
		this.registroBonificacao = 0.0;
	}
	
	public void bonificarFuncionarios(Funcionario [] funcionarios) {
		for (Funcionario funcionario : funcionarios) {
			if (funcionario != null) {
				funcionario.bonificar();
				registrarBonificacao(funcionario);
			}
		}
	}
	
	public void registrarBonificacao(Funcionario funcionario) {
		this.registroBonificacao += funcionario.getBonificacao();
	}
	
	public Double getBonificacao(Funcionario funcionario) {
		return funcionario.getBonificacao();
	}

	public void setBonificacao(Funcionario funcionario, double bonificacao) {
		funcionario.setBonificacao(bonificacao);
	}
	
	public Double getRegistro() {
		return this.registroBonificacao;
	}
}
