package projeto.gerenciadordeestoque.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import projeto.gerenciadordeestoque.DAO.IProdutoDAO;
import projeto.gerenciadordeestoque.DAO.ProdutoDAO;
import projeto.gerenciadordeestoque.MainApplication;
import projeto.gerenciadordeestoque.entity.Produto;

import java.io.IOException;

public class DeletarController {

    private Stage stage;

    private IProdutoDAO produtoDAO = new ProdutoDAO();

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public AnchorPane deletarPane;

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


    // Campos para deletar item
    @FXML
    public TextField tfCodigo;
    @FXML
    public Label lbAviso;

    @FXML
    public void initialize() {
        // Definindo classes CSS
        deletarPane.getStyleClass().add("screen");
        btnCadastrar.getStyleClass().add("button");
        btnPesquisar.getStyleClass().add("button");
        btnAtualizar.getStyleClass().add("button");
        btnDeletar.getStyleClass().add("button");
        btnGrafico.getStyleClass().add("button");
        btnDeletar.getStyleClass().add("active");
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
    public void onClickGrafico() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("grafico.fxml"));
        Parent root = fxmlLoader.load();
        GraficoController controller = fxmlLoader.getController();
        controller.setStage(stage);
        Scene scene = stage.getScene();
        scene.setRoot(root);
    }

    @FXML
    public void onClickDeletar() throws Exception {
        if(tfCodigo.getText().isEmpty()) {
            lbAviso.setText("O campo precisa ser preenchido com o código do produto!");
        } else {
            String codigo = tfCodigo.getText();
            Produto proudutoDB = produtoDAO.buscar(codigo);

            if(proudutoDB == null) {
                lbAviso.setText("Não existe um Produto com o código digitado!");
            } else {
                Integer linhaDeletar = produtoDAO.deletar(proudutoDB);
                if(linhaDeletar == 1) {
                    lbAviso.setText("Produto removido com sucesso!");
                    tfCodigo.clear();
                } else {
                    lbAviso.setText("Houve um erro ao deletar!");
                }
            }
        }
    }
}
