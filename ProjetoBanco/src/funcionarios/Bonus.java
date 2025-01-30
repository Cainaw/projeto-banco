package funcionarios;

public class Bonus {
	public Double bonificacao;

	Bonus() {
		this.bonificacao = 0.0;
	}
	
	public Boolean setBonus(Double valor) {
		try {
			if (valor >= 0.0) {
				this.bonificacao = valor;
				return true;
			} 
			System.out.println("Atualização de bonus efetuada");
		}
		catch (Exception e) {
			System.err.println("Erro ao bonificar: " + e.getMessage());
		}
		return false;
	}

	public Double getBonus() {
		return bonificacao;
	}
}
