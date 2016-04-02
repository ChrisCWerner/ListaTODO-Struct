package br.unb.struct.trainee.listaTodo;

//import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import br.unb.struct.trainee.listaTodo.OutOfBounds;

@SuppressWarnings("serial")
public class Lista implements java.io.Serializable {

	private List<Item> lista;
	public String nome;
	
	private static final transient String NOME_PADRAO = "Nova Lista TODO";
	
	public Lista(){
		lista = new ArrayList<Item>();
		setNome(NOME_PADRAO);
	}
	
	public Lista(String nome){
		this();
		setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	public void novoItem(){
		lista.add(new Item());
	}
	
	public void novoItem(String item){
		lista.add(new Item(item));
	}
	
	public void removeItem(int index) throws OutOfBounds {
		OutOfBounds.thrower(this.getSize(), index);
		
		lista.remove(index - 1);
	}
	
	public void reposiciona(int de, int para) throws OutOfBounds {
		//Valores que extrapolam o tamanho da lista
		//jogam excessao, por default.
		OutOfBounds.thrower(this.getSize(), de);
		OutOfBounds.thrower(this.getSize(), para);
		
		if(para >= de){
			lista.add(para, this.getItem(de));
			this.removeItem(de);
		}
		else {
			lista.add(para - 1, this.getItem(de));
			this.removeItem(de + 1);
		}
	}
	
	public Item getItem(int index) throws OutOfBounds {
		//Nao existe item '0' para a lista,
		//o primeiro item sera o item 1.
		OutOfBounds.thrower(this.getSize(), index);
		return lista.get(index - 1);
	}
	
	public int getSize(){
		return lista.size();
	}
	
	public void printaLista() throws OutOfBounds {
		if(this.getSize() == 0){
			throw new OutOfBounds("LV");
		}
		try {
			for(int i = 1; i <= this.getSize(); i++){
				System.out.println("[" + i + "] " +
						(this.getItem(i).isDone() ? "[DONE] " : "[TODO] ") + 
								this.getItem(i).getItemString());
			}
		}
		catch(OutOfBounds e){
			System.out.println(e.getMessage());
		}
	}
}
