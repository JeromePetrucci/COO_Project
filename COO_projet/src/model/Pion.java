package model;

public class Pion extends AbstractPiece{
	public Pion () {
		super();
	}
	
	public Pion (Couleur couleur,Coord coord) {
		super(couleur,coord);
	}
	
	@Override
	public boolean movePossible(int x, int y) {
		boolean move = false;
		if (Coord.coordonnees_valides(x, y) == true)
			if ((x-coordPiece.x)==1 && coordPiece.y==y)//avance de 1 seulement
				move = true;
		return move;
	}
}
