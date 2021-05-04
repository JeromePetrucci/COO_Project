package model;



public abstract class AbstractPiece implements Pieces {
	
	public Coord coordPiece;
	public Couleur couleur;
	
	public AbstractPiece() {
		coordPiece =  new Coord(5, 0);
		couleur = Couleur.NOIR;	
	}
	
	public AbstractPiece(Couleur couleur,Coord c) {
		this.coordPiece = c;
		this.couleur = couleur;
	}
	
	protected void setCoord (int x, int y) {
		if (Coord.coordonnees_valides(x, y) == true)
			coordPiece = new Coord (x,y);
	}
	
	public Coord getCoord() {
		return coordPiece;
	}
	
	public int getCoordx() {
		return coordPiece.x;
	}
	
	public int getCoordy() {
		return coordPiece.y;
	}

	
	public Couleur getCouleur() {
		return couleur;
	}
	
	public boolean movePossible(int x,int y) {
		return true;
	}
	
	public void movePiece(int x, int y) {
		if (movePossible(x,y) == true) 
			setCoord(x,y);
			
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " : " + getCoord() + ", " + getCouleur();
	}
	
	public static void main(String args[]) {
		Pieces maTour = new Tour(Couleur.NOIR, new Coord(0, 0));
		System.out.println(maTour);
		Pieces Cav = new Pion(Couleur.BLANC, new Coord(1,2));
		System.out.println(Cav);
		Cav.movePiece(1,3);
		System.out.println(Cav);
		Cav.movePiece(2, 2);
		System.out.println(Cav);
		
	}
}




