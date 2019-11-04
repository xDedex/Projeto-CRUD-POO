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
  
  public Usuario pesquisar(int id){
      sessao = HibernateUtil.getSessionFactory().openSession();
      transacao = sessao.beginTransaction();
      Usuario usuario = (Usuario) sessao.createCriteria(Usuario.class).add(Restrictions.eq("id", id)).uniqueResult();
      sessao.close();
      return usuario;
  }
  
  public List<Usuario> listarUsuarios(){
      sessao = HibernateUtil.getSessionFactory().openSession();
      transacao = sessao.beginTransaction();
      List<Usuario> usuario = sessao.createCriteria(Usuario.class).list();
      sessao.close();
      return usuario;
  }

}
