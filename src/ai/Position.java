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
public class Position {
    private int x;
    private int y;
    
    /**
     * Construit l'instance d'une position.
     * @param x La position sur l'axe des abscisses.
     * @param y La position sur l'axe des ordonnÃ©es.
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * RÃ©cupere la position sur l'axe des abscisses.
     * @return la position horizontale.
     */
    public int getX() {
        return this.x;
    }
    
    /**
     * RÃ©cupere la position sur l'axe des ordonnÃ©es.
     * @return la position verticale.
     */
    public int getY() {
        return this.y;
    }
    
    /**
     * DÃ©fini d'autres coordonnÃ©es pour la position.
     * @param newX la position sur l'axe des abscisses.
     * @param newY la position sur l'axe des ordonnÃ©es.
     */
    public void changePosition(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    /**
     * Effectue une translation de la position.
     * @param x La valeur en abscisses du vecteur directeur.
     * @param y La valeur en ordonnÃ©es du vecteur directeur.
     */
    public void movePosition(int x, int y) {
        this.x += x;
        this.y += y;
    }

    /**
     * RÃ©cupere un instance de position resultant d'une translation sur la position donnÃ©e.
     * @param position l'instance de position rÃ©fÃ©rence.
     * @param x La valeur en abscisses du vecteur directeur.
     * @param y La valeur en ordonnÃ©es du vecteur directeur.
     * @return Une instance de position.
     */
    public static Position relativePosition(Position position, int x, int y) {
        return new Position(position.getX()+x, position.getY()+y);
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
