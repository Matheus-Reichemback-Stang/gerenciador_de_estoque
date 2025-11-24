package projeto.gerenciadordeestoque.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import projeto.gerenciadordeestoque.MainApplication;
import projeto.gerenciadordeestoque.entity.Produto;

import java.io.IOException;

public class AtualizarController {

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public AnchorPane atualizarPane;

    // Botões de abas
    @FXML
    public Button btnCadastrar;
    @FXML
    public Button btnPesquisar;
    @FXML
    public Button btnAtualizar;
    @FXML
    public Button btnDeletar;
    @FXML
    public Button btnGrafico;

    // Campo de Busca
    @FXML
    public TextField tfID;

    // Campos de dados coletados
    @FXML
    public TextField tfNome;
    @FXML
    public TextField tfMarca;
    @FXML
    public ComboBox<String> cbCategoria;
    @FXML
    public TextField tfQuantidade;
    @FXML
    public TextField tfPreco;


    @FXML
    public void initialize() {
        // Definindo classes CSS
        atualizarPane.getStyleClass().add("screen");
        btnCadastrar.getStyleClass().add("button");
        btnPesquisar.getStyleClass().add("button");
        btnAtualizar.getStyleClass().add("button");
        btnDeletar.getStyleClass().add("button");
        btnGrafico.getStyleClass().add("button");
        btnAtualizar.getStyleClass().add("active");
    }

    @FXML
    public void onClickCadastrar() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("cadastrar.fxml"));
        Parent root = fxmlLoader.load();
        CadastrarController controller = fxmlLoader.getController();
        controller.setStage(stage);
        Scene scene = stage.getScene();
        scene.setRoot(root);
    }

    @FXML
    public void onClickPesquisar() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("pesquisar.fxml"));
        Parent root = fxmlLoader.load();
        PesquisarController controller = fxmlLoader.getController();
        controller.setStage(stage);
        Scene scene = stage.getScene();
        scene.setRoot(root);
    }

    @FXML
    public void onClickDeletar() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("deletar.fxml"));
        Parent root = fxmlLoader.load();
        DeletarController controller = fxmlLoader.getController();
        controller.setStage(stage);
        Scene scene = stage.getScene();
        scene.setRoot(root);
    }

    @FXML
    public void onClickGrafico() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("grafico.fxml"));
        Parent root = fxmlLoader.load();
        GraficoController controller = fxmlLoader.getController();
        controller.setStage(stage);
        Scene scene = stage.getScene();
        scene.setRoot(root);
    }
}
