import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.print("Qual a quantidade de atletas? ");
		int N = sc.nextInt();
		
		double somaPeso = 0.00;
		double maiorAltura = 0.00;
		double somaAlturaMulheres = 0.00;
		String atletaMaisAlto = "";
		int totalHomens = 0;
		int totalMulheres = 0;
		
		for(int i = 1; i <= N; i++) {
			sc.nextLine();
			System.out.printf("Digite os dados do atleta número %d:%n", i);
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			
			// Dados do sexo do atleta
			System.out.print("Sexo: ");
			char sexo;
			do {
				sexo = sc.next().charAt(0);
				if (sexo != 'F' && sexo != 'M') {
					System.out.print("Valor invalido! Favor digitar F ou M: ");
				}
			} while (sexo != 'F' && sexo != 'M');
		
			
			// Dados da altura
			System.out.print("Altura: ");
			double altura;
			do {
				altura = sc.nextDouble();
				if (altura <= 0) {
					System.out.print("Valor inválido! Favor digitar um valor positivo: ");
				}
			} while (altura <= 0);
			
			if (altura > maiorAltura) {
				maiorAltura = altura;
				atletaMaisAlto = nome;
			}
			
			if (sexo == 'M') {
				totalHomens += 1;
			}
			else {
				totalMulheres += 1;
				somaAlturaMulheres += altura;
			}
			
			
			// Dados do peso do atleta
			System.out.print("Peso: ");
			double peso;
			do {
				peso = sc.nextDouble();
				if (peso <= 0) {
					System.out.print("Valor inválido! Favor digitar um valor positivo: ");
				}
			} while (peso <= 0);
			
			somaPeso += peso;
			
			
		}
		
		double pesoMedio = somaPeso / N;
		double percentHomens = totalHomens * 100.00 / N;
		
		System.out.println();
		System.out.println("RELATÓRIO:");
		System.out.printf("Peso médio dos atletas: %.2f%n", pesoMedio);
		System.out.printf("Atleta mais alto: %s%n", atletaMaisAlto);
		System.out.printf("Porcentagem de homens: %.1f %%%n", percentHomens);
		
		if (totalMulheres > 0) {
			double alturaMediaMulheres = somaAlturaMulheres / totalMulheres;
			System.out.printf("Altura média das mulheres: %.2f%n", alturaMediaMulheres);
		}
		else {
			System.out.println("Não há muheres cadastradas");
		}
		
		
		sc.close();

	}

}
