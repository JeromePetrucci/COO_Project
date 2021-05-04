package model;

public class Reine extends AbstractPiece{

	public Reine () {
		super();
	}
	
	public Reine (Couleur couleur,Coord coord) {
		super(couleur,coord);
	}
	
	@Override
	public boolean movePossible(int x, int y) {
		boolean move = false;
		if (Coord.coordonnees_valides(x, y) == true)
			if ((Math.abs(coordPiece.x-x) == Math.abs (coordPiece.y-y)) || coordPiece.x == x || coordPiece.y== y)
				move = true;
		return move;
	}
}
