import java.io.*;
import java.util.*;

class MatchData {
  private int runs;
  private int wickets;
  private float overs;
  
  public void setRuns(int runs) {
    this.runs = runs; 
  }  
  
  public void setWickets(int wickets) {
    this.wickets = wickets; 
  }  
  
  public void setOvers(float overs) {
    this.overs = overs; 
  }  
  
  public int getRuns() {
     return this.runs;
  }
   
  public int getWickets() {
    return this.wickets;
  }  
  
  public float getOvers() {
    return this.overs; 
  }  
}  

interface Observer {
  public void update(MatchData data);
}  


interface Subject { 
   public void subscribeObserver(Observer o);
   public void unSubscribeObserver(Observer o);
   public void notifyObservers();
} 


class CricketData implements Subject {

    private MatchData data;
    public List<Observer> observers;
  
    CricketData() {
       observers = new ArrayList<>();
       data = new MatchData();
    }  
    
    private int getRuns() {
       return 300;
    }

    private int getWickets() {
      return 2;
    }  

    private float getOvers() {
      return (float) 45.4; 
    }  
  
    public void dataChanged() {
        data.setRuns(getRuns());
        data.setWickets(getWickets());
        data.setOvers(getOvers());
        notifyObservers();
    }  
  
    @Override
    public void subscribeObserver(Observer o) {
      observers.add(o);
    }  
  
   @Override
   public void unSubscribeObserver(Observer o) {
     observers.remove(o);
   }  
   
   @Override
   public void notifyObservers() {
      for(Observer o : observers)
        o.update(data);
   }  
  
}  


class CurrentScoreDisplay implements Observer {
  
  private MatchData data;
  
  @Override
  public void update(MatchData data) {
    this.data = data;
    display();
  }
  
  public void display() {
    System.out.println("Runs: " + data.getRuns() + 
                       ", Wickets: " + data.getWickets() + 
                       ", Overs: " + data.getOvers()); 
  }
  
} 

class AverageScoreDisplay implements Observer {
  private float runRate;
  private int predictedScore;
  
  @Override
  public void update(MatchData data) {
    this.runRate = data.getRuns()/data.getOvers();
    this.predictedScore = (int) (this.runRate * data.getOvers());
    display();
  }
  
  public void display() {
    System.out.println("Run rate: " + runRate + ", Predicted Score: " + predictedScore);
  }
}  

class Solution {
  public static void main(String[] args) {
       CricketData cricketData = new CricketData();
       CurrentScoreDisplay csd = new CurrentScoreDisplay();
       AverageScoreDisplay asd = new AverageScoreDisplay();
       cricketData.subscribeObserver(csd);
       cricketData.subscribeObserver(asd);
       cricketData.dataChanged();  
      
       cricketData.unSubscribeObserver(asd);
       cricketData.dataChanged(); 
  }
}
