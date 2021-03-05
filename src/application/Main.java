package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entity.Funcionario;
import entity.FuncionarioTerceirizado;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * Uma empresa possui funcion�rios pr�prios e terceirizados.
		 * Para cada funcion�rio, deseja-se registrar nome, horas
		 * trabalhadas e valor por hora. Funcion�rios terceirizado
		 * possuem ainda uma despesa adicional.
		 * O pagamento dos funcion�rios corresponde ao valor da hora
		 * multiplicado pelas horas trabalhadas, sendo que os
		 * funcion�rios terceirizados ainda recebem um b�nus
		 * correspondente a 110% de sua despesa adicional.
		 * Fazer um programa para ler os dados de N funcion�rios (N
		 * fornecido pelo usu�rio) e armazen�-los em uma lista. Depois
		 * de ler todos os dados, mostrar nome e pagamento de cada
		 * funcion�rio na mesma ordem em que foram digitados.
		 * 
		 * Enter the number of employees: 3
		 * Employee #1 data:
		 * Outsourced (y/n)? n
		 * Name: Alex
		 * Hours: 50
		 * Value per hour: 20.00
		 * Employee #2 data:
		 * Outsourced (y/n)? y
		 * Name: Bob
		 * Hours: 100
		 * Value per hour: 15.00
		 * Additional charge: 200.00
		 * Employee #3 data:
		 * Outsourced (y/n)? n
		 * Name: Maria
		 * Hours: 60
		 * Value per hour: 20.00
		 * PAYMENTS:
		 * Alex - $ 1000.00
		 * Bob - $ 1720.00
		 * Maria - $ 1200.00
		 */

		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com o n�mero de Funcion�rios:");
		int num = sc.nextInt();
		
		Funcionario func = null;
		
		List<Funcionario> f = new ArrayList<>();
		
		for (int i = 0; i < num; i++) {
			System.out.println("Funcion�rio # " + (i + 1) + " data:");
			sc.nextLine();
			System.out.println("Terceirizado (y/n)?");
			String terceiro = sc.nextLine();
			if(terceiro.equals("y")) {
				
				System.out.println("Name:");
				String nome = sc.nextLine();
				
				System.out.println("Horas:");
				Integer horas = sc.nextInt();
				
				System.out.println("Valor por Hora:");
				Double valorHora = sc.nextDouble();
				
				System.out.println("Adicional:");
				Double adicional = sc.nextDouble();
				
				 func = new FuncionarioTerceirizado(nome, horas, valorHora, adicional);
				 f.add(func);
				
			}else {
				System.out.println("Name:");
				String nome = sc.nextLine();
				
				System.out.println("Horas:");
				Integer horas = sc.nextInt();
				
				System.out.println("Valor por Hora:");
				Double valorHora = sc.nextDouble();
				
				
				 func = new Funcionario(nome, horas, valorHora);
				 f.add(func);
			}
		}
		
		System.out.println("PAGAMENTOS:");
		
		for (Funcionario funcionario : f) {
			System.out.println(funcionario);
		}
		
		
		sc.close();
	}

}
