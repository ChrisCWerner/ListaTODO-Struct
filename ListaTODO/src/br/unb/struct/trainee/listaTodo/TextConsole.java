package br.unb.struct.trainee.listaTodo;

import java.util.Scanner;

import br.unb.struct.trainee.listaTodo.FileException;
import br.unb.struct.trainee.listaTodo.OutOfBounds;

public class TextConsole implements UserInterface {

	private static Scanner sc = new Scanner(System.in);
	
	private static final int INSERIR_ITEM = 1;
	private static final int REMOVER_ITEM = 2;
	private static final int REPOSICIONAR_ITEM = 3;
	private static final int MARCAR_FEITO = 4;
	private static final int SALVAR_LISTA = 5;
	private static final int IMPRIMIR_LISTA = 6;
	private static final int CRIAR_NOVA_LISTA = 7;
	private static final int ABRIR_LISTA = 8;
	private static final int DELETAR_UMA_LISTA = 9;
	private static final int RENOMEAR_UMA_LISTA = 10;
	private static final int SAIR = 0;
	private static final int OPCAO_INVALIDA = -1;
	
	private Lista lista;
	private FileManager fm = new FileManager();
	
	
	
	public TextConsole(Lista lista){
		this.lista = lista;
		fm.inicializaDir();
	}

	@Override
	public void opcoes(){
		int op;
		
		do {
			do {
				System.out.println("     *-*-* Opcoes *-*-*\n");
				System.out.println("[1] Inserir novo item na lista;");
				System.out.println("[2] Remover um item da lista;");
				System.out.println("[3] Reposicionar um item da lista;");
				System.out.println("[4] Marcar um item como feito;");
				System.out.println("[5] Salvar a lista atual;");
				System.out.println("[6] Imprimir a lista atual;");
				System.out.println("[7] Criar uma nova lista;");
				System.out.println("[8] Abrir outra lista;");
				System.out.println("[9] Deletar uma lista;");
				System.out.println("[10] Renomear uma lista;");
				System.out.println("[0] Sair.\n");
				System.out.println("Selecione uma opcao: ");
				
				op = checaOpcoes(sc.nextLine());
			} while(op == OPCAO_INVALIDA);
			
			switch(op){
				case INSERIR_ITEM:			inserirItem();			break;
				case REMOVER_ITEM:			removerItem();			break;
				case REPOSICIONAR_ITEM:		reposicionarItem();		break;
				case MARCAR_FEITO:			marcarFeito();			break;
				case SALVAR_LISTA:			salvarLista();			break;
				case IMPRIMIR_LISTA:		imprimirLista();		break;
				case CRIAR_NOVA_LISTA:		criarNovaLista();		break;
				case ABRIR_LISTA:			abrirUmaLista();		break;
				case DELETAR_UMA_LISTA:		deletarUmaLista();		break;
				case RENOMEAR_UMA_LISTA:	renomearUmaLista();		break;
				case SAIR:	sair();
			}
			
			if(op > 0 && op <= RENOMEAR_UMA_LISTA && op != IMPRIMIR_LISTA){
				System.out.println();
				imprimirLista();
				sc.nextLine();
			}
			
		} while(op != SAIR);
	}

	@Override
	public void inserirItem() {
		int i = lista.getSize();
		System.out.print("Digite o novo item:\n\t");
		lista.novoItem(sc.nextLine());
		if(i + 1 == lista.getSize())	System.out.println("Item inserido com sucesso!");
		else	System.out.println("Erro ao inserir item!");
	}
	
	@Override
	public void inserirItem(String nome) {
		lista.novoItem(nome);
	}

	@Override
	public void removerItem() {
		int i;
		do {
			System.out.println("Digite o indice do item que deseja remover: ");
			i = sc.nextInt();
			if(i == 0)	return;
			try{
				lista.removeItem(i);
				break;
			} catch (OutOfBounds e){
				System.out.println(e.getMessage());
				System.out.println("Tente novamente. . .");
			}
		} while(true);
	}
	
