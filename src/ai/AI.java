/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import static java.lang.System.exit;
import java.util.Scanner;

/**
 * 
 * @author lea
 */
public class AI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Give the size of the matrix");
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        System.out.println("Give the position of the player");
        int x_player = sc.nextInt();
        int y_player = sc.nextInt();
        Position position_player = new Position(x_player, y_player);
        
        System.out.println("Give the position of the box");
        int x_box = sc.nextInt();
        int y_box = sc.nextInt();
        Position position_box = new Position(x_box, y_box);
        
        System.out.println("Give the position of the goal");
        int x_goal = sc.nextInt();
        int y_goal = sc.nextInt();
        Position position_goal = new Position(x_goal, y_goal);
        
        checkValidPosition(n, m, position_player);
        checkValidPosition(n, m, position_box);
        checkValidPosition(n, m, position_goal);
        State state = new State(n, m, position_player, position_goal);
    }
    
    
    public static void checkValidPosition(int n, int m, Position pos){
        if( pos.getX() >= n || pos.getY() >= m){
            System.out.print("Position "+pos.toString()+" invalid");
            exit(0);
        }
    }
    
}
