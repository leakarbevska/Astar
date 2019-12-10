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
    
    public static final String PLAYER = "@";
    public static final String GOAL   = "X";
    public static final String EMPTY  = "_";
    
    State(int n, int m, Position positionPlayer, Position positionGoal) {
        int[] t = {n,m};
        this.size = t;
        // initial
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
               if(new Position(i,j) == this.positionGoal){
                   this.matrix[i][j] = State.GOAL;
               }else if(new Position(i,j) == this.positionPlayer){
                   this.matrix[i][j] = State.PLAYER;
               }else{
                   this.matrix[i][j] = "_";
               }
            }
        }
        
        this.positionGoal   = positionGoal;
        this.positionPlayer = positionPlayer;
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
    
    public boolean play(Position position, Position new_position) {
        if(new_position.getX()<this.size[0] && new_position.getY()<this.size[1]){
            this.matrix[position.getX()][position.getY()] = State.EMPTY;
            this.matrix[new_position.getX()][new_position.getY()] = State.PLAYER;
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
