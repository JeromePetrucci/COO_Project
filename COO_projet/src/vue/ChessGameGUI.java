package vue;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

import model.Coord;
import model.Couleur;
import model.Echiquier;
import model.Jeu;
import model.PieceIHM;
import tools.ChessImageProvider;

public class ChessGameGUI extends JFrame implements MouseListener, MouseMotionListener {
	JLayeredPane layeredPane;
	JPanel chessBoard;
	JLabel chessPiece;
	int xAdjustment;
	int yAdjustment;
	
	int xinit;
	int yinit;
	
	public ChessGameGUI() {
		Dimension boardSize = new Dimension(600, 600);

		// Use a Layered Pane for this this application
		layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane);
		layeredPane.setPreferredSize(boardSize);
		layeredPane.addMouseListener(this);
		layeredPane.addMouseMotionListener(this);

		// Add a chess board to the Layered Pane

		chessBoard = new JPanel();
		layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
		chessBoard.setLayout(new GridLayout(8, 8));
		chessBoard.setPreferredSize(boardSize);
		chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);

		for (int i = 0; i < 64; i++) {
			JPanel square = new JPanel(new BorderLayout());
			chessBoard.add(square);

			int row = (i / 8) % 2;
			if (row == 0)
				square.setBackground(i % 2 == 0 ? Color.black : Color.white);
			else
				square.setBackground(i % 2 == 0 ? Color.white : Color.black);
		}

		Echiquier E = new Echiquier();

		// Jeu B = new Jeu(Couleur.BLANC);
		// Jeu N = new Jeu(Couleur.NOIR);

		Iterator<PieceIHM> pieceIterator = E.getPiecesIHM().iterator();
		while (pieceIterator.hasNext()) {
			PieceIHM pieceTemp = pieceIterator.next();
			String typePiece = pieceTemp.type;
			Couleur couleurPiece = pieceTemp.couleur;
			List<Coord> list = pieceTemp.list;

			Iterator<Coord> pos = list.iterator();
			while (pos.hasNext()) {
				Coord val = pos.next();
				int nb;
				nb = val.x + val.y * 8;
				JLabel piece = new JLabel(new ImageIcon(ChessImageProvider.getImageFile(typePiece, couleurPiece)));
				JPanel panel = (JPanel) chessBoard.getComponent(nb);
				panel.add(piece);
			}
		}

		// Creation of the pieces

	}

	public void mousePressed(MouseEvent e) {
		
		int i = 0;
		
		chessPiece = null;
		Component c = chessBoard.findComponentAt(e.getX(), e.getY());

		if (c instanceof JPanel)
			return;
		
		for (Component Cmp : chessBoard.getComponents()) {

			if (c == Cmp) {
				xinit = i / 8;
				yinit = i % 8;
			}

			i++;
		}

		Point parentLocation = c.getParent().getLocation();
		xAdjustment = parentLocation.x - e.getX();
		yAdjustment = parentLocation.y - e.getY();
		chessPiece = (JLabel) c;
		chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
		chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
		layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
	}

	// Move the chess piece around

	public void mouseDragged(MouseEvent me) {
		if (chessPiece == null)
			return;
		chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
	}

	// Drop the chess piece back onto the chess board

	public void mouseReleased(MouseEvent e) {
		int xval;
		int yval;
		int i = 0;

		if (chessPiece == null)
			return;

		chessPiece.setVisible(false);
		Component c = chessBoard.findComponentAt(e.getX(), e.getY());

		for (Component Cmp : chessBoard.getComponents()) {

			if (c == Cmp) {
				xval = i / 8;
				yval = i % 8;
			}

			i++;
		}
		Coord init_coord = new Coord(xinit,yinit);
		Coord val_coord = new Coord(xval,yval);
		if (.move(init_coord,val_coord))
		if (c instanceof JLabel) {
			Container parent = c.getParent();
			parent.remove(0);
			parent.add(chessPiece);
		} else {
			Container parent = (Container) c;
			parent.add(chessPiece);
		}

		chessPiece.setVisible(true);
		
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public static void main(String[] args) {
		JFrame frame = new ChessGameGUI();
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
