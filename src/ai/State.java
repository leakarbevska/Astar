/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

/**
 *
 * @author Lea
 */
class State {
    
    private String[][] matrix;
    private int[] size = new int[2];
    private Position positionPlayer;
    private Position positionGoal;
    private Position positionBox;
    
    public static final String PLAYER = "@";
    public static final String GOAL   = "X";
    public static final String EMPTY  = "_";
    public static final String BOX    = "#";
    
    State(int n, int m, Position positionPlayer, Position positionGoal) {
        int[] t = {n,m};
        this.size = t;
        this.positionGoal   = positionGoal;
        this.positionPlayer = positionPlayer;
        initializeMatrix();
    }

    public String[][] getMatrix() {
        return matrix;
    }

    public int[] getSize() {
        return size;
    }

    public Position getPositionPlayer() {
        return positionPlayer;
    }

    public Position getPositionGoal() {
        return positionGoal;
    }
    
    public void initializeMatrix(){
        for(int i=0; i<this.size[0]; i++){
            for(int j=0; j<this.size[1]; j++){
               if(new Position(i,j) == this.positionGoal){
                   this.matrix[i][j] = State.GOAL;
               }else if(new Position(i,j) == this.positionPlayer){
                   this.matrix[i][j] = State.PLAYER;
               }else if(new Position(i,j) == this.positionBox){
                   this.matrix[i][j] = State.BOX;
               }else{
                   this.matrix[i][j] = "_";
               }
            }
        }
    }
    
    public boolean play(Position position, Position new_position) {
        if(new_position.getX()<this.size[0] && new_position.getY()<this.size[1]){
            this.matrix[position.getX()][position.getY()] = State.EMPTY;
            if(this.matrix[new_position.getX()][new_position.getY()].equals(State.EMPTY)){
                this.matrix[new_position.getX()][new_position.getY()] = State.PLAYER;
            }else{
                if(this.matrix[new_position.getX()][new_position.getY()].equals(State.BOX)){
                    //if(new_position.getX()<this.size[0] && new_position.getY()<this.size[1])
                }
            }
            this.positionPlayer = new_position;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString(){
       StringBuilder sc = new StringBuilder();
       for(int i=0; i<this.size[0]; i++){
           for(int j=0; j<this.size[1]; i++){
               sc.append(this.matrix[i][j]);
               sc.append("|");
           } 
           sc.append("\n");
       }
       return sc.toString();
    }
    
}
