package ai;

import java.util.ArrayList;

/**
 *
 * @author Lea
 */
public class Astar {
    
    public ArrayList<Position> getPath(State state, Position start, Position end){

        Node start_node = new Node(null, start);   //on fait un noeud avec la position de depart "la boîte"
        Node end_node   = new Node(null, end);    // on fait un noeud avec la position du fin "le but"

        ArrayList<Node> open_list = new ArrayList<>();
        ArrayList<Node> closed_list = new ArrayList<>();

        open_list.add(start_node);

        while (open_list.size() > 0){

            Node current_node = open_list.get(0);
            int current_index = 0;
            for(Node node: open_list){
                if (node.getF() < current_node.getF()){ // on verifie si le chemin est mieux pour "node"
                    current_node = node;
                    current_index = open_list.indexOf(node);
                }
            }
    
            open_list.remove(current_index);
            closed_list.add(current_node);

            if (current_node == end_node){  // on verifie si on est arrive a la fin
                ArrayList<Position> path = new ArrayList<>();
                Node current = current_node;
                while (current != null){ // tant que on est pas arrive au depart
                    path.add(current.getPosition());
                    current = current.getParent();
                }
                return reverse(path);// on retourne la liste avec les noeuds qui tracent le chemin 
            }
            
            ArrayList<Node> children = new ArrayList<>();
            //on met dans un ArrayList tous les enfants du currentNode égal aux champs adjacents (en bas, a gauche, a droite, en haut)
            ArrayList<Position> neighbours = new ArrayList<>();
            neighbours.add(new Position(current_node.getPosition().getX()+1,current_node.getPosition().getY()));
            neighbours.add(new Position(current_node.getPosition().getX()-1,current_node.getPosition().getY()));
            neighbours.add(new Position(current_node.getPosition().getX(),current_node.getPosition().getY()+1));
            neighbours.add(new Position(current_node.getPosition().getX(),current_node.getPosition().getY()-1));
            
            for(Position new_position: neighbours){
                if (state.play(current_node.getPosition(),new_position)){//on verifie si la position de mouvement dans la cas est valid
                    Node new_node = new Node(current_node, new_position);
                    children.add(new_node);                         //on ajoute dans un ArrayList tous les enfants(cas suivant) possible de noeud actuel
                }
            for(Node child: children){ 
                if(closed_list.contains(child)){ //on a deja ete sur ce noeud
                    continue; // on ne l'evaluer pas
                }
                for(Node open_node: open_list){ 
                    if (open_node.getPosition() == child.getPosition()){// on verifie si on evalue deux fois le meme noeud 
                        if(child.getG() <= open_node.getG()){ //on verifie si le noeud "child" a un chemin mieux       
                            continue;
                        }
                    }else{
                        open_list.add(child); //sinon on ajoute noued enfant dans open_list pour l'evaluer
                    }
                }
                
                // on calcule les parametres g,h du noeud qui suit pour obtenir f
                
                child.setG(current_node.getG() + 1); //chaque noeud qui suit est un cas plus loin du debut
                
                child.setH((int) (Math.abs(child.getPosition().getX() - end_node.getPosition().getX()) + Math.abs(child.getPosition().getY() - end_node.getPosition().getY())));
                // le joueur ne peut se déplacer qu’en ligne horizontale (gauche droite) et verticale (gauche droite)
                // donc l’équation calcule les mouvements minimums qu’il peut effectuer pour atteindre la fin 
                
                child.setF(child.getG() + child.getH());
            }
           }
        }
      return null; //s'il n'existe pas un chemin
    }
    
    public ArrayList<Position> playAI(State state){
        Position start = null;
        Position end = null;
        for(int i = 0; i <= state.getSize()[0]; i++){ //on cherche la position final
            for(int j = 0; j <= state.getSize()[1]; j++){
                if(state.getMatrix()[i][j].equals(State.GOAL)){// CHECK
                    end = new Position(i,j); //on prend la première position du but
                    break;
                }
            }
        }
        
        start = state.getPositionGoal(); //on prend la position du depart de la boite 
        
        ArrayList<Position> pathBox =  getPath(state, start, end);
        ArrayList<Position> pathPlayer = null;
        
        Position position_player = state.getPositionPlayer();
        
        //on veut trouver la direction dans laquelle la boîte ira afin que nous puissions positionner notre joueur là 
        if(pathBox.get(0).getX() > start.getX()){ // premier deplacement pour la boite est a droite
            pathPlayer =  getPath(state, position_player, new Position(start.getX()-1, start.getY()));
        }else if(pathBox.get(0).getX() < start.getX()){ // premier deplacement pour la boite est a gauche
            pathPlayer =  getPath(state, position_player, new Position(start.getX()+1, start.getY()));
        }else if(pathBox.get(0).getY() > start.getY()){ // premier deplacement pour la boite est a en bas
            pathPlayer =  getPath(state, position_player, new Position(start.getX(), start.getY()-1));
        }else if(pathBox.get(0).getY() < start.getY()){ // premier deplacement pour la boite est a en haut
            pathPlayer =  getPath(state, position_player, new Position(start.getX(), start.getY()+1));
        }
        
        pathBox.remove(pathBox.size());
        ArrayList<Position> fullPath = mergeLists(pathPlayer, pathBox);
        return fullPath;
    }
    
    
    public ArrayList<Position> reverse(ArrayList<Position> list){ // la méthode inverse une liste
        ArrayList<Position> newList = new ArrayList<>();
        for(int i = list.size()-1; i>=0; i--){
            newList.add(list.get(i));
        }
        return newList;
    }
    
    public ArrayList<Position> mergeLists(ArrayList<Position> list1, ArrayList<Position> list2){ // la méthode fusionne deux listes
        ArrayList<Position> list = new ArrayList<>();
        for(int i = 0; i < list1.size(); i++){
            list.add(list1.get(i));
        }
        for(int j = 0; j < list2.size(); j++){
            list.add(list2.get(j));
        }
        return list;
    }

}

