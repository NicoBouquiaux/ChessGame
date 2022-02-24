package GameApplication.model.chess.piece;

import GameApplication.model.chess.Board;
import GameApplication.model.chess.piece.pieces.Piecetype;
import GameApplication.model.chess.spot.Spot;

import java.util.Objects;

public abstract class Piece {
    //type enum BLACK of WHITE
    private PieceColor pieceColor;
    //Locatie van de Piece in rij kolom
    private Spot pieceLocation;
    //belangrijk voor castling en enpassant?
    private boolean moved=false;

    public abstract Piecetype getPieceType();

    public Spot getPieceLocation(){
        return pieceLocation;
    }

    public int getColumn(){
        return pieceLocation.getColumn();
    }

    public int getRow(){
        return pieceLocation.getRow();
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public boolean isMoved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    //retourneert een array van Spots die deze Piece naartoe kan gaan.
    public abstract Spot[][] validMoves(Board board);

    public Piece(PieceColor pieceColor, Spot pieceLocation) {
        this.pieceColor = pieceColor;
        this.pieceLocation = pieceLocation;

    }

    //Gemakkelijke methode om de tegenstanders kleur te verkrijgen
    public PieceColor getAttackerColor() {
        return this.getPieceColor()==PieceColor.WHITE ? PieceColor.BLACK:PieceColor.WHITE;
    }


    public abstract boolean moveToSpot(Board board,Spot  spot);


    //is een boolean om een loop rond de move te zetten (zolang move niet valid is moet de player opnieuw een move inzetten)
    public abstract boolean moveTo(Spot spot);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return pieceColor == piece.pieceColor && getRow() == ((Piece) o).getRow() && getColumn()==((Piece) o).getColumn();
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceColor, getRow(),getColumn());
    }

    @Override
    public String toString() {
        return "Piece{" +
                "pieceColor=" + pieceColor +
                ", pieceLocation=" + pieceLocation +
                ", moved=" + moved +
                ", pieceType=" + this.getPieceType() +
                '}';
    }
}