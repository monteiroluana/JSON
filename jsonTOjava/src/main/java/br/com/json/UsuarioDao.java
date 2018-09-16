package br.com.json;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    public static List<Usuario> listar() throws ClassNotFoundException, SQLException {

        String sql = "SELECT * FROM imobiliariadb.USUARIO";

        List<Usuario> lista = new ArrayList<Usuario>();

        Connection conn = null;

        try {
            conn = Conexao.obterConexao();
            PreparedStatement stmt = conn.prepareStatement(sql);
            //stmt.setBoolean(1, true);
            //Armazenará os resultados do banco de dados
            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {
                Integer id = resultados.getInt("idUsuario");
                String nome = resultados.getString("nome");
                String email = resultados.getString("email");
                String login = resultados.getString("login");
                String senha = resultados.getString("senha");
                String grupoFilial = resultados.getString("grupoFilial");
                String departamento = resultados.getString("departamento");
                String cargo = resultados.getString("cargo");

                Usuario user = new Usuario();
                user.setIdUsuario(id);
                user.setNome(nome);
                user.setEmail(email);
                user.setLogin(login);
                user.setSenha(senha);
                user.setGrupoFilial(grupoFilial);
                user.setDepartamento(departamento);
                user.setCargo(cargo);
                lista.add(user);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            conn.close();
        }

        return lista;
    }
}
