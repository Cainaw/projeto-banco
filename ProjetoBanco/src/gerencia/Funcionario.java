package gerencia;

import util.*;

public class Funcionario extends Pessoa {
	private String departamento;
	private String identificador;
	private Double salario;
	private Boolean demitido;
	private Data dataEntrada;
	
	public Funcionario(String nome, String sobrenome, String cpf) {
		super.setNome(nome);
		super.setSobrenome(sobrenome);
		super.setCpf(cpf);
	}
	
	public Boolean bonificar(Double porcentagem) {
		if (porcentagem > 0.0 && salario != null) {
			this.salario += this.salario * (porcentagem / 100.0);
			return true;
		} return false;
	}
	
	public void extrairDados() {
		System.out.println("Nome completo: " + super.getNome() + " " + super.getSobrenome());
		System.out.println("CPF: " + super.getCpf());
		
		System.out.print("RG: ");
		if (super.getRg() != null)
			System.out.println(super.getRg());
		else
			System.out.println("Indisponível");
		
		System.out.print("Identificador: ");
		if (identificador != null)
			System.out.println(identificador);
		else
			System.out.println("Indisponível");
		
		System.out.print("Data de Entrada: ");
		if (dataEntrada != null)
			System.out.println(dataEntrada.getData());
		else
			System.out.println("Indisponível");
		
		System.out.print("Salário: ");
		if (salario != null)
			System.out.println(salario);
		else
			System.out.println("Indisponível");
		
		System.out.print("Departamento: ");
		if (departamento != null)
			System.out.println(departamento);
		else
			System.out.println("Indisponível");
		
		System.out.print("Situação: ");
		if (demitido != null) {
			String situacao = "Contratado";
			if (demitido)
				situacao = "Demitido";
			System.out.println(situacao);
		}
		else
			System.out.println("Indisponível");
	}
	
	public void contratar() {
		this.demitido = false;
	}
	
	public void demitir() {
		this.demitido = true;
		this.identificador = null;
	}
	
	public String getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	public Double getSalario() {
		return salario;
	}
	
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	public Boolean getDemitido() {
		return demitido;
	}
	
	public Data getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Integer DD, Integer MM, Integer AA) {
		this.dataEntrada = new Data(DD, MM, AA);
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador.toString();
	}
}
