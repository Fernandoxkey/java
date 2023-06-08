package servico;

import alunoEscola.Funcionario;

import java.util.List;

public class FuncionServico {
    public void inserir(Funcionario funcionario) {

        var em = HibernateUtil.criarEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(funcionario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println(ex);
        } finally {
            em.close();
        }
    }
    public void alterar(Funcionario funcionario) {

        var em = HibernateUtil.criarEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(funcionario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println(ex);
        } finally {
            em.close();
        }
    }
    public Funcionario encontrarFuncionario(long id) {
        try (var em = HibernateUtil.criarEntityManager()) {
            return em.find(Funcionario.class, id);
        }
    }

    public void excluir(long id){
        var em = HibernateUtil.criarEntityManager();
        try {
            em.getTransaction().begin();
            var funcionario = em.find(Funcionario.class, id);
            if (funcionario != null) {
                em.remove(funcionario);
            }
            em.getTransaction().commit();
        }catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println(ex);
        }finally {
            em.close();
        }
    }


    public List<Funcionario> listarTodos() {
        var em = HibernateUtil.criarEntityManager();

        return em.createQuery("from Funcionario e", Funcionario.class)
                .getResultList();
    }
}

