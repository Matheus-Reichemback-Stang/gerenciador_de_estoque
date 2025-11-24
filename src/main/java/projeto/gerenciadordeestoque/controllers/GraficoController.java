package projeto.gerenciadordeestoque.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import projeto.gerenciadordeestoque.MainApplication;

import java.io.IOException;

public class GraficoController {
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public AnchorPane graficoPane;

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

    // Gráficos
    @FXML
    public PieChart pcProdutoQtd;
    @FXML
    public PieChart pcCategoriaQtd;

    @FXML
    public void initialize() {
        // Definindo classes CSS
        graficoPane.getStyleClass().add("screen");
        btnCadastrar.getStyleClass().add("button");
        btnPesquisar.getStyleClass().add("button");
        btnAtualizar.getStyleClass().add("button");
        btnDeletar.getStyleClass().add("button");
        btnGrafico.getStyleClass().add("button");
        btnGrafico.getStyleClass().add("active");

        pcCategoriaQtd.getData().addAll(
                new PieChart.Data("Frutas", 45),
                new PieChart.Data("Verduras", 30),
                new PieChart.Data("Legumes", 28),
                new PieChart.Data("Carnes", 25),
                new PieChart.Data("Peixes", 15),
                new PieChart.Data("Laticínios", 22),
                new PieChart.Data("Grãos", 18),
                new PieChart.Data("Massas", 12),
                new PieChart.Data("Pães", 20),
                new PieChart.Data("Bebidas", 35),
                new PieChart.Data("Doces", 17),
                new PieChart.Data("Snacks", 14)
        );

        pcProdutoQtd.getData().addAll(
                new PieChart.Data("Maçã", 12),
                new PieChart.Data("Banana", 18),
                new PieChart.Data("Uva", 14),
                new PieChart.Data("Laranja", 10),

                new PieChart.Data("Alface", 8),
                new PieChart.Data("Couve", 5),
                new PieChart.Data("Espinafre", 7),

                new PieChart.Data("Tomate", 11),
                new PieChart.Data("Cenoura", 9),
                new PieChart.Data("Batata", 20),

                new PieChart.Data("Carne Bovina", 13),
                new PieChart.Data("Carne Suína", 9),
                new PieChart.Data("Frango", 16),
                new PieChart.Data("Salmão", 6),

                new PieChart.Data("Leite Integral", 14),
                new PieChart.Data("Queijo Mussarela", 10),
                new PieChart.Data("Iogurte Natural", 8),

                new PieChart.Data("Arroz", 25),
                new PieChart.Data("Feijão", 18),

                new PieChart.Data("Pão Francês", 15),
                new PieChart.Data("Macarrão Espaguete", 12),

                new PieChart.Data("Refrigerante", 22),
                new PieChart.Data("Suco de Laranja", 14),
                new PieChart.Data("Água", 30),

                new PieChart.Data("Chocolate", 10),
                new PieChart.Data("Biscoito", 13)
        );

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
}
