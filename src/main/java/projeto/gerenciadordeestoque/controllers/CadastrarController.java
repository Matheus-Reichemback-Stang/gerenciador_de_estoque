package projeto.gerenciadordeestoque.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import projeto.gerenciadordeestoque.MainApplication;

import java.io.IOException;

public class CadastrarController {

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public AnchorPane cadastroPane;

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


    // Campos para cadastro
    @FXML
    public TextField tfNome;
    @FXML
    public TextField tfMarca;
    @FXML
    public ComboBox<String> cbCategoria; // ComboBox
    @FXML
    public TextField tfQuantidade;
    @FXML
    public TextField tfPrecoUnidade;

    // Botão de cadastro & Resultado de cadastro
    @FXML
    public Button btnAdicionarProduto;
    @FXML
    public Label lbAviso;




    @FXML
    public void initialize() {
        // Definindo classes CSS
        cadastroPane.getStyleClass().add("screen");
        btnCadastrar.getStyleClass().add("button");
        btnPesquisar.getStyleClass().add("button");
        btnAtualizar.getStyleClass().add("button");
        btnDeletar.getStyleClass().add("button");
        btnGrafico.getStyleClass().add("button");
        btnCadastrar.getStyleClass().add("active");
        lbAviso.getStyleClass().add("warn");

        // Definindo escolhas no ComboBox
        cbCategoria.getItems().addAll("Frutas", "Verduras", "Legumes", "Grãos", "Carnes", "Peixes", "Laticínios", "Pães", "Massas", "Doces", "Bebidas");
        cbCategoria.getSelectionModel().selectFirst();
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
    public void onClickAtualizar() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("atualizar.fxml"));
        Parent root = fxmlLoader.load();
        AtualizarController controller = fxmlLoader.getController();
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
