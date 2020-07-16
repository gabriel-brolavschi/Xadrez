/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Xadrez {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            try{
            UI.clearScreen();
            UI.printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.print("SOURCE: ");
            ChessPosition source = UI.readChessPosition(sc);
            
            boolean [][] possibleMoves = chessMatch.possibleMoves(source);
            UI.clearScreen();
            UI.printBoard(chessMatch.getPieces(), possibleMoves);
            
            System.out.println();
            System.out.print("TARGET: ");
            ChessPosition target = UI.readChessPosition(sc);

            ChessPiece capturedPíece = chessMatch.performChessMove(source, target);
        }catch(ChessException e){
                System.out.println(e.getMessage());
                sc.nextLine();
        }catch(InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            
        }

    }

}
}
