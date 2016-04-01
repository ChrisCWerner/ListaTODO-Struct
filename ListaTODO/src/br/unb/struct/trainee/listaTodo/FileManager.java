package br.unb.struct.trainee.listaTodo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import br.unb.struct.trainee.listaTodo.FileException;

@SuppressWarnings("serial")
public class FileManager implements Serializable {

	private static final String THIS_DIR = System.getProperty("user.dir");
	private static final Path LISTAS_DIR = Paths.get(THIS_DIR, "ListasTODO");
	
	
	
	public void inicializaDir() {
		File f = new File(LISTAS_DIR.toString());
		
		if(!(f.exists() && f.isDirectory()))
			try {
				Files.createDirectory(LISTAS_DIR);
			}
			catch(IOException e){
				
			}
	}
	
	private static final String addTdlsSuffix(String nome){
		if(!nome.endsWith(".tdls"))
			return nome + ".tdls";
		return nome;
	}
	
	public Path pathLista(String nome){
		nome = addTdlsSuffix(nome);
		return Paths.get(LISTAS_DIR.toString(), nome);
	}
	
	public boolean listaExiste(String nome){
		File f = new File(pathLista(nome).toString());
		
		return (f.exists() && f.isFile());
	}
	
	public void criaListaDefault(Lista lista) throws FileException{
		
		if(lista.getSize() == 0)	return;
		if(this.listaExiste(lista.getNome()) && !lista.getNome().startsWith("Nova Lista TODO"))
			throw new FileException("LJE");
		
		try{
			salvarNovaLista(lista);
		}
		catch(FileException e){
			int i;
			for(i = 2; i < 20; i++){
				try{
					lista.setNome("Nova Lista TODO " + i);
					salvarNovaLista(lista);
					break;
				}
				catch(FileException f){
					
				}
			}
			if(i == 20){
				throw new FileException("LLA");
			}
		}
	}
	
	public void salvarNovaLista(Lista lista) throws FileException{
		String nome = lista.getNome();
		nome = addTdlsSuffix(nome);
		
		if(listaExiste(nome))	throw new FileException("LJE");
		
		try {
			FileOutputStream fout = new FileOutputStream(LISTAS_DIR.toString() + "\\" + nome);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(lista);
			oos.close();
		}
		catch(Exception e){
//			System.out.println("Erro ao salvar arquivo!");
		}
	}
	
	public Lista abrirLista(String nome) throws FileException{
		nome = addTdlsSuffix(nome);
		if(!listaExiste(nome)){
			throw new FileException();
		}
		else {
			Lista lista = null;
			/*
			 * TODO	Consertar o m�todo abrir lista
			 */
			try{
				FileInputStream fin = new FileInputStream(pathLista(nome).toString());
				ObjectInputStream ois = new ObjectInputStream(fin);
				lista = (Lista) ois.readObject();
				ois.close();
			} catch(IOException e){
				System.out.println("IOException!");
			} catch(ClassNotFoundException e){
				System.out.println("ClassNotFoundException!");
			}
			
			return lista;
		}
	}
	
	public void deletarLista(String nome) throws FileException{
		try{
			if(!listaExiste(nome))
				throw new FileException();
			
			Files.delete(pathLista(nome));
			
		} catch (IOException e) {
			
		}
	}
	
	public void overwriteLista(Lista lista) throws FileException{
		deletarLista(lista.getNome());
		salvarNovaLista(lista);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}