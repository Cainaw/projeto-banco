package funcionarios;

public abstract class Bonificacao {
	public Double bonificacao;
	public Double salario;

	Bonificacao() {
		this.bonificacao = 0.0;
		this.salario = 0.0;
	}
	
	public void bonificar() {
		try {
			this.salario += this.bonificacao;
		}
		catch (Exception e) {
			System.err.println("Erro ao tentar bonificar: " + e.getMessage());
		}
	}
	
	public Boolean aumentarBonificacao(Double valor) {
		try {
			if (valor > 0.0) {
				this.bonificacao += valor;
				return true;
			} return false;
		}
		catch (Exception e) {
			System.err.println("Erro ao aumentar bonificação: " + e.getMessage());
			return null;
		}
	}
	
	public Boolean diminuirBonificacao(Double valor) {
		try {
			if (valor > 0.0) {
				this.bonificacao -= valor;
				return true;
			} return false;
		}
		catch (Exception e) {
			System.err.println("Erro ao diminuir bonificação: " + e.getMessage());
			return null;
		}
	}

	public Double getBonificacao() {
		return bonificacao;
	}
	
	public Double getSalario() {
		return salario;
	}
}
