package servico;

import alunoEscola.Aluno;

import java.util.List;

public class AlunoServico {
    public void inserir(Aluno aluno) {

        var em = HibernateUtil.criarEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println(ex);
        } finally {
            em.close();
        }
    }
    public void alterar(Aluno aluno) {

        var em = HibernateUtil.criarEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(aluno);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println(ex);
        } finally {
            em.close();
        }
    }
    public Aluno encontrarAluno(long id) {
        try (var em = HibernateUtil.criarEntityManager()) {
            return em.find(Aluno.class, id);
        }
    }

    public void excluir(long id){
        var em = HibernateUtil.criarEntityManager();
        try {
            em.getTransaction().begin();
            var aluno = em.find(Aluno.class, id);
            if (aluno != null) {
                em.remove(aluno);
            }
            em.getTransaction().commit();
        }catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println(ex);
        }finally {
            em.close();
        }
    }


    public List<Aluno> listarTodos() {
        var em = HibernateUtil.criarEntityManager();

        return em.createQuery("from Aluno e", Aluno.class)
                .getResultList();
    }
}