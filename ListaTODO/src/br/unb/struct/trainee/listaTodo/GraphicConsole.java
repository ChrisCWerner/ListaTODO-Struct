package br.unb.struct.trainee.listaTodo;

//import javax.swing;
//import javax.accessibility;

import java.io.*;

public class GraphicConsole implements UserInterface {
	
	private Lista lista;
	private FileManager fm = new FileManager();
	
	public GraphicConsole(Lista lista) {
		this.lista = lista;
		fm.inicializaDir();
	}
	
	
	@Override
	public void opcoes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int checaOpcoes(String opcao) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void inserirItem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserirItem(String nome) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerItem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerItem(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reposicionarItem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reposicionarItem(int de, int para) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void marcarFeito() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void marcarFeito(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void salvarLista() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void salvarLista(String nome) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void imprimirLista() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criarNovaLista() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void abrirUmaLista() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void abrirUmaLista(String nome) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletarUmaLista() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletarUmaLista(String nome) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void renomearUmaLista() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void renomearUmaLista(String antes, String depois) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sair() {
		// TODO Auto-generated method stub
		
	}

}
