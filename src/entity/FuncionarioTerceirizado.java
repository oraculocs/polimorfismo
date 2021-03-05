package entity;

public class FuncionarioTerceirizado extends Funcionario{
	
	private Double adicional;
		
	public FuncionarioTerceirizado() {
		super();
	}

	public FuncionarioTerceirizado(String nome, Integer horas, Double valorHora, Double adicional) {
		super(nome, horas, valorHora);
		this.adicional = adicional;
	}

	public Double getAdicional() {
		return adicional;
	}

	public void setAdicional(Double adicional) {
		this.adicional = adicional;
	}


	@Override
	public Double pagamento() {
		return super.pagamento() + adicional * 1.1;
	}
	
	@Override
	public String toString() {
		return getNome() + " - $ " + String.format("%.2f", pagamento());
	}

}
