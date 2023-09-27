package universidad;

public class Nota {

	private Integer valor;
	private TipoNota tipoNota;
	
	public Nota(TipoNota tipoNota, Integer valor) {
		this.valor=valor;
		this.tipoNota=tipoNota;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	public TipoNota getTipoNota() {
		return tipoNota;
	}
	public void setTipoNota(TipoNota tipoNota) {
		this.tipoNota = tipoNota;
	}


}
