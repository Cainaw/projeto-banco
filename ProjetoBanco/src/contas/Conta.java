package contas;

public interface Conta {
	public Boolean sacar(Double valor);
	
	public Boolean depositar(Double valor);
	
	public Boolean transferir(Conta conta, Double valor);
}
