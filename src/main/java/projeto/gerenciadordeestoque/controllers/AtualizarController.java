package projeto.gerenciadordeestoque.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import projeto.gerenciadordeestoque.DAO.IProdutoDAO;
import projeto.gerenciadordeestoque.DAO.ProdutoDAO;
import projeto.gerenciadordeestoque.MainApplication;
import projeto.gerenciadordeestoque.entity.Produto;

import java.io.IOException;

public class AtualizarController {

    private Stage stage;

    private IProdutoDAO produtoDAO = new ProdutoDAO();

    private Produto produtoDB = null;

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
    public TextField tfCodigo;
    @FXML
    public Label lbAvisoBuscar;

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
    public Label lbAvisoSalvar;
    @FXML
    public Button btnPesquisarPorItem;
    @FXML
    public Button btnSalvar;
    @FXML
    public Button btnCancelar;


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
        btnPesquisarPorItem.getStyleClass().add("btnPesquisar");
        btnSalvar.getStyleClass().add("btnSalvar");
        btnCancelar.getStyleClass().add("btnCancelarDeletar");

        // Definindo escolhas no ComboBox
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

    private boolean isCampoVazio(TextField tf) {
        return tf.getText().isEmpty();
    }

    private boolean isInteger(TextField tf) {
        try {
            Integer.parseInt(tf.getText());
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    private boolean isDouble(TextField tf) {
        try {
            Double.parseDouble(tf.getText());
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    private void clearFields() {
        produtoDB = null;
        tfCodigo.clear();
        tfNome.clear();
        tfMarca.clear();
        tfQuantidade.clear();
        tfPreco.clear();
        cbCategoria.getSelectionModel().selectFirst();
    }

    @FXML
    public void onClickBuscar() throws Exception {
        lbAvisoBuscar.setText("");
        lbAvisoSalvar.setText("");
        if(isCampoVazio(tfCodigo)) {
            lbAvisoBuscar.setText("Preencha o campo com o código do produto");
        } else {
            String codigo =  tfCodigo.getText().toUpperCase();
            produtoDB = produtoDAO.buscar(codigo);

            if(produtoDB == null){
                lbAvisoBuscar.setText("Não existe um produto com este código");
            } else {;
                tfNome.setText(produtoDB.getNome());
                tfMarca.setText(produtoDB.getMarca());
                cbCategoria.setValue(produtoDB.getCategoria());
                tfQuantidade.setText(String.valueOf(produtoDB.getQuantidade()));
                tfPreco.setText(String.valueOf(produtoDB.getPrecoUnidade()));
            }
        }
    }

    @FXML
    public void onClickCancelar() {
        clearFields();
    }

    @FXML
    public void onClickSalvar() throws Exception {
        if(isCampoVazio(tfNome) || isCampoVazio(tfQuantidade) || isCampoVazio(tfPreco)) {
            lbAvisoSalvar.setText("É preciso preencher os campos obrigatórios!");
        } else if(!isInteger(tfQuantidade) || Integer.parseInt(tfQuantidade.getText()) <= 0) {
            lbAvisoSalvar.setText("O campo Quantidade só aceita um NÚMERO INTEIRO e MAIOR QUE ZERO!");
        } else if(!isDouble(tfPreco) || Double.parseDouble(tfPreco.getText()) <= 0) {
            lbAvisoSalvar.setText("O campo Preço Unidade só aceita um NÚMERO DECIMAL e MAIOR QUE ZERO!");
        } else {
            String nome = tfNome.getText();
            String marca = tfMarca.getText();
            String categoria = cbCategoria.getValue();
            int quantidade = Integer.parseInt(tfQuantidade.getText());
            double precoUnidade = Double.parseDouble(tfPreco.getText());

            produtoDB.setNome(nome);
            produtoDB.setMarca(marca);
            produtoDB.setCategoria(categoria);
            produtoDB.setQuantidade(quantidade);
            produtoDB.setPrecoUnidade(precoUnidade);
            produtoDB.setPrecoTotal(precoUnidade, quantidade);

            Integer linhaAtualizar = produtoDAO.atualizar(produtoDB);

            if(linhaAtualizar == 1){
                lbAvisoSalvar.setText("Produto atualizado com sucessso!");
                clearFields();
            } else {
                lbAvisoSalvar.setText("Houve um erro ao atualizar o produto!");
            }
        }
    }
}
