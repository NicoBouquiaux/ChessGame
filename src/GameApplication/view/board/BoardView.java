package GameApplication.view.board;

import GameApplication.view.ChessMenu;
import GameApplication.view.board.components.ChessBoard;
import GameApplication.view.board.components.PieceComp;
import GameApplication.view.board.components.Space;
import GameApplication.view.game.OptionButton;
import javafx.geometry.Bounds;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BoardView extends BorderPane {
    public Button[][] buttons = new Button[8][8];
    private Space[][] space;
    private final List<Space> validMovesSpaces;
    private final List<Space> validAttackSpaces;
    private final List<Space> clickedSpace;

    public Space activeSpace = null;
    public ChessBoard board;
    private OptionButton options;

    public ChessMenu getChessMenu() {
        return chessMenu;
    }

    private ChessMenu chessMenu;

    private Button btnSettings;
    private Button btnInstructions;
    private Button btnSave;


    private PieceComp[][] piecesFromModel;
    private boolean playerIsWhite;

    public Group getBoardGroup() {
        return boardGroup;
    }

    public Bounds getGameBounds() {
        return gameBounds;
    }

    private Group boardGroup;
    private Bounds gameBounds;
    private TextArea gameFlow;
    private GridPane textHolder;
    private TextField tfPath;
    private Label playerName1;
    private Label playerName2;

    private Label currentPlayerName;

    public BoardView() {
        initialiseNodes();
        layoutNodes();
        validMovesSpaces = new ArrayList<>();
        validAttackSpaces = new ArrayList<>();
        clickedSpace = new ArrayList<>();


    }

    public Button getBtnSave() {
        return btnSave;
    }

    public TextField getTfPath() {
        return tfPath;
    }

    public TextArea getGameFlow() {
        return gameFlow;
    }

    public Space[][] getSpace() {
        return space;
    }

    public GridPane getTextHolder() {
        return textHolder;
    }

    private Path myFile;

    private void initialiseNodes() {
        board = new ChessBoard(playerIsWhite);
        space = new Space[8][8];
        textHolder = new GridPane();

        playerName1=new Label("Player1");
        playerName2=new Label("Player2");

        currentPlayerName=new Label("");
        //Path myFile =  Paths.get(tfPath.getText());
//        tfPath.setText(myFile.toString());
    }


    private void layoutNodes() {
        chessMenu = new ChessMenu();
        //chessMenu.getMiSave();
        gameFlow = new TextArea();
        super.setTop(getChessMenu());



        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        BorderPane.setMargin(vbox,new Insets(10));
        playerName1.setFont(new Font(18));
        playerName2.setFont(new Font(18));




        vbox.getChildren().addAll(playerName2,board,playerName1);


        super.setCenter(vbox);


        //textArea layout
        GridPane.setColumnSpan(gameFlow, 10);
        GridPane.setRowSpan(gameFlow, 2);
        textHolder.setVgap(1);
        textHolder.add(gameFlow, 0, 25);
        GridPane.setHalignment(gameFlow, HPos.CENTER);
        super.setBottom(textHolder);
        GridPane.setHalignment(gameFlow, HPos.CENTER);


        super.isResizable();
        super.resize(computePrefWidth(ChessBoard.USE_PREF_SIZE) / USE_PREF_SIZE, computePrefHeight(ChessBoard.USE_PREF_SIZE) / USE_COMPUTED_SIZE);

    }


    public Space getActiveSpace() {
        return activeSpace;
    }

    private FileChooser createFileChooser() {
        FileChooser fileChooser = new FileChooser();
        board.getIO().forEach((k, v) -> fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter(v.getFileTypeDescription(), "*." + v.getFileExtension())));
        return fileChooser;
    }


    public List<Space> getValidMovesSpaces() {
        return validMovesSpaces;
    }

    public void setValidMovesSpaces(Space validMovesSpace) {
        this.validMovesSpaces.add(validMovesSpace);
    }

    public List<Space> getValidAttackSpaces() {
        return validAttackSpaces;
    }

    public List<Space> getClickedSpace() {
        return clickedSpace;
    }

    public void setValidAttackSpaces(Space validAttackSpace) {
        validAttackSpaces.add(validAttackSpace);
    }

    public void clearValidMovesSpaces() {
        this.validMovesSpaces.clear();
    }

    public void clearAttackSpaces() {
        this.validAttackSpaces.clear();
    }



    public void setPlayerName1(String name) {
        this.playerName1.setText(name);
    }



    public void setPlayerName2(String name) {
        this.playerName2.setText(name);
    }

    public ChessBoard getBoard() {
        return board;
    }

    public boolean isPlayerIsWhite() {
        return playerIsWhite;
    }

    public Label getCurrentPlayerName() {
        return currentPlayerName;
    }
}


