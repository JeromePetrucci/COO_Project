package model;

public class Roi extends AbstractPiece{

	public Roi () {
		super();
	}
	
	public Roi (Couleur couleur,Coord coord) {
		super(couleur,coord);
	}
	
	@Override
	public boolean movePossible(int x, int y) {
		boolean move = false;
		if (Coord.coordonnees_valides(x, y) == true)
			if (Math.abs(coordPiece.x-x)==1 || Math.abs(coordPiece.y-y)==1)
				move = true;
		return move;
	}
}

