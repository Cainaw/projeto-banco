package funcionarios;

public class Bonificacao {
	public Double bonificacao;
	public Double salario;

	Bonificacao() {
		this.bonificacao = 0.0;
		this.salario = 0.0;
	}

	public Double getBonificacao() {
		return bonificacao;
	}

	public void setBonificacao(Double bonificacao) {
		this.bonificacao = bonificacao;
	}
	
	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
}
