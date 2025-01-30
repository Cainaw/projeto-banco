package contas;

public class AppTesteContas {

	public static void main(String[] args) {
		/*
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
	*/
		
		ContaCorrente cc = new ContaCorrente();
		ContaPoupanca cp = new ContaPoupanca();
		
		cc.depositar(1000.0);
		cp.depositar(1000.0);
		
		cc.setPercentual(0.01);
		cp.setPercentual(0.01);
		
		cc.atualizarSaldo();
		cp.atualizarSaldo();
		
		System.out.println(cc.getSaldo());
		System.out.println(cp.getSaldo());
	}
}
