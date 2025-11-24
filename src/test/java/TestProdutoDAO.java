import org.junit.jupiter.api.Test;
import projeto.gerenciadordeestoque.DAO.ProdutoDAO;
import projeto.gerenciadordeestoque.entity.Produto;

import static org.junit.Assert.assertNotNull;

public class TestProdutoDAO {


    @Test
    public void cadastarProduto() throws Exception {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = new Produto("Maçã", "1", "Fruta", 1, 3.50);
        Integer linha = produtoDAO.cadastrar(produto);
        assertNotNull(linha);
    }
}
