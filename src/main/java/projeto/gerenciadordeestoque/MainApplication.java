package projeto.gerenciadordeestoque;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("home.fxml"));
        Parent root = fxmlLoader.load();

        MainController controller = fxmlLoader.getController();
        controller.setStage(stage);

        Scene scene = new Scene(root, 1080, 756);
        stage.setTitle("Gerenciador de Estoque");
        stage.setScene(scene);
        stage.show();
    }
}
