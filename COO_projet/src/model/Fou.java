package model;

public class Fou extends AbstractPiece{

	public Fou () {
		super();
	}
	
	public Fou (Couleur couleur,Coord coord) {
		super(couleur,coord);
	}
	
	@Override
	public boolean movePossible(int x, int y) {
		boolean move = false;
		if (Coord.coordonnees_valides(x, y) == true)
			if (Math.abs(coordPiece.x-x) == Math.abs (coordPiece.y-y))
				move = true;
		return move;
	}
}
