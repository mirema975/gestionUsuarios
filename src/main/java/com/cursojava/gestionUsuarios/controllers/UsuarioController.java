package com.cursojava.gestionUsuarios.controllers;

import com.cursojava.gestionUsuarios.dao.UsuarioDao;
import com.cursojava.gestionUsuarios.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController{

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuarios/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario1 = new Usuario();
        usuario1.setId(id);
        usuario1.setNombre("Jorge");
        usuario1.setApellido("Miranda");
        usuario1.setEmail("emanuelmiranda975@gmail.com");
        usuario1.setPassword("42477975");
        usuario1.setTelefono("2616204355");
        return usuario1;
    }

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario){

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d);
        String hash = argon2.hash(1,1024,1,usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDao.registrar(usuario);
    }

    @RequestMapping(value = "usuario34")
    public Usuario editar(){
        Usuario usuario1 = new Usuario();
        usuario1.setNombre("Emanuel");
        usuario1.setApellido("Miranda");
        usuario1.setEmail("emanuelmiranda975@gmail.com");
        usuario1.setPassword("42477975");
        usuario1.setTelefono("2616204355");
        return usuario1;
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id){
        usuarioDao.eliminarUsuario(id);
    }

    @RequestMapping(value = "usuario12")
    public Usuario buscar(){
        Usuario usuario1 = new Usuario();
        usuario1.setNombre("Emanuel");
        usuario1.setApellido("Miranda");
        usuario1.setEmail("emanuelmiranda975@gmail.com");
        usuario1.setPassword("42477975");
        usuario1.setTelefono("2616204355");
        return usuario1;
    }

}
