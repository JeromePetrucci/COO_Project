package model;

/**
 * @author jerome.petrucci
 * 
 * Cette interface définit le comportement attendu 
 * de toutes les pieces
 *
 */



public interface Pieces {
	
	
	public Coord getCoord();
	
	public Couleur getCouleur();
	
	public boolean movePossible(int x,int y);
	
	public void movePiece(int x, int y);
}
