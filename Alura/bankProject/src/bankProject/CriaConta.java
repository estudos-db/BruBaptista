package bankProject;

public class CriaConta {
	public static void main(String[] args) {
		Conta primeiraConta = new Conta();
		primeiraConta.deposita(200);
		System.out.println(primeiraConta.getSaldo());
		
		primeiraConta.deposita(100);
		System.out.println(primeiraConta.getSaldo());
		
		Conta segundaConta = new Conta();
		segundaConta.deposita(300);
		
		System.out.println("primeira conta tem " + primeiraConta.getSaldo());
		System.out.println("segunda conta tem " + segundaConta.getSaldo());
		
		primeiraConta.agencia = 146;
		System.out.println(primeiraConta.agencia);
		System.out.println(primeiraConta.numero);
		
		System.out.println(segundaConta.agencia);
		
		segundaConta.agencia = 146;
		
		System.out.println("agora a segunda conta esta na agencia " + segundaConta.agencia);
		
		if(primeiraConta == segundaConta) {
			System.out.println("sao a mesma conta");
		} else
			System.out.println("contas diferentes");
		
		System.out.println(primeiraConta);
		System.out.println(segundaConta);
	}
}
