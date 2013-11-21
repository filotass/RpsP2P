/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author FFF
 */
public class Peer {
    
    private String name;
    private int totalPoints;
    private int prevRoundPoints;
    private String prev_choice;
    private String accepted;
            
    public Peer(String name){
        this.name = name;
        this.totalPoints =0;
        this.prevRoundPoints = 0;
        this.prev_choice = "-";
        this.accepted = "ACCEPTANCE AWAITING";
    }
    public String getName() {
        return name;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public int getPrevRoundPoints() {
        return prevRoundPoints;
    }

    public String getPrev_choice() {
        return prev_choice;
    }

    public String isAccepted() {
        return accepted;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void setPrevRoundPoints(int prevRoundPoints) {
        this.prevRoundPoints = prevRoundPoints;
    }

    public void setPrev_choice(String prev_choice) {
        this.prev_choice = prev_choice;
    }

    public void setAccepted(String accepted) {
        this.accepted = accepted;
    }
    
    
    
    
   
}
