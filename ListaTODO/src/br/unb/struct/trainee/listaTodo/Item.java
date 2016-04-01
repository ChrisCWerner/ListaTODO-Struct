package br.unb.struct.trainee.listaTodo;

public class Item {

	protected String item;
	protected boolean done;
	
	public Item(){
		setItemString("Novo item");
		this.done = false;
	}
	
	public Item(String item){
		this();
		this.setItemString(item);
	}
	
	public String getItemString() {
		return item;
	}

	private void setItemString(String item) {
		this.item = item;
	}
	
	public boolean isDone(){
		return done;
	}
	
	protected void setDone(){
		done = true;
	}
	
//	private void setDone(boolean done){
//		this.setDone();
//		this.done = done;
//	}
}
