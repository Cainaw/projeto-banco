package banco;

import funcionarios.*;

public class AppTesteBanco {

	public static void main(String[] args) {
		// erro ao mostrar dados dos funcionarios
		Empresa empresa = new Empresa("Abelha", "1234", 3);
		Gerente gerente = new Gerente("Cainã Mateus", "Wanzeler Costa", "12345");
		
		gerente.setSalario(5000.0);
		empresa.contratar(gerente);
		empresa.getControle().bonificar(gerente, 400.0);
		
		System.out.println("Salario: " + gerente.getSalario());
		System.out.println("Bonus: " + gerente.getBonificacao().getBonus());
		
		empresa.dadosFuncionarios();
		
		
		//empresa.contratar(new Funcionario("Maria Gabrielly", "dos Santos Lima", "23456"));
		//empresa.contratar(new Funcionario("Sofia Louise", "Wanzeler Duarte", "34567"));
		
		//empresa.demitir(empresa.acharFuncionario(1));
		//empresa.setQtdFuncionarios(3);
		
		
	}

}
