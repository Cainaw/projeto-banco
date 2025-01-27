package banco;

import gerencia.*;

public class AppTesteBanco {

	public static void main(String[] args) {
		System.out.println("Contas: " + Conta.getNumero());
		
		Conta conta = new Conta("Cai", "Nam", "1234");
		
		conta.depositar(500.0);
		
		conta.sacar(650.0);
		conta.depositar(200.0);
		
		conta.pagarEmprestimo();
		
		conta.sacar(250.0);
		
		System.out.println("Saldo atual: " + conta.getSaldo());
		System.out.println("Emprestimo: " + conta.getEmprestimo());
		
		Empresa empresa = new Empresa("Abelha", "1234", 3);
		
		empresa.contratarFuncionario(new Funcionario("Cainã Mateus", "Wanzeler Costa", "12345"));
		empresa.contratarFuncionario(new Funcionario("Maria Gabrielly", "dos Santos Lima", "23456"));
		empresa.contratarFuncionario(new Funcionario("Sofia Louise", "Wanzeler Duarte", "34567"));
		
		empresa.demitirFuncionario(empresa.acharFuncionario(1));
		empresa.setQtdFuncionarios(3);
		
		
		
		//empresa.dadosFuncionarios();
	}

}
