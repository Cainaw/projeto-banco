package funcionarios;

public class ControleDeBonificacao {
	private Double registroBonificacao;
	
	public ControleDeBonificacao() {
		this.registroBonificacao = 0.0;
	}
	
	public void bonificar(Funcionario funcionario, Double valor) {
		if (funcionario.getBonificacao().setBonus(valor)) {
			registrarBonificacao(funcionario);
		}
	}
	
	public Boolean registrarBonificacao(Funcionario funcionario) {
		try {
			if (funcionario != null) {
				this.registroBonificacao += funcionario.getBonificacao().getBonus();
				return true; 
			} return false;
		}
		catch (Exception e) {
			System.err.println("Erro ao fazer registro: " + e.getMessage());
			return null;
		}
	}
	
	public Double getRegistro() {
		return this.registroBonificacao;
	}
}
