package contas;

public class AppTesteContas {

	public static void main(String[] args) {
		ContaDigital conta = new ContaDigital();
		
		conta.depositar(500.0);
		conta.setCredito();
		conta.setCredito();
		conta.sacar(600.0);
		
		System.out.println("\nID: " + ContaDigital.getId());
		System.out.println("Saldo: " + conta.getSaldo());
		System.out.println("Credito ativo: " + conta.isCredito());
		System.out.println("Limite: " + conta.getLimiteEstabelecido());
		System.out.println("Limite atual: " + conta.getLimiteUsado());
	}

}
