package br.unb.struct.trainee.listaTodo;

@SuppressWarnings("serial")
public class FileException extends Exception {

	private String caso;
	
	public FileException(){
		caso = "";
	}
	
	public FileException(String caso){
		this.caso = caso; 
	}

	public String getCaso(){
		return caso;
	}
	
	@Override
	public String getMessage(){
		switch(caso){
		
			//AJE Arquivo Já Existe:
			case "LJE":		return "Ja existe uma lista com esse nome! Tente novamente.";
			
			//LLA Limite de Listas default Alcançado:
			case "LLA":		return "Limite de listas com nome padrao atingido!\n" +
								"Procure salvar a lista atual e renomear/deletar algumas listas.";
			
			//ECN Erro ao Criar Nova lista:
			case "ECN":		return "Erro ao criar nova lista!";
			
			//EAL Erro ao abrir lista:
			case "EAL":		return "Erro ao abrir lista!";
			
			//LNE Lista Nao Existe:
			case "LNE":		
			
			default:		return "Arquivo nao encontrado!";
		}
	}
}
