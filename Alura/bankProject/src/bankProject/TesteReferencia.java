package bankProject;

public class TesteReferencia {
	public static void main(String[] args) {
		Conta primeiraConta = new Conta();
		primeiraConta.deposita(300);
		
		System.out.println("saldo da primeira: " + primeiraConta.getSaldo());
		
		Conta segundaConta = primeiraConta;
		
		System.out.println("saldo da segunda conta: " + segundaConta.getSaldo());
		
		segundaConta.deposita(100);
		System.out.println("saldo da segunda conta: " + segundaConta.getSaldo());
		System.out.println("saldo da primeira: " + primeiraConta.getSaldo());
		
		if(primeiraConta == segundaConta)
				System.out.println("sao a mesma conta");
		
		System.out.println(primeiraConta);
		System.out.println(segundaConta);
	}
}