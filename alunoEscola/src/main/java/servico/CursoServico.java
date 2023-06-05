package servico;

import alunoEscola.Curso;

import java.util.List;

public class CursoServico {
    public void inserir(Curso curso) {

        var em = HibernateUtil.criarEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println(ex);
        } finally {
            em.close();
        }
    }
    public void alterar(Curso curso) {

        var em = HibernateUtil.criarEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println(ex);
        } finally {
            em.close();
        }
    }
    public Curso encontrarCurso(long id) {
        try (var em = HibernateUtil.criarEntityManager()) {
            return em.find(Curso.class, id);
        }
    }
    public void excluir(long id){
        var em = HibernateUtil.criarEntityManager();
        try {
            em.getTransaction().begin();
            var curso = em.find(Curso.class, id);
            if (curso != null) {
                em.remove(curso);
            }
            em.getTransaction().commit();
        }catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println(ex);
        }finally {
            em.close();
        }
    }


    public List<Curso> listarTodos() {
        var em = HibernateUtil.criarEntityManager();

        return em.createQuery("from Curso e", Curso.class)
                .getResultList();
    }
}

