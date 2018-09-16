package br.com.json;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class Json {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        List<Usuario> listaUsuarios = null;

        listaUsuarios = UsuarioDao.listar();

        //Criando um JSONArray e preenchendo com o resultado da busca do db
        JSONArray my_array = new JSONArray();

        for (Usuario lista : listaUsuarios) {

            //Instânciando um novo JSONObject
            JSONObject my_obj = new JSONObject();

            //Preenchendo o objeto
            my_obj.put("idUsuario", lista.getIdUsuario());
            my_obj.put("nome", lista.getNome());
            my_obj.put("email", lista.getEmail());
            my_obj.put("login", lista.getLogin());
            my_obj.put("senha", lista.getSenha());
            my_obj.put("grupoFilial", lista.getGrupoFilial());
            my_obj.put("departamento", lista.getDepartamento());
            my_obj.put("cargo", lista.getCargo());

            //Preenchendo o array
            my_array.put(my_obj);
        }

        System.out.println("IMPRIMINDO JSONArray");
        for (int i = 0; i < my_array.length(); i++) {
            System.out.println("(" + i + ")" + my_array.get(i));
        }

        //Insere o array no JSONObject com o rótulo "usuários"
        JSONObject my_obj = new JSONObject();
        my_obj.put("usuarios", my_array);

        //Imprimindo o objeto
        System.out.println("IMPRIMINDO JSONObject");
        System.out.println(my_obj);
        try {

            //Escrevendo um arquivo com conteudo JSON
            //Salvando o arquivo na pasta temporária do Windows
            FileWriter writeFile = new FileWriter("C:\\temp\\saidaJSON.json");
            writeFile.write(my_obj.toString());
            writeFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
