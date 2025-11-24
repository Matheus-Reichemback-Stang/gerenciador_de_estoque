import org.junit.jupiter.api.Test;
import projeto.gerenciadordeestoque.DAO.IProdutoDAO;
import projeto.gerenciadordeestoque.DAO.ProdutoDAO;
import projeto.gerenciadordeestoque.entity.Produto;

import static org.junit.Assert.*;

public class TestProdutoDAO {

    private IProdutoDAO produtoDAO = new ProdutoDAO();

    @Test
    public void cadastarProdutoComSucesso() throws Exception {
        Produto produto = new Produto("kjdas18sdfs87342h", "Manga", "", "Frutas", 5, 7.35);
        Integer linhaInsert = produtoDAO.cadastrar(produto);
        assertTrue(linhaInsert == 1);

        Produto produtoDB = produtoDAO.buscar(produto.getCodigo());
        assertEquals(produto.getCodigo(), produtoDB.getCodigo());
        assertEquals(produto.getNome(), produtoDB.getNome());
        assertEquals(produto.getMarca(), produtoDB.getMarca());
        assertEquals(produto.getCategoria(), produtoDB.getCategoria());
        assertEquals(produto.getQuantidade(), produtoDB.getQuantidade());
        assertEquals(produto.getPrecoUnidade(), produtoDB.getPrecoUnidade());
        assertEquals(produto.getPrecoTotal(), produtoDB.getPrecoTotal());

        Integer linhaDelete = produtoDAO.deletar(produtoDB);
        assertTrue(linhaDelete == 1);

        Produto produtoDB2 = produtoDAO.buscar(produto.getCodigo());
        assertEquals(null, produtoDB2);
    }

    @Test
    public void atualizarComSucesso() throws Exception {
        Produto produto = new Produto("kjdas18sdfs87342h", "Manga", "", "Frutas", 5, 7.35);
        Integer linhaInsert = produtoDAO.cadastrar(produto);
        assertTrue(linhaInsert == 1);

        Produto produtoDB = produtoDAO.buscar(produto.getCodigo());
        assertEquals(produto.getCodigo(), produtoDB.getCodigo());
        assertEquals(produto.getNome(), produtoDB.getNome());
        assertEquals(produto.getMarca(), produtoDB.getMarca());
        assertEquals(produto.getCategoria(), produtoDB.getCategoria());
        assertEquals(produto.getQuantidade(), produtoDB.getQuantidade());
        assertEquals(produto.getPrecoUnidade(), produtoDB.getPrecoUnidade());
        assertEquals(produto.getPrecoTotal(), produtoDB.getPrecoTotal());

        produtoDB.setNome("Laranja");
        produtoDB.setQuantidade(8);
        produtoDB.setPrecoTotal(produtoDB.getPrecoUnidade(), produtoDB.getQuantidade());
        Integer linhaUpdate = produtoDAO.atualizar(produtoDB);
        assertTrue(linhaUpdate == 1);

        Produto produtoDB2 = produtoDAO.buscar(produto.getCodigo());
        assertEquals(produtoDB.getCodigo(), produtoDB2.getCodigo());
        assertEquals(produtoDB.getNome(), produtoDB2.getNome());
        assertEquals(produtoDB.getMarca(), produtoDB2.getMarca());
        assertEquals(produtoDB.getCategoria(), produtoDB2.getCategoria());
        assertEquals(produtoDB.getQuantidade(), produtoDB2.getQuantidade());
        assertEquals(produtoDB.getPrecoUnidade(), produtoDB2.getPrecoUnidade());
        assertEquals(produtoDB.getPrecoTotal(), produtoDB2.getPrecoTotal());

        Integer linhaDelete = produtoDAO.deletar(produtoDB2);
        assertTrue(linhaDelete == 1);

        Produto produtoDB3 = produtoDAO.buscar(produto.getCodigo());
        assertEquals(null, produtoDB3);
    }
}
