/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

/**
 *
 * @author Leya
 */
public class Node {
    private Node parent;
    private Position position;
    
    private int g;
    private int h;
    private int f;

    public Node(Node parent, Position position){
        this.parent = parent;
        this.position = position;
        
        this.g = 0;
        this.h = 0;
        this.f = 0;
        
    }

    public void setPosition(Position newPosition){
        this.position = newPosition;
    }
    
    public int getG(){
        return this.g;
    }
    
    public int getH(){
        return this.h;
    }
    
    public int getF(){
        return this.f;
    }
    
    public void setG(int newG){
       this.g = newG; 
    }

    public void setH(int newH){
       this.h = newH; 
    }
    
    public void setF(int newF){
       this.f = newF; 
    }

    public Position getPosition() {
       return this.position;
    }

    public Node getParent() {
        return this.parent;
    }
    
    public void setParent(Node new_parent){
        this.parent = new_parent;
    }
    
}