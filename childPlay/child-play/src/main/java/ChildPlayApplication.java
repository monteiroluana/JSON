

import br.com.ecommerce.childPlay.dao.UsuarioDAO;
import br.com.ecommerce.childPlay.model.Usuario;
import java.sql.SQLException;
import java.util.List;

public class ChildPlayApplication {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        List<Usuario> lista = usuarioDao.listUsuarios();
       
       for (Usuario user : lista) {
           System.out.println("userNome: "+user.getNome());
      }

    }
}