	@Override
	public void removerItem(int index) {
		try {
			lista.removeItem(index);
		} catch (OutOfBounds e){
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void reposicionarItem() {
		int de, para;
		
		do {
			System.out.println("Digite o indice do item que deseja reposicionar: ");
			de = sc.nextInt();
			System.out.println("Digite o indice para onde deseja reposicionar: ");
			para = sc.nextInt();
			if(de == para)	return;
			
			try {
				lista.reposiciona(de, para);
				break;
			} catch (OutOfBounds e){
				System.out.println(e.getMessage());
				System.out.println("Tente novamente. . .");
			}
		} while(true);
	}

	@Override
	public void reposicionarItem(int de, int para) {
		try {
			lista.reposiciona(de, para);
		} catch (OutOfBounds e){
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void marcarFeito() {
		int i;
		
		imprimirLista();
		
		do {
			System.out.println("Digite o indice do item feito: ");
			i = sc.nextInt();
			if(i == 0)	return;
			try {
				lista.getItem(i).setDone();
				break;
			} catch (OutOfBounds e) {
				System.out.println(e.getMessage());
				System.out.println("Tente novamente. . .");
			}
		} while(true);
	}

	@Override
	public void marcarFeito(int index) {
		try {
			lista.getItem(index).setDone();
		} catch (OutOfBounds e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void salvarLista() {
		do {
			System.out.println("Digite o nome da lista: ");
			lista.setNome(sc.nextLine());
			if(lista.getNome().equals(".."))	return;
			
			try{
				fm.overwriteLista(lista);
				break;
			} catch(FileException e){
				try{
					fm.salvarNovaLista(lista);
					break;
				}
				catch(FileException f){
					System.out.println(f.getMessage());
					System.out.println("Tente novamente. . .");
				}
			}
		} while(true);
	}

	@Override
	public void salvarLista(String nome) {
		lista.setNome(nome);
		try{
			fm.overwriteLista(lista);
		} catch(FileException e){
			try{
				fm.salvarNovaLista(lista);
			}
			catch(FileException f){
				System.out.println(f.getMessage());
			}
		}
	}

	@Override
	public void imprimirLista() {
		try{
			lista.printaLista();
		} catch(OutOfBounds e){
			System.out.println(e.getMessage());
		}
		System.out.println();
	}

	@Override
	public void criarNovaLista() {
		try {
			fm.criaListaDefault(lista);
		} catch (FileException e) {
			System.out.println(e.getMessage());
		}
		
		try{
			lista = new Lista();
			if(lista.getSize() != 0)	throw new FileException("ECN");
			System.out.println("Nova lista criada com sucesso!");
		} catch(FileException e){
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void abrirUmaLista() {
		do {
			System.out.println("Digite o nome da lista que deseja abrir: ");
			String nome = sc.nextLine();
			if(nome.equals(".."))	return;
			
			try {
				lista = fm.abrirLista(nome);
				if(lista == null)
					throw new FileException("EAL");
				break;
			} catch (FileException e) {
				System.out.println(e.getMessage());
				System.out.println("Tente novamente. . .");
			}
		} while(true);
	}

	@Override
	public void abrirUmaLista(String nome) {
		try {
			lista = fm.abrirLista(nome);
		} catch (FileException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void deletarUmaLista() {
		System.out.println("Deseja deletar esta lista ou outra lista ja salva?");
		System.out.println("[e] esta lista.");
		System.out.println("[else] outra lista.");
		
		if(sc.nextLine().equals("e")){
			lista = new Lista();
			return;
		}
		
		do {
			System.out.println("Digite o nome da lista que deseja deletar: ");
			String nome = sc.nextLine();
			if(nome.equals(".."))	return;
			
			try{
				fm.deletarLista(nome);
				break;
			} catch(FileException e){
				System.out.println(e.getMessage());
				System.out.println("Tente novamente. . .");
			}
		} while(true);
	}

	@Override
	public void deletarUmaLista(String nome) {
		try{
			fm.deletarLista(nome);
		} catch(FileException e){
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void renomearUmaLista() {;
		Lista temp = new Lista();
		String antes, depois;
		
		do {
			System.out.println("Digite o nome da lista que deseja renomear: ");
			antes = sc.nextLine();
			if(antes.equals(".."))	return;
		
			try {
				temp = fm.abrirLista(antes);
				break;
			} catch (FileException e) {
				System.out.println(e.getMessage());
				System.out.println("Tente novamente. . .");
			}
		} while(true);
		
		do {
			System.out.println("Digite o novo nome: ");
			depois = sc.nextLine();
			if(depois.equals(".."))	return;
			temp.setNome(depois);
			try {
				fm.salvarNovaLista(temp);
				break;
			} catch (FileException e) {
				System.out.println(e.getMessage());
			}
		} while(true);
		
		deletarUmaLista(antes);
	}

	@Override
	public void renomearUmaLista(String antes, String depois) {
		Lista temp = new Lista();
		
		try {
			temp = fm.abrirLista(antes);
		} catch (FileException e) {
			System.out.println(e.getMessage());
			return;	//solicitar novo nome
		}
		temp.setNome(depois);
		try {
			fm.salvarNovaLista(temp);
		} catch (FileException e) {
			System.out.println(e.getMessage());
		}
		
		deletarUmaLista(antes);
	}
	
	@Override
	public void sair() {
		try {
			fm.criaListaDefault(lista);
		} catch (FileException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Escolha como deseja sair: ");
		System.out.println("[s] Salvar lista atual e sair.");
		if(fm.listaExiste(lista.getNome()))
			System.out.println("[o] Sobrescrever lista atual e sair.");
		System.out.println("[else] Descartar lista atual e sair.");
		
		switch(sc.nextLine()){
			case "s":
				salvarLista();
				break;
			case "o":
				if(fm.listaExiste(lista.getNome()))
					try {
						//Aqui o arquivo já existe
						fm.overwriteLista(lista);
					} catch (FileException f) {
						//Esse catch é obsoleto.
					}
			default:
				break;
		}
		
		System.out.println("Saindo. . .\n");
	}

	@Override
	public int checaOpcoes(String opcao){
		if(opcao.equals("1")){
			return INSERIR_ITEM;
		}
		else if(opcao.equals("2")){
			return REMOVER_ITEM;
		}
		else if(opcao.equals("3")){
			return REPOSICIONAR_ITEM;
		}
		else if(opcao.equals("4")){
			return MARCAR_FEITO;
		}
		else if(opcao.equals("5")){
			return SALVAR_LISTA;
		}
		else if(opcao.equals("6")){
			return IMPRIMIR_LISTA;
		}
		else if(opcao.equals("7")){
			return CRIAR_NOVA_LISTA;
		}
		else if(opcao.equals("8")){
			return ABRIR_LISTA;
		}
		else if(opcao.equals("9")){
			return DELETAR_UMA_LISTA;
		}
		else if(opcao.equals("10")){
			return RENOMEAR_UMA_LISTA;
		}
		else if(opcao.equals("0")){
			return SAIR;
		}
		else return OPCAO_INVALIDA;
	}
}
