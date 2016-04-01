package br.unb.struct.trainee.listaTodo;

import org.junit.Assert;

import org.junit.Test;

import br.unb.struct.trainee.listaTodo.FileException;
import br.unb.struct.trainee.listaTodo.FileManager;
import br.unb.struct.trainee.listaTodo.Lista;
import br.unb.struct.trainee.listaTodo.OutOfBounds;
import br.unb.struct.trainee.listaTodo.TextConsole;

public class TestaFileManager {

	@Test
	public void testaNovoArquivo() throws OutOfBounds, FileException{
		Lista lista = new Lista();
		TextConsole console = new TextConsole(lista);
		FileManager fm = new FileManager();

		console.inserirItem("item 1");
		console.inserirItem("item 2");
		console.inserirItem("item 3");
		console.inserirItem("item 4");
		console.inserirItem("item 5");

		System.out.println("\nPassou 0!\n");
		
		console.salvarLista("Lista Um");
		Assert.assertTrue(fm.listaExiste("Lista Um"));
		
		System.out.println("\nPassou 1!\n");
		
		console.criarNovaLista();
		
		console.inserirItem("item 1");
		console.inserirItem("item 2");
		console.inserirItem("item 3");
		console.inserirItem("item 4");

		System.out.println("\nPassou 2!\n");
		
		console.criarNovaLista();
		Assert.assertTrue(fm.listaExiste(lista.getNome()));
		
		console.abrirUmaLista("Lista Um");
		Assert.assertEquals(5, lista.getSize());
		Assert.assertTrue(fm.listaExiste("Lista Um"));
		Assert.assertEquals("item 5", lista.getItem(5).getItemString());
		
		System.out.println("\nPassou 3!\n");
		
		Assert.assertFalse(fm.listaExiste("Um Nome Aleatorio"));
		try{
			fm.abrirLista("Um Nome Aleatorio");
			Assert.assertTrue(fm.listaExiste("Um Nome Aleatorio"));		//vai dar false
		} catch (FileException e){
			Assert.assertFalse(fm.listaExiste("Um Nome Aleatorio"));	//vai dar true
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
