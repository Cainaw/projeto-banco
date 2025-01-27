package util;

public class Pessoa {
	private String nome;
	private String sobrenome;
	private String cpf;
	private String rg;
	private Boolean vivo;
	private Boolean dadosCompletos;
	private Integer contaDados;
	private Integer totalDados;
	
	public Pessoa() {
		totalDados = 5;
		contaDados = 0;
		dadosCompletos = false;
	}
	
	public Boolean statusDados() {
		return dadosCompletos;
	}
	
	private void atualizaStatus() {
		if ((++contaDados).equals(totalDados))
			dadosCompletos = true;
	}
	
	public Integer dadosCompletados() {
		return this.contaDados;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if (this.nome == null)
			atualizaStatus();
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		if (this.sobrenome == null)
			atualizaStatus();
		this.sobrenome = sobrenome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		if (this.cpf == null)
			atualizaStatus();
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		if (this.rg == null)
			atualizaStatus();
		this.rg = rg;
	}
	public Boolean getVivo() {
		return vivo;
	}
	public void setVivo(Boolean vivo) {
		if (this.vivo == null)
			atualizaStatus();
		this.vivo = vivo;
	}
	
	
}
