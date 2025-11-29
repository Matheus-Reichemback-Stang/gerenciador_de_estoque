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
import projeto.gerenciadordeestoque.DAO.IProdutoDAO;
import projeto.gerenciadordeestoque.DAO.ProdutoDAO;
import projeto.gerenciadordeestoque.MainApplication;
import projeto.gerenciadordeestoque.entity.Produto;

import java.io.IOException;
import java.util.List;

public class GraficoController {
    private Stage stage;

    private IProdutoDAO produtoDAO = new ProdutoDAO();

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
    public Label lbProdutoQtd;
    @FXML
    public Label lbCategoriaQtd;
    @FXML
    public Label lbAviso;

    private void setDataCategoriaQtd(PieChart pcCategoriaQtd) throws Exception {
        List<Produto> produtos = produtoDAO.buscarTodos();
        if(produtos.size() > 0) {
            for(Produto produto : produtos) {
                String categoria = produto.getCategoria();
                Integer quantidade = produto.getQuantidade();
                PieChart.Data data = tryFindCategoria(pcCategoriaQtd, categoria);
                if(data != null) {
                    data.setPieValue(data.getPieValue() + quantidade);
                } else {
                    pcCategoriaQtd.getData().add(new PieChart.Data(categoria, quantidade));
                }

            }
        }

    }

    // Verifica se a categoria já está presente em alguma fatia, se sim, apenas acrescenta o valor e não cria uma fatia nova
    private PieChart.Data tryFindCategoria(PieChart pcCategoriaQtd, String categoria) {
        for(PieChart.Data data : pcCategoriaQtd.getData()) {
            if(data.getName().equals(categoria)) {
                return data;
            }
        }
        return null;
    }

    private void setDataProdutoQtd(PieChart pcProdutoQtd) throws Exception {
        List<Produto> produtos = produtoDAO.buscarTodos();
        if(produtos.size() > 0) {
            for(Produto produto : produtos) {
                String produtoNome;
                if(produto.getMarca() != null){
                    produtoNome = produto.getNome() + " " + produto.getMarca();
                } else {
                    produtoNome = produto.getNome();
                }
                Integer quantidade = produto.getQuantidade();
                pcProdutoQtd.getData().add(new PieChart.Data(produtoNome, quantidade));
            }
        }
    }

    private void setGraphicSize(PieChart grafico, Integer value) {
        grafico.setPrefSize(value, value);
        grafico.setMinSize(value, value);
        grafico.setMaxSize(value, value);
    }

    @FXML
    public void initialize() throws Exception {
        // Definindo classes CSS
        graficoPane.getStyleClass().add("screen");
        btnCadastrar.getStyleClass().add("button");
        btnPesquisar.getStyleClass().add("button");
        btnAtualizar.getStyleClass().add("button");
        btnDeletar.getStyleClass().add("button");
        btnGrafico.getStyleClass().add("button");
        btnGrafico.getStyleClass().add("active");


        //setGraphicSize(pcCategoriaQtd, 350);
        //setGraphicSize(pcProdutoQtd, 350);
        setDataCategoriaQtd(pcCategoriaQtd);
        setDataProdutoQtd(pcProdutoQtd);

        if(pcCategoriaQtd.getData().isEmpty() || pcProdutoQtd.getData().isEmpty()) {
            lbProdutoQtd.setText("");
            lbCategoriaQtd.setText("");
            lbAviso.setText("Não há dados para produzir gráficos!");
        }


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
