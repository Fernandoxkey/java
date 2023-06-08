package servico;

import alunoEscola.Turma;

import java.util.List;

public class TurmaServico {
    public void inserir(Turma turma) {

        var em = HibernateUtil.criarEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(turma);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println(ex);
        } finally {
            em.close();
        }
    }
    public void alterar(Turma turma) {

        var em = HibernateUtil.criarEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(turma);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println(ex);
        } finally {
            em.close();
        }
    }
    public Turma encontrarTurma(long id) {
        try (var em = HibernateUtil.criarEntityManager()) {
            return em.find(Turma.class, id);
        }
    }
    public void excluir(long id){
        var em = HibernateUtil.criarEntityManager();
        try {
            em.getTransaction().begin();
            var turma = em.find(Turma.class, id);
            if (turma != null) {
                em.remove(turma);
            }
            em.getTransaction().commit();
        }catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println(ex);
        }finally {
            em.close();
        }
    }


    public List<Turma> listarTodos() {
        var em = HibernateUtil.criarEntityManager();

        return em.createQuery("from Turma e", Turma.class)
                .getResultList();
    }
}
