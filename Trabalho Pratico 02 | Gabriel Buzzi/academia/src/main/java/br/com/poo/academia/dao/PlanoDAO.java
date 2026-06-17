package br.com.poo.academia.dao;

import br.com.poo.academia.model.Plano;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanoDAO {

    // insere plano novo
    public boolean inserir(Plano plano) {
        String sql = "INSERT INTO plano (nome, descricao, valor, duracao) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, plano.getNome());
            stmt.setString(2, plano.getDescricao());
            stmt.setDouble(3, plano.getValor());
            stmt.setInt(4, plano.getDuracao());

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir plano: " + e.getMessage());
            return false;
        }
    }

    // lista tudo
    public List<Plano> listar() {
        List<Plano> planos = new ArrayList<>();
        String sql = "SELECT id, nome, descricao, valor, duracao FROM plano ORDER BY id";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Plano plano = new Plano(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("descricao"),
                    rs.getDouble("valor"),
                    rs.getInt("duracao")
                );
                planos.add(plano);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar planos: " + e.getMessage());
        }

        return planos;
    }

    // busca pelo id
    public Plano buscarPorId(int id) {
        String sql = "SELECT id, nome, descricao, valor, duracao FROM plano WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Plano(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getDouble("valor"),
                        rs.getInt("duracao")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar plano: " + e.getMessage());
        }

        return null;
    }

    // update - null = nao altera o campo
    public boolean atualizar(int id, String nome, String descricao, Double valor, Integer duracao) {
        // nenhum campo? sem sentido continuar
        if (nome == null && descricao == null && valor == null && duracao == null) {
            return false;
        }

        // monta o sql so com os campos que vieram
        StringBuilder sql = new StringBuilder("UPDATE plano SET ");
        List<Object> parametros = new ArrayList<>();

        if (nome != null) {
            sql.append("nome = ?, ");
            parametros.add(nome);
        }
        if (descricao != null) {
            sql.append("descricao = ?, ");
            parametros.add(descricao);
        }
        if (valor != null) {
            sql.append("valor = ?, ");
            parametros.add(valor);
        }
        if (duracao != null) {
            sql.append("duracao = ?, ");
            parametros.add(duracao);
        }

        // tira a virgula do final
        String sqlFinal = sql.toString().replaceAll(", $", "");
        sqlFinal += " WHERE id = ?";
        parametros.add(id);

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlFinal)) {

            for (int i = 0; i < parametros.size(); i++) {
                stmt.setObject(i + 1, parametros.get(i));
            }

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar plano: " + e.getMessage());
            return false;
        }
    }

    // deleta pelo id
    public boolean remover(int id) {
        String sql = "DELETE FROM plano WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao remover plano: " + e.getMessage());
            return false;
        }
    }

}
