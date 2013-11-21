package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import gui.StartForm;
import gui.Utils;

public class Main {

	private String username;
	private ExecutorService executor = Executors.newFixedThreadPool(5);
	
	public static void main(String[] args) {
		StartForm st = new StartForm();
                Utils.centralize(st);
                st.setVisible(true);
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public  String getUsername(){
		return this.username;
	}
	
	public void execute(Runnable runnable){
		try{
			executor.execute(runnable);
		}catch(Exception e){}
	}

}
