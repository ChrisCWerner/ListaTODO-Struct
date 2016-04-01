package br.unb.struct.trainee.listaTodo;

/**
 * Joga excessoes quando os limites da lista sao extrapolados. 
 * Isso acontece quando o indice inserido eh menor que '1' ou
 * maior que o tamanho da lista.
 * 
 * @author Christian
 *
 */

@SuppressWarnings("serial")
public class OutOfBounds extends Exception{

	private int indiceMaximo;
	private int indiceRecebido;
	private String caso;
	
	public OutOfBounds(String caso){
		this.caso = caso;
	}
	
	public OutOfBounds(int indiceMaximo, int indiceRecebido){
		this("OOB");
		this.indiceMaximo = indiceMaximo;
		this.indiceRecebido = indiceRecebido;
	}

	public String getCaso(){
		return caso;
	}
	
	@Override
	public String getMessage(){
		switch(caso){
			case "OOB":		return "\nLimites da lista extrapolados! Indice recebido = " 
										+ indiceRecebido + ", indice esperado = [1, " 
												+ indiceMaximo + "]\n";
			
			case "LV":		return "Lista vazia!";
			
			default:		return "";
		}
	}
	
	public static void thrower(int indiceMaximo, int indiceRecebido) throws OutOfBounds {
		if(indiceMaximo < 1)
			throw new OutOfBounds("LV");
		if(indiceRecebido < 1 || indiceMaximo < indiceRecebido)
			throw new OutOfBounds(indiceMaximo, indiceRecebido);
	}
}
