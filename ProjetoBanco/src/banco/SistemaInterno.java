package banco;

import util.Autenticavel;

public class SistemaInterno {
	private Empresa empresa;
	
	public SistemaInterno(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public Boolean login(Autenticavel pessoa) {
		String senha = pessoa.getSenha();
		
		try {
			if (senha.equals(empresa.getSenha())) {
				System.out.println("Logado com sucesso");
				return true;
			} System.out.println("Senha incorreta");
		}
		catch (Exception e) {
			System.err.println("Erro ao tentar logar: " + e.getMessage());
		}
		return false;
	}
}
