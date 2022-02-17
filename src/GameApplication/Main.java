package GameApplication;

import GameApplication.model.Chess;
import GameApplication.view.board.BoardPresenter;
import GameApplication.view.board.BoardView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Chess model = new Chess();
        BoardView view = new BoardView();
        BoardPresenter presenter = new BoardPresenter(model, view);

        Scene scene = new Scene(view.getPane(), 440,490);

        primaryStage.setScene(scene);

        primaryStage.setTitle("Ultimate Chess");
        primaryStage.show();
        primaryStage.setMinWidth(primaryStage.getWidth());
        primaryStage.setMinHeight(primaryStage.getHeight());

    }

    public static void main(String[] args) { launch(args); }
}
