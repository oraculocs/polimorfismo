package entity;

public class ProdutoImportado extends Produto{
	
	private Double taxaAlfandega;

	public ProdutoImportado() {
		super();
	}

	public ProdutoImportado(String nome, Double preco, Double taxaAlfandega) {
		super(nome, preco);
		this.taxaAlfandega = taxaAlfandega;
	}

	public Double getTaxaAlfandega() {
		return taxaAlfandega;
	}

	public void setTaxaAlfandega(Double taxaAlfandega) {
		this.taxaAlfandega = taxaAlfandega;
	}
	
	@Override
	public String etiquetaPreco() {
		return getNome() + " $" + String.format("%.2f", precoTotal()) + " (Customs fee: $ " + String.format("%.2f", taxaAlfandega) + ")";
	}
	
	public Double precoTotal() {
		return getPreco() + taxaAlfandega;
	}

}
