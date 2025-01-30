package funcionarios;

public class AppTesteFuncionario {

	public static void main(String[] args) {
		Funcionario cai = new Gerente("Cai", "Mathew", "234");
		
		
		
		cai.setRg("001");
		cai.setDataEntrada(1, 7, 2004);
		cai.setSalario(2000.0);
		
		//cai.bonificar(15.0);
		cai.setIdentificador(10);
		
		cai.setDepartamento("TI");
		cai.contratar();
		cai.extrairDados();
	}

}
