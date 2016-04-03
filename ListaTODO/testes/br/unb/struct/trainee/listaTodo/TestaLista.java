package br.unb.struct.trainee.listaTodo;

import org.junit.Assert;

import org.junit.Test;

import br.unb.struct.trainee.listaTodo.Lista;
import br.unb.struct.trainee.listaTodo.OutOfBounds;

public class TestaLista {

	
	@Test
	public void testaInsercao() {
		Lista lista = new Lista(); 
		
		lista.novoItem("New Item!");
		lista.novoItem();
		
		try {
			Assert.assertEquals("New Item!", lista.getItem(1).getItemString());
			Assert.assertEquals("Novo item", lista.getItem(2).getItemString());
		}
		catch(OutOfBounds e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testaRemocao(){
		Lista lista = new Lista();
		
		lista.novoItem("New Item!");
		lista.novoItem();
		
		try {
			lista.removeItem(1);
			
			Assert.assertEquals(1, lista.getSize());
			Assert.assertEquals("Novo item", lista.getItem(1).getItemString());
			
		} catch (OutOfBounds e) {
			System.out.println(e.getMessage());
		}
		try {
			lista.removeItem(8);
			lista.removeItem(0);
			
		} catch (OutOfBounds e) {
			System.out.println(e.getMessage());
			Assert.assertEquals(1, lista.getSize());
		}
	}
	
	@Test
	public void testaReposicao(){
		Lista lista = new Lista();
		
		lista.novoItem("1 New Item!");
		lista.novoItem("2 Novo item");
		lista.novoItem("3 New Aitem!");
		lista.novoItem("4 Niu Iteim!");
		lista.novoItem("5 Niu Aitem!");
		
		try{
			lista.reposiciona(1, 3);
			lista.printaLista();
			Assert.assertEquals("1 New Item!", lista.getItem(3).getItemString());
		} catch(OutOfBounds e){
			System.out.println(e.getMessage());
		}
		
		try{
			lista.reposiciona(7, 4);
			lista.printaLista();
			Assert.assertEquals("5 Niu Aitem!", lista.getItem(4).getItemString());
		} catch(OutOfBounds e){
			System.out.println(e.getMessage());
		}
		
		try{
			lista.reposiciona(8, 2);
			lista.printaLista();
			Assert.assertEquals("4 Niu Iteim!", lista.getItem(2).getItemString());
		} catch(OutOfBounds e){
			System.out.println(e.getMessage());
		}
		
		try{
			lista.reposiciona(2, 2);
			lista.printaLista();
			Assert.assertEquals("3 New Aitem!", lista.getItem(2).getItemString());
		} catch(OutOfBounds e){
			System.out.println(e.getMessage());
		}
	}
	
}
