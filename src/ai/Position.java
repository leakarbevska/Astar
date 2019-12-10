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
public class Position {
    private int x;
    private int y;

    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }

    public void changePosition(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }


    @Override
    public String toString() {
        return this.x + "; " + this.y;
    }

    @Override
    public boolean equals(Object o) {
        boolean isPosition = (o instanceof Position);
        boolean sameX = ((Position)o).getX() == this.getX();
        boolean sameY = ((Position)o).getY() == this.getY();

        return isPosition && sameX && sameY;
    }

    @Override
    public int hashCode() {
        return this.x*10 + this.y;
    }    
    
}
