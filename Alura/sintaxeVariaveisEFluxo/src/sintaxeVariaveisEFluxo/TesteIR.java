package sintaxeVariaveisEFluxo;

public class TesteIR {
	public static void main(String[] args) {

	    double salario = 3300.0;
	
	    if(salario >= 3751.01) {
	    	System.out.println("o IR e de 7.5% e pode deduzir na declaracao o valor de R$ 142");
	    } else if(salario >= 2800.01) {
	    	System.out.println("o IR e de 15% e pode deduzir na declaracao o valor de R$ 350");
	    } else if(salario >= 1900.0) {
	    	System.out.println("o IR e de 22.5% e pode deduzir na declaracao o valor de R$ 636");
	    } else if(salario < 1900.0) {
	    	System.out.println("Não é necessário pagar o IR");
	    }
	}
}
