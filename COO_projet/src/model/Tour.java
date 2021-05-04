package model;


public class Tour extends AbstractPiece {
	
	
	
	public Tour () {
		super();
	}
	
	public Tour (Couleur couleur,Coord coord) {
		super(couleur,coord);
	}
	
	@Override
	public boolean movePossible(int x, int y) {
		boolean move = false;
		if (Coord.coordonnees_valides(x, y) == true)
			if (coordPiece.x == x || coordPiece.y== y)
				move = true;
		return move;
	}
	
	
}
