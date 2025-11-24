package projeto.gerenciadordeestoque.DAO;

import projeto.gerenciadordeestoque.entity.Produto;
import projeto.gerenciadordeestoque.jdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO{
    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlInsert();
            stm = connection.prepareStatement(sql); // Verifica se o comando sql é válido
            adicionarParametrosInsert(stm, produto);
            return stm.executeUpdate();
        } catch(Exception e){
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    @Override
    public Integer atualizar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlUpdate();
            stm = connection.prepareStatement(sql);
            adicionarParametrosUpdate(stm, produto);
            return stm.executeUpdate();
        } catch(Exception e){
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    @Override
    public Produto buscar(Long id) throws Exception {
        Connection connetion = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = null;
        try {
            connetion = ConnectionFactory.getConnection();
            String sql = getSqlSelect();
            stm = connetion.prepareStatement(sql);
            adicionarParametrosSelect(stm, id);
            rs = stm.executeQuery();
            if(rs.next()){
                produto = new Produto();
                Long id_db = rs.getLong("ID");
                String nome = rs.getString("NOME");
                String marca = rs.getString("MARCA");
                String categoria = rs.getString("CATEGORIA");
                Integer quantidade = rs.getInt("QUANTIDADE");
                Double precoUnidade = rs.getDouble("PRECO_UNIDADE");
                produto.setId(id_db);
                produto.setNome(nome);
                produto.setMarca(marca);
                produto.setCategoria(categoria);
                produto.setQuantidade(quantidade);
                produto.setPrecoUnidade(precoUnidade);
                produto.setPrecoTotal(precoUnidade, quantidade);
            }
        } catch(Exception e){
            throw e;
        } finally {
            closeConnection(connetion, stm, rs);
        }
        return produto;
    }

    @Override
    public Integer deletar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlDelete();
            stm = connection.prepareStatement(sql);
            adicionarParametroDelete(stm, produto);
            return stm.executeUpdate();
        } catch(Exception e){
            throw e;
        }finally {
            closeConnection(connection, stm, null);
        }
    }

    @Override
    public List<Produto> buscarTodos() throws Exception {
        Connection connetion = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Produto> listaDeProdutos = new ArrayList<>();
        try {
            connetion = ConnectionFactory.getConnection();
            String sql = getSqlSelectAll();
            stm = connetion.prepareStatement(sql);
            rs = stm.executeQuery();
            while(rs.next()){
                Produto produto = new Produto();
                Long id = rs.getLong("ID");
                String nome = rs.getString("NOME");
                String marca = rs.getString("MARCA");
                String categoria = rs.getString("CATEGORIA");
                Integer quantidade = rs.getInt("QUANTIDADE");
                Double precoUnidade = rs.getDouble("PRECO_UNIDADE");
                produto.setId(id);
                produto.setNome(nome);
                produto.setMarca(marca);
                produto.setCategoria(categoria);
                produto.setQuantidade(quantidade);
                produto.setPrecoUnidade(precoUnidade);
                produto.setPrecoTotal(precoUnidade, quantidade);
                listaDeProdutos.add(produto);
            }
        } catch(Exception e){
            throw e;
        } finally {
            closeConnection(connetion, stm, rs);
        }
        return listaDeProdutos;
    }



    private void closeConnection(Connection connection, PreparedStatement stm, ResultSet rs){
        try {
            if(rs != null && !rs.isClosed()) {
                rs.close();
            }
            if(stm != null && !stm.isClosed()) {
                stm.close();
            }
            if(connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private String getSqlInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO tb_produto (ID, NOME, MARCA, CATEGORIA, QUANTIDADE, PRECO_UNIDADE, PRECO_TOTAL) ");
        sb.append("VALUES (nextval('sq_produto'), ?, ?, ?, ?, ?, ?)");
        return sb.toString();
    }

    private void adicionarParametrosInsert(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setString(1, produto.getNome());
        stm.setString(2, produto.getMarca());
        stm.setString(3, produto.getCategoria());
        stm.setInt(4, produto.getQuantidade());
        stm.setDouble(5, produto.getPrecoUnidade());
        stm.setDouble(6, produto.getPrecoTotal());
    }

    private String getSqlUpdate() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE tb_produto ");
        sb.append("SET NOME = ?, MARCA = ?, CATEGORIA = ?, QUANTIDADE = ?, PRECO_UNIDADE = ?, PRECO_TOTAL = ? ");
        sb.append("WHERE ID = ?");
        return sb.toString();
    }

    private void adicionarParametrosUpdate(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setString(1, produto.getNome());
        stm.setString(2, produto.getMarca());
        stm.setString(3, produto.getCategoria());
        stm.setInt(4, produto.getQuantidade());
        stm.setDouble(5, produto.getPrecoUnidade());
        stm.setDouble(6, produto.getPrecoTotal());
        stm.setLong(7, produto.getId());
    }

    private String getSqlSelect() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM tb_produto ");
        sb.append("WHERE id = ?");
        return sb.toString();
    }

    private void adicionarParametrosSelect(PreparedStatement stm, Long id) throws SQLException {
        stm.setLong(1, id);
    }

    private String getSqlDelete() {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM tb_produto ");
        sb.append("WHERE id = ?");
        return sb.toString();
    }

    private void adicionarParametroDelete(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setLong(1, produto.getId());
    }

    private String getSqlSelectAll() {
        return "SELECT * FROM tb_produto";
    }
}
