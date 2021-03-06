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
		
		System.out.println("  *-*-* Teste 2 *-*-*");

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
		
//		Lista temp = new Lista();
//		temp = fm.abrirLista("wasd");
		
//		Assert.assertFalse(temp == null);
		
		Assert.assertFalse(fm.listaExiste("Um Nome Aleatorio"));
		try{
			fm.abrirLista("Um Nome Aleatorio");
			Assert.assertTrue(fm.listaExiste("Um Nome Aleatorio"));		//vai dar false
		} catch (FileException e){
			Assert.assertFalse(fm.listaExiste("Um Nome Aleatorio"));	//vai dar true
		}
		
	}
	
	@Test
	public void testaAbrirLista() throws FileException, OutOfBounds {
		
		Lista lista;
		FileManager fm = new FileManager();
		
		System.out.println("  *-*-* Teste 3 *-*-*");
		
		System.out.println("\na) abrir lista: ");
		
		lista = fm.abrirLista("Exemplo");
		
		System.out.println("\nb) printa lista: ");
		
		lista.printaLista();
		
	}
	
	@Test
	public void testaRenomearLista() throws FileException, OutOfBounds {
		
		Lista lista = new Lista();
		FileManager fm = new FileManager();
		TextConsole console = new TextConsole(lista);
		
		System.out.println("  *-*-* Teste 1 *-*-*");
		
		console.inserirItem("Um item");
		console.salvarLista("Teste");
		Assert.assertTrue(fm.listaExiste("Teste"));
		
		console.renomearUmaLista("Teste", "etseT");
		Assert.assertEquals("etseT", lista.getNome());
		
		lista = fm.abrirLista("etseT");
		Assert.assertEquals("etseT", lista.getNome());
		
		console.deletarUmaLista("etseT");
		Assert.assertFalse(fm.listaExiste("etseT"));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
