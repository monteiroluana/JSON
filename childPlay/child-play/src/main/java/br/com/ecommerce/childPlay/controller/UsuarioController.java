package br.com.ecommerce.childPlay.controller;

import br.com.ecommerce.childPlay.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsuarioController {

    @RequestMapping("/getUsario")
    public @ResponseBody Usuario getUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNome("Kunieda Aoi");
        usuario.setLogin("aoi");
        usuario.setSenha("kuni3d@");
        return usuario;
    }

}
