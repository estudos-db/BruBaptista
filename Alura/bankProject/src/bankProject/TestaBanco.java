package bankProject;

public class TestaBanco {
	public static void main(String[] args) {
		Cliente paulo = new Cliente();
		paulo.nome = "Paulo Silveira";
		paulo.cpf = "222.222.222-22";
		paulo.profissao = "programador";
		
		Conta contaPaulo = new Conta();
		contaPaulo.deposita(100);
		
		contaPaulo.titular = paulo;
		System.out.println(contaPaulo.titular.nome);
		System.out.println(contaPaulo.titular);	
		System.out.println(paulo);	
	}
}
