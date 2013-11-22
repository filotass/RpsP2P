package main;


import gui.MainForm;
import java.util.concurrent.Executors;

import gui.StartForm;
import gui.Utils;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import network.Server;

public class Main {

	private String username;
        private Server server;
        private MainForm mainForm;
	//private  ExecutorService executor = Executors.newFixedThreadPool(5);
        private ScheduledExecutorService scheduler =  Executors.newScheduledThreadPool(10);
	
	public static void main(String[] args){
                final Main main = new Main();
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        StartForm st = new StartForm(main);
                        Utils.centralize(st);
                        st.setVisible(true);
                    }
                });
        }
		
               
	
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public  String getUsername(){
		return this.username;
	}
        
        public void setServer(Server server){
            this.server = server;
	}
	
	public  Server getServer(){
	return this.server;
	}
	
	public void schedule(Runnable runnable){
		try{
                    scheduler.schedule(runnable,0, TimeUnit.SECONDS);
		}catch(Exception e){
                    e.printStackTrace();
                }
	}
        
        public void schedule(Runnable runnable, int delayInSeconds){
		try{
                    scheduler.scheduleWithFixedDelay(runnable, 1, delayInSeconds, TimeUnit.SECONDS);
		}catch(Exception e){
                    e.printStackTrace();
                }
	}

    public void setMainForm(MainForm mainForm) {
       this.mainForm = mainForm;
    }
    public MainForm getMainForm() {
        return this.mainForm;
    }
        
        

}
