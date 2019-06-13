/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.android.dao;

import br.android.model.Usuario;
import br.android.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author patri
 */
public class UsuarioDAO {
    public static boolean selectUsuario(Usuario usuario) {
        List<Usuario> usuarios = null;
        String HQL = "from Usuario u where login_usuario = :login and"
                            + " senha_usuario = :password";
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery(HQL).
                    setParameter("login", usuario.getNome_usuario()).setParameter("password", usuario.getSenha_usuario());
            usuarios = query.list();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return (usuarios.isEmpty());
    }
}
