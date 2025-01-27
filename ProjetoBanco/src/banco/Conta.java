package banco;

public class Conta extends Cliente {
	private static int numero;
	private Double saldo;
	private Double limite;
	private Double emprestimo;
	
	public Conta(String nome, String sobrenome, String cpf) {
		super(nome, sobrenome, cpf);
		Conta.numero += 1;
		this.saldo = 0.0;
		this.limite = 200.0;
		this.emprestimo = this.limite;
	}
	
	public Boolean sacar(Double valor) {
		if (valor > 0.0 && valor <= (this.saldo + this.emprestimo)) {
			this.saldo -= valor;
			
			if (this.saldo < 0.0) {
				valor = - this.saldo;
				emprestimo(valor);
				depositar(valor);
			}
			return true;
		} return false;
	}
	
	public Boolean depositar(Double valor) {
		if (valor > 0.0) {
			this.saldo += valor;
			return true;
		} return false;
	}
	
	private Boolean emprestimo(Double valor) {
		if (valor > 0.0 && valor <= this.emprestimo) {
			this.emprestimo -= valor;
			return true;
		} return false;
	}
	
	public Boolean pagarEmprestimo() {
		Double valorFaltante = this.getEmprestimo();
		
		if (sacar(valorFaltante)) {
			this.emprestimo += valorFaltante;
			return true;
		} return false;
 	}
	
	public Boolean transferir(Conta conta, Double valor) {
		if (this.sacar(valor))
			return conta.depositar(valor);
		return false;
	}
	
	public Double getSaldo() {
		return this.saldo;
	}
	
	public Double getLimite() {
		return this.limite;
	}
	
	public Double getEmprestimo() {
		return this.getLimite() - this.emprestimo;
	}
	
	public static int getNumero() {
		return Conta.numero;
	}
}
