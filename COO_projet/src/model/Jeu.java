package model;

import java.util.LinkedList;
import java.util.List;

import tools.ChessPiecesFactory;

public class Jeu {
	public List<Pieces> pieces;
	public Couleur couleur;
	
	public Jeu (Couleur pieceCouleur) {//Cr�e le jeu d'un joueur
		this.pieces = ChessPiecesFactory.newPieces(pieceCouleur);
		this.couleur = pieceCouleur;
	}
	
	
	
	//trouve une pi�ce � une coordonn�e donn�e.
	private Pieces findPiece(int x, int y) {
		Pieces ret = null;
		for (int i = 0; i < pieces.size(); i++) {
			Pieces Var = pieces.get(i);
			
			if ((Var.getCoordx() == x) && (Var.getCoordy() == y)){
				ret = Var;
			}	
		}
		return ret;
	}
	
	public boolean moveOk(int xPiece,int yPiece, int xArrive,int yArrive) {
		boolean ret = false;
		Pieces P = findPiece(xPiece,yPiece);
		if (P != null) {
			ret = P.movePossible(xArrive, yArrive);
		}
		return ret;
	}
	
	public void movement(int xPiece,int yPiece, int xArrive,int yArrive) {
		Pieces P = findPiece(xPiece,yPiece);
		P.movePiece(xArrive, yArrive);
	}
	
	/**
	* @return une vue de la liste des pi�ces en cours
	* ne donnant que des acc�s en lecture sur des PieceIHM
	* (type piece + couleur + liste de coordonn�es)
	*/
	public List<PieceIHM> getPiecesIHM(){
		PieceIHM newPieceIHM = null;
		List<PieceIHM> list = new LinkedList<PieceIHM>();
		for (Pieces piece : pieces){
			boolean existe = false;
			// si le type de piece existe d�j� dans la liste de PieceIHM
			// ajout des coordonn�es de la pi�ce dans la liste de Coord de ce type
			// si elle est toujours en jeu (x et y != -1)
			for ( PieceIHM pieceIHM : list){
					if ((pieceIHM.getTypePiece()).equals(piece.getClass().getSimpleName())){
							existe = true;
							if (piece.getCoordx() != -1){
								pieceIHM.add(new Coord(piece.getCoordx(), piece.getCoordy()));
							}
					}
			}
			// sinon, cr�ation d'une nouvelle PieceIHM si la pi�ce est toujours en jeu
			if (! existe) {
				if (piece.getCoordx() != -1){
					newPieceIHM = new PieceIHM(piece.getClass().getSimpleName(),
							piece.getCouleur());
					newPieceIHM.add(new Coord(piece.getCoordx(), piece.getCoordy()));
					list.add(newPieceIHM);
				}
			}
		}
		return list;
	}
	
	
	@Override
	public String toString() {
		return pieces.toString();
	}
	
	public static void main(String[] args) {
		Jeu A = new Jeu(Couleur.BLANC);
		System.out.println(A.getPiecesIHM());
		
	}
}
