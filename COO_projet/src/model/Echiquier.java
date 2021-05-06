package model;

import java.util.List;

public class Echiquier {
	
	public Jeu JeuN;//Jeu noir
	public Jeu JeuB;// Jeu Blanc 
	public Jeu JeuCourant;// Jeu du joueur qui doit jouer
	public String message;//
	
	Echiquier (){
		JeuN = new Jeu(Couleur.NOIR);
		JeuB = new Jeu(Couleur.BLANC);
		JeuCourant = JeuB;
		message = null;
	}
	
	//getter message
	public String getMessage () {
		return this.message;
	}
	
	private void setMessage(String message) {
		this.message=message;
	}
	
	//Change le jeu courant 
	public void switchJoueur() {
		if (JeuCourant == JeuB){
			JeuCourant = JeuN;
		}
		else {
			JeuCourant = JeuB;
		}
	}
	
	public boolean isMoveOk(int xPiece,int yPiece, int xArrive,int yArrive) {
		boolean ret = false;
		if (xPiece != xArrive || yPiece != yArrive) {
			ret = JeuCourant.moveOk(xPiece,yPiece,xArrive,yArrive);
		}
		return ret;
	}
	
	public boolean move(int xPiece,int yPiece, int xArrive,int yArrive) {
		boolean ret=false;
		if (isMoveOk(xPiece,yPiece, xArrive,yArrive) == true) {
			message = "déplacement OK";
			JeuCourant.movement( xPiece, yPiece,  xArrive, yArrive);
			ret=true;
		}
		return ret;
	}
	
	
	public List<PieceIHM> getPiecesIHM() {
		List<PieceIHM> list = JeuB.getPiecesIHM();
		list.addAll(JeuN.getPiecesIHM());
		return list;
	}
	
	
	
	@Override
	public String toString() {
		System.out.println("Sur l'échiquier il y a :");
		System.out.println(JeuB);//invocation de toString des Jeux
		System.out.println(JeuN);
		return "En cours de jeu";//à modifier 
	}
	
	public static void main(String[] args) {
		Echiquier E = new Echiquier();
		
		System.out.println(E.move(0,7,1,7));
	}
	
}
