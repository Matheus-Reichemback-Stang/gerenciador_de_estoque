package projeto.gerenciadordeestoque.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import projeto.gerenciadordeestoque.DAO.IProdutoDAO;
import projeto.gerenciadordeestoque.DAO.ProdutoDAO;
import projeto.gerenciadordeestoque.MainApplication;
import projeto.gerenciadordeestoque.entity.Produto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PesquisarController {

    private Stage stage;

    private IProdutoDAO produtoDAO = new ProdutoDAO();

    private ObservableList<Produto> listaCompleta = FXCollections.observableArrayList();
    private ObservableList<Produto> listaFiltrada = FXCollections.observableArrayList();

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

    //Colunas da Tabela
    @FXML
    public TableColumn<Produto, Long> colID;
    @FXML
    public TableColumn<Produto, String> colCodigo;
    @FXML
    public TableColumn<Produto, String> colNome;
    @FXML
    public TableColumn<Produto, String> colMarca;
    @FXML
    public TableColumn<Produto, String> colCategoria;
    @FXML
    public TableColumn<Produto, Integer> colQuantidade;
    @FXML
    public TableColumn<Produto, String> colPrecoUnidade; // Double
    @FXML
    public TableColumn<Produto, String> colPrecoTotal; // Double

    private void setProdutosInObservableList(ObservableList<Produto> listaDeProdutos) throws Exception {
        List<Produto> produtosDB = produtoDAO.buscarTodos();
        if(produtosDB != null){
            for(Produto produto : produtosDB) {
                listaDeProdutos.add(produto);
            }
        }
    }

    @FXML
    public void initialize() throws Exception {
        // Definindo classes CSS
        pesquisarPane.getStyleClass().add("screen");
        btnCadastrar.getStyleClass().add("button");
        btnPesquisar.getStyleClass().add("button");
        btnAtualizar.getStyleClass().add("button");
        btnDeletar.getStyleClass().add("button");
        btnGrafico.getStyleClass().add("button");
        btnPesquisar.getStyleClass().add("active");
        btnPesquisarPorItem.getStyleClass().add("btnPesquisar");
        colID.getStyleClass().add("table-cell");
        colCodigo.getStyleClass().add("table-cell");
        colNome.getStyleClass().add("table-cell");
        colMarca.getStyleClass().add("table-cell");
        colCategoria.getStyleClass().add("table-cell");
        colQuantidade.getStyleClass().add("table-cell");
        colPrecoUnidade.getStyleClass().add("table-cell");
        colPrecoTotal.getStyleClass().add("table-cell");

        // Adicionando itens no campo de seleção
        cbCategoria.getItems().addAll("Todos", "Frutas", "Verduras", "Legumes", "Grãos", "Carnes", "Peixes", "Laticínios", "Pães", "Massas", "Doces", "Bebidas");
        cbCategoria.getSelectionModel().selectFirst();

        // Ligando as colunas com os atributos da classe Produto
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        colPrecoUnidade.setCellValueFactory(new PropertyValueFactory<>("precoUnidadeFormatado")); // precoUnidade
        colPrecoTotal.setCellValueFactory(new PropertyValueFactory<>("precoTotalFormatado")); // precoTotal

        // Definindo so produtos do banco de dados no ObservableList
        setProdutosInObservableList(listaCompleta);
        setProdutosInObservableList(listaFiltrada);

        // Aplicando a lista do ObservableList na tabela
        tvProdutos.setItems(listaFiltrada);
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

    @FXML
    public void onClickPesquisarPorItem() {
        String categoria = cbCategoria.getValue();
        String nome = tfNome.getText().toLowerCase();

        if(categoria.equals("Todos") && nome.isEmpty()) {
            listaFiltrada.clear();
            listaFiltrada.addAll(listaCompleta);
        } else if(categoria.equals("Todos")) {
            listaFiltrada.clear();
            for(Produto produto : listaCompleta) {
                String nomeProduto = produto.getNome().toLowerCase();
                if(nomeProduto.contains(nome)) {
                    listaFiltrada.add(produto);
                }
            }
        }  else if(nome.isEmpty()) {
            listaFiltrada.clear();
            for(Produto produto : listaCompleta) {
                if(produto.getCategoria().equals(categoria)) {
                    listaFiltrada.add(produto);
                }
            }
        } else {
            listaFiltrada.clear();
            for(Produto produto : listaCompleta) {
                String nomeProduto = produto.getNome().toLowerCase();
                String categoriaProduto = produto.getCategoria();
                if(nomeProduto.contains(nome) &&  categoriaProduto.equals(categoria)) {
                    listaFiltrada.add(produto);
                }
            }
        }

    }
}
