package br.unb.struct.trainee.listaTodo;

public class Main {

	public static void main(String[] args) {
		
		Lista lista = new Lista();
		
		TextConsole cns = new TextConsole(lista);
		
		cns.opcoes();
		
	}
}
