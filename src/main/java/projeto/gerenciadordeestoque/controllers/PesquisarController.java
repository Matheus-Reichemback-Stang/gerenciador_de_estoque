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

public class PesquisarController {

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public AnchorPane pesquisarPane;

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


    // Campos para pesquisa
    @FXML
    public TextField tfNome;
    @FXML
    public ComboBox<String> cbCategoria;
    @FXML
    public Button btnPesquisarPorItem;

    // Tabela
    @FXML
    public TableView<Produto> tvProdutos;
    @FXML
    public TableColumn<Produto, Long> colID;
    @FXML
    public TableColumn<Produto, String> colNome;
    @FXML
    public TableColumn<Produto, String> colMarca;
    @FXML
    public TableColumn<Produto, String> colCategoria;
    @FXML
    public TableColumn<Produto, Integer> colQuantidade;
    @FXML
    public TableColumn<Produto, Double> colPrecoUnidade;
    @FXML
    public TableColumn<Produto, Double> colPrecoTotal;

    @FXML
    public void initialize() {
        // Definindo classes CSS
        pesquisarPane.getStyleClass().add("screen");
        btnCadastrar.getStyleClass().add("button");
        btnPesquisar.getStyleClass().add("button");
        btnAtualizar.getStyleClass().add("button");
        btnDeletar.getStyleClass().add("button");
        btnGrafico.getStyleClass().add("button");
        btnPesquisar.getStyleClass().add("active");
        btnPesquisarPorItem.getStyleClass().add("btnPesquisar");

        // Adicionando itens no campo de seleção
        cbCategoria.getItems().addAll("Frutas", "Verduras", "Legumes", "Grãos", "Carnes", "Peixes", "Laticínios", "Pães", "Massas", "Doces", "Bebidas");
        cbCategoria.getSelectionModel().selectFirst();
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
