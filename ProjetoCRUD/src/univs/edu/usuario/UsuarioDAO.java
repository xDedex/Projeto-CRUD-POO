/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package univs.edu.usuario;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import univs.edu.util.HibernateUtil;

/**
 *
 * @author LABORATORIO 01
 */
public class UsuarioDAO {
 private Session sessao;
 private Transaction transacao;
 
 
 public void salvar(Usuario usuario){
     sessao = HibernateUtil.getSessionFactory().openSession();
     transacao = sessao.beginTransaction();
  
     sessao.save(usuario);
     
       
     transacao.commit();
     sessao.close();
 }
 
 public void excluir (Usuario usuario){
     sessao = HibernateUtil.getSessionFactory().openSession();
     transacao = sessao.beginTransaction();
     sessao.delete(usuario);
     transacao.commit();
     sessao.close();
 }
 
  public void editar (Usuario usuario){
     sessao = HibernateUtil.getSessionFactory().openSession();
     transacao = sessao.beginTransaction();
     sessao.update(usuario);
     transacao.commit();
     sessao.close();
 }
  
  public Usuario autenticarUsuario(String login, String senha){
      sessao = HibernateUtil.getSessionFactory().openSession();
      transacao = sessao.beginTransaction();
      Usuario usuario = (Usuario) sessao.createCriteria(Usuario.class).add(Restrictions.eq("login", login)).add(Restrictions.eq("senha", senha)).uniqueResult();
      sessao.close();
      return usuario != null ? usuario : null ;
  }
  
  public List<Usuario> listarUsuarios(){
      sessao = HibernateUtil.getSessionFactory().openSession();
      transacao = sessao.beginTransaction();
      List<Usuario> usuario = sessao.createCriteria(Usuario.class).list();
      sessao.close();
      return usuario;
    }
  
  public List<Usuario> pesquisar(String campo, String valor){
        sessao = HibernateUtil.getSessionFactory().openSession();
      transacao = sessao.beginTransaction();
      List<Usuario> usuario = sessao.createCriteria(Usuario.class).add(Restrictions.ilike(campo, "%"+valor+"%")).list();
      sessao.close();
      return usuario;
  }

    public Usuario pesquisar(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

   
