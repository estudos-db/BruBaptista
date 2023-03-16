package bankProject;

public class TestaMetodo {
	public static void main(String[] args) {
		Conta contaPaulo = new Conta();
		contaPaulo.deposita(100);
		contaPaulo.deposita(50);
		System.out.println(contaPaulo.getSaldo());
		
		boolean conseguiuRetirar = contaPaulo.saca(20);
		System.out.println(contaPaulo.getSaldo());
		System.out.println(conseguiuRetirar);
		
		Conta contaMarcela = new Conta();
		contaMarcela.deposita(1000);
		
		if (contaMarcela.transfere(300, contaPaulo)) {
			System.out.println("tranferencia feita com sucesso");
		} else {
			System.out.println("faltou dinheiro");
		}
		
		System.out.println(contaMarcela.getSaldo());
		System.out.println(contaPaulo.getSaldo());
	}
}
