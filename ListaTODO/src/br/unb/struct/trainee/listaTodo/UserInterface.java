package br.unb.struct.trainee.listaTodo;

public interface UserInterface {

	public void opcoes();
	public int checaOpcoes(String opcao);

	public void inserirItem();
	public void inserirItem(String nome);
	
	public void removerItem();
	public void removerItem(int index);

	public void reposicionarItem();
	public void reposicionarItem(int de, int para);

	public void marcarFeito();
	public void marcarFeito(int index);

	public void salvarLista();
	public void salvarLista(String nome);
	
	public void imprimirLista();
	public void criarNovaLista();
	
	public void abrirUmaLista();
	public void abrirUmaLista(String nome);
	
	public void deletarUmaLista();	// TODO
	public void deletarUmaLista(String nome);
	
	public void renomearUmaLista();
	public void renomearUmaLista(String antes, String depois);	// TODO
	
	public void sair();
}
