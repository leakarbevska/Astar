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
 * @author Lea
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
        
        System.out.println("Give the position of the goal");
        int x_goal = sc.nextInt();
        int y_goal = sc.nextInt();
        Position position_goal = new Position(x_goal, y_goal);
        
        checkValid(n, m, x_player, y_player, x_goal, y_goal);
        State state = new State(n, m, position_player, position_goal);
    }
    
    
    public static void checkValid(int n, int m, int x_player, int y_player, int x_goal, int y_goal){
        if(x_player >= n || y_player >= m){
            System.out.print("Player position invalid");
            exit(0);
        }
        if(x_goal >= n || y_goal >= m){
            System.out.print("Goal position invalid");
            exit(0);
        }
    }
    
}
