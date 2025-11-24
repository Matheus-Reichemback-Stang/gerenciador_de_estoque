package projeto.gerenciadordeestoque.DAO;

import projeto.gerenciadordeestoque.entity.Produto;

import java.util.List;

public interface IProdutoDAO {

    public Integer cadastrar(Produto produto) throws Exception;

    public Integer atualizar(Produto produto) throws Exception;

    public Produto buscar(String codigo) throws Exception;

    public List<Produto> buscarTodos() throws Exception;

    public Integer deletar(Produto produto) throws Exception;
}
