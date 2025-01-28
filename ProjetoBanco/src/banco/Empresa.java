package banco;

import gerencia.*;

// modificar a parte de contratações e demissões para adicionar robustez ao projeto

public class Empresa {
	private Funcionario [] funcionarios;
	private String nome;
	private String cpnj;
	private String senha;
	private Integer totalFuncionarios;
	
	public Empresa(String nome, String cnpj, int qtdFuncionarios) {
		this.nome = nome;
		this.cpnj = cnpj;
		funcionarios = new Funcionario[qtdFuncionarios];
		totalFuncionarios = 0;
	}
	
	public Boolean contratar(Funcionario funcionario) {
		int indice = 0;
		for (Funcionario f : funcionarios) {
			if (f == null) {
				funcionarios[indice] = funcionario;
				funcionario.contratar();
				funcionario.setIdentificador(indice);
				
				totalFuncionarios++;
				return true;
			} indice++;
		}
		return false;
	}
	
	public Boolean demitir(Funcionario funcionario) {
		int indice = 0;
		for (Funcionario f : funcionarios) {
			if (f.equals(funcionario)) {
				funcionarios[indice] = null;
				funcionario.demitir();
				
				totalFuncionarios--;
				return true;
			} indice++;
		}
		return false;
	}
	
	public Funcionario acharFuncionario(Integer indice) {
		if (indice >= funcionarios.length || indice < 0)
			return null;
		return funcionarios[indice];
	}
	
	public Boolean verificarFuncionario(Funcionario funcionario) {
		if (funcionario == null) 
			return false;
		return !funcionario.getDemitido();
	}
	
	public void dadosFuncionarios() {
		for (Funcionario funcionario : funcionarios) {
			if (funcionario != null) {
				funcionario.extrairDados();
				System.out.println();
			}
		} 
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpnj() {
		return cpnj;
	}

	private String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getQtdFuncionarios() {
		return funcionarios.length;
	}
	
	public Boolean setQtdFuncionarios(Integer novaQtd) {
		if (novaQtd < 0 || totalFuncionarios > novaQtd || funcionarios.length == novaQtd)
			return false;
		
		Funcionario [] novoEspaco = new Funcionario[novaQtd];
		
		int indice = 0;
		for (Funcionario funcionario : funcionarios) {
			if (verificarFuncionario(funcionario)) {
				novoEspaco[indice] = funcionario;
				funcionario.setIdentificador(indice++);
			}
		}
		
		funcionarios = novoEspaco;
		
		return true;
	}
	
	public String [] getFuncoes() {
		String [] lista = new String[5];
		
		int indice = 0;
		boolean verificador;
		for (Funcionario funcionario : funcionarios) {
			verificador = true;
			for (String funcao : lista) {
				if (funcao.equalsIgnoreCase(funcionario.getFuncao())) {
					verificador = false;
					break;
				}
			}
			
			if (verificador)
				lista[indice++] = funcionario.getFuncao();
		}
		
		return lista;
	}
}
