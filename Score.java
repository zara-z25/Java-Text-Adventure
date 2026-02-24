package org.uob.a1;

public class Score {
  
    private int startingScore;
    private int currentScore = 0;
    private int roomsVisited = 1;
    private int puzzleSolved;
    private final int PUZZLE_VALUE = 10;

    public Score(int startingScore){
        this.startingScore = startingScore;
        this.currentScore += startingScore;
    }
    
    public void visitRoom(){
        this.currentScore -= roomsVisited;
    }

    public void solvePuzzle(){
        this.currentScore += PUZZLE_VALUE;
    }
    
    public double getScore(){
        return currentScore;
    }
    
    
    
        
}