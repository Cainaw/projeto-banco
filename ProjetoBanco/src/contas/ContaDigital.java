package contas;

public class ContaDigital implements Conta {
	private static int id;
	private Double saldo;
	private Double limiteEstabelecido;
	private Double limiteUsado;
	private Double emprestimo;
	private Boolean credito;
	
	ContaDigital () {
		this.credito = false;
		this.limiteEstabelecido = 0.0;
		this.limiteUsado = this.limiteEstabelecido;
		this.emprestimo = 0.0;
		ContaDigital.id++;
	}

	@Override
	public Boolean sacar(Double valor) {
		try {
			if (this.saldo + this.limiteUsado >= valor && valor > 0.0) {
				Double saldoRestante = this.saldo - valor;
				
				if (saldoRestante < 0.0 && this.isCredito()) {
					this.limiteUsado += saldoRestante;
					this.saldo -= saldoRestante;
				}
				
				this.saldo -= valor;
				System.out.println("Saque efetuado com sucesso!");
				return true;
			}
			System.out.println("Valor insuficiente para o saque!");
			return false;
		}
		catch (Exception e) {
			System.err.println("Erro ao sacar: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Boolean depositar(Double valor) {
		try {
			if (valor > 0.0) {
				this.saldo += valor;
				System.out.println("Deposito feito com sucesso!");
				return true;
			}
			System.out.println("Erro, valor inconsistente!");
			return false;
		}
		catch (Exception e) {
			System.err.println("Erro ao depositar: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Boolean pedirEmprestimo(Double valor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean pagarEmprestimo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean transferir(Conta conta, Double valor) {
		try {
			if (this.sacar(valor)) {
				conta.depositar(valor);
				System.out.println("Transferencia efetuada!");
				return true;
			}
			return false;
		} catch (Exception e) {
			System.out.println("Erro ao realizar transferencia: " + e.getMessage());
			return null;
		}
	}

	public Boolean isCredito() {
		return this.credito;
	}

	public void setCredito() {
		if (this.isCredito()) {
			if (this.getLimiteEstabelecido() == this.getLimiteUsado()) {
				this.credito = !this.isCredito();
				System.out.println("Débito ativado.");
				return;
			}
			System.out.println("O limite está pendente...");
			return;
		}
		
		this.credito = !this.isCredito();
		System.out.println("Crédito ativado.");
	}

	public Double getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Double emprestimo) {
		this.emprestimo = emprestimo;
	}
	
	public static int getId() {
		return ContaDigital.id;
	}
	
	public Double getLimiteUsado() {
		return this.limiteUsado;
	}
	
	public Double getLimiteEstabelecido() {
		return this.limiteEstabelecido;
	}
	
	public void setLimiteEstabelecido(Double novoLimite) {
		try {
			if (this.getLimiteUsado() == this.getLimiteEstabelecido()) {
				this.limiteEstabelecido = novoLimite;
				System.out.println("Valor do limite alterado com sucesso!");
				return;
			}
			System.out.println("Limite ainda está em debito!");
		}
		catch (Exception e) {
			System.out.println("Erro ao tentar estabelecer novo limite: " + e.getMessage());
		}
	}
}
