package banco;

import gerencia.*;

// modificar a parte de contratações e demissões para adicionar robustez ao projeto

public class Empresa {
	private Funcionario [] funcionarios;
	private Gerente gerente;
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
	
	public Boolean contratarGerente(Gerente gerente) {
		if (this.gerente == null) {
			this.gerente = gerente;
			gerente.contratar();
			return true;
		}
		return false;
	}
	
	public Boolean demitirGerente() {
		if (this.gerente != null) {
			this.gerente.demitir();
			this.gerente = null;
			return true;
		}
		return false;
	}
	
	public Boolean contratarFuncionario(Funcionario funcionario) {
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
	
	public Boolean demitirFuncionario(Funcionario funcionario) {
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
		return senha;
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
	
	
}
