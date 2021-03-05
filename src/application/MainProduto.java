package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entity.Produto;
import entity.ProdutoImportado;
import entity.ProdutoUsado;

public class MainProduto {
	
	public static void main(String[] args) throws ParseException {
		
		/*
		 * Fazer um programa para ler os dados de N
		 * produtos (N fornecido pelo usuário). Ao final,
		 * mostrar a etiqueta de preço de cada produto na
		 * mesma ordem em que foram digitados.
		 * Todo produto possui nome e preço. Produtos
		 * importados possuem uma taxa de alfândega, e
		 * produtos usados possuem data de fabricação.
		 * Estes dados específicos devem ser
		 * acrescentados na etiqueta de preço conforme
		 * exemplo (próxima página). Para produtos
		 * importados, a taxa e alfândega deve ser
		 * acrescentada ao preço final do produto.
		 * 
		 * 
		 * Enter the number of products: 3
		 * Product #1 data:
		 * Common, used or imported (c/u/i)? i
		 * Name: Tablet
		 * Price: 260.00
		 * Customs fee: 20.00
		 * Product #2 data:
		 * Common, used or imported (c/u/i)? c
		 * Name: Notebook
		 * Price: 1100.00
		 * Product #3 data:
		 * Common, used or imported (c/u/i)? u
		 * Name: Iphone
		 * Price: 400.00
		 * Manufacture date (DD/MM/YYYY): 15/03/2017
		 * PRICE TAGS:
		 * Tablet $ 280.00 (Customs fee: $ 20.00)
		 * Notebook $ 1100.00
		 * Iphone (used) $ 400.00 (Manufacture date: 15/03/2017)
		 */
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Produto> list = new ArrayList<Produto>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com o número de produtos: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Produto " + i + " data:");
			sc.nextLine();
			System.out.println("Produto comum, usado, importado (c/u/i)?");
			String prod = sc.nextLine();
			
			if(prod.equals("c")) {
				System.out.println("Name: ");
				String nome = sc.nextLine();
				
				System.out.println("Preço:");
				Double preco = sc.nextDouble();
				
				Produto p = new Produto(nome, preco);
				
				list.add(p);
			}else if(prod.equals("i")) {
				System.out.println("Name: ");
				String nome = sc.nextLine();
				
				System.out.println("Preço:");
				Double preco = sc.nextDouble();
				
				System.out.println("Taxa Alfandega: ");
				Double taxaAlfandega = sc.nextDouble();
				
				Produto p = new ProdutoImportado(nome, preco, taxaAlfandega);
				
				list.add(p);
			}else {
				System.out.println("Name: ");
				String nome = sc.nextLine();
				
				System.out.println("Preço:");
				Double preco = sc.nextDouble();
				
				System.out.println("Data de Fabricação (DD/MM/YYYY):");
				Date data = sdf.parse(sc.next());
				
				Produto p = new ProdutoUsado(nome, preco, data);
				
				list.add(p);
			}
			
		}
		
		for (Produto produto : list) {
			System.out.println(produto.etiquetaPreco());
		}
		
		sc.close();
		
	}

}
