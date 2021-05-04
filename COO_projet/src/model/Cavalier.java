package model;

public class Cavalier extends AbstractPiece{
	public Cavalier () {
		super();
	}
	
	public Cavalier (Couleur couleur,Coord coord) {
		super(couleur,coord);
	}
	
	@Override
	public boolean movePossible(int x, int y) {
		boolean move = false;
		if (Coord.coordonnees_valides(x, y) == true)
			if ((Math.abs(coordPiece.x-x)==2 && Math.abs(coordPiece.y-y)==1) || (Math.abs(coordPiece.x-x)==1 && Math.abs(coordPiece.y-y)==2) )
				move = true;
		return move;
	}
}
