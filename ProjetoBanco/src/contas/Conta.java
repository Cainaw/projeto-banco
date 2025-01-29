package contas;

public interface Conta {
	public Boolean sacar(Double valor);
	
	public Boolean depositar(Double valor);
	
	public Boolean pedirEmprestimo(Double valor);
	
	public Boolean pagarEmprestimo();
	
	public Boolean transferir(Conta conta, Double valor);
}
