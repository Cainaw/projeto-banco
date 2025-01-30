package util;

public interface Autenticavel {
	public Boolean autenticar(String senha);
	
	public String getSenha();
	
	public void setSenha(String novaSenha);
}
