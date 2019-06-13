/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.android.facade;

import br.android.dao.UsuarioDAO;
import br.android.model.Usuario;

/**
 *
 * @author patri
 */
public class UsuarioFacade {
    public static boolean login(Usuario usuario) {
        System.out.println(usuario.getNome_usuario());
        return UsuarioDAO.selectUsuario(usuario);
    }
}
