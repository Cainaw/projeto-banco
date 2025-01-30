package contas;

import util.Taxa;

public class ContaCorrente implements Conta, Taxa {
	private static int id;
	private Double percentual;
	private Double saldo;
	private Double limiteEstabelecido;
	private Double limiteUsado;
	private Boolean credito;
	
	ContaCorrente () {
		this.credito = false;
		this.limiteEstabelecido = 0.0;
		this.limiteUsado = this.limiteEstabelecido;
		this.saldo = 0.0;
		this.percentual = 0.0;
		ContaCorrente.id++;
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
			System.out.println("Saldo insuficiente para o saque!");
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
			if (valor > 0.1) {
				this.saldo += (valor - 0.1);
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
	
	public Boolean pagarLimite() {
		String saida = "O crédito está desativado!";
		if (this.isCredito()) {
			saida = "Você não tem nenhuma divida ainda! PS: Ainda ;)";
			if (this.getLimiteEstabelecido() != this.getLimiteUsado()) {
				Double divida = this.getLimiteEstabelecido() - this.getLimiteUsado();
				
				if (this.getSaldo() >= divida) {
					this.saldo -= divida;
					System.out.println("Divida quitada com sucesso!");
					return true;
				}
				
				saida = "Saldo insuficiente para o pagamento.";
			}
		}
		System.out.println(saida);
		return false;
	}

 	public Double getSaldo() {
		return saldo;
	}
 	
	public Boolean isCredito() {
		return this.credito;
	}

	public void setCredito() {
		if (this.isCredito()) {
			if (this.getLimiteEstabelecido() == this.getLimiteUsado()) {
				this.setLimiteEstabelecido(0.0);
				this.credito = !this.isCredito();
				System.out.println("Débito ativado.");
				
				return;
			}
			System.out.println("O limite está pendente...");
			return;
		}
		
		this.credito = !this.isCredito();
		this.setLimiteEstabelecido(200.0);
		System.out.println("Crédito ativado.");
	}
	
	public static int getId() {
		return ContaCorrente.id;
	}
	
	public Double getLimiteUsado() {
		return this.limiteUsado;
	}
	
	public Double getLimiteEstabelecido() {
		return this.limiteEstabelecido;
	}
	
	public void setLimiteEstabelecido(Double novoLimite) {
		try {
			if (this.isCredito()) {
				if (this.getLimiteUsado() == this.getLimiteEstabelecido()) {
					this.limiteEstabelecido = novoLimite;
					this.limiteUsado = this.limiteEstabelecido;
					System.out.println("Valor do limite alterado com sucesso!");
					return;
				}
				System.out.println("Limite ainda está em debito!");
				return;
			}
			System.out.println("O cartão de crédito está desativado!");
		}
		catch (Exception e) {
			System.out.println("Erro ao tentar estabelecer novo limite: " + e.getMessage());
		}
	}
	
	@Override
	public void atualizarSaldo() {
		this.saldo += (this.saldo * this.percentual * 2.0);
	}

	@Override
	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}

	@Override
	public Double getPercentual() {
		return this.percentual;
	}
}
