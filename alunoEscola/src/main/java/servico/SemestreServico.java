package servico;

import alunoEscola.Semestre;

import java.util.List;

public class SemestreServico {
    public void inserir(Semestre semestre) {

        var em = HibernateUtil.criarEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(semestre);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println(ex);
        } finally {
            em.close();
        }
    }
    public void alterar(Semestre semestre) {

        var em = HibernateUtil.criarEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(semestre);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println(ex);
        } finally {
            em.close();
        }
    }
    public Semestre encontrarSemestre(long id) {
        try (var em = HibernateUtil.criarEntityManager()) {
            return em.find(Semestre.class, id);
        }
    }
    public void excluir(long id){
        var em = HibernateUtil.criarEntityManager();
        try {
            em.getTransaction().begin();
            var semestre = em.find(Semestre.class, id);
            if (semestre != null) {
                em.remove(semestre);
            }
            em.getTransaction().commit();
        }catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println(ex);
        }finally {
            em.close();
        }
    }


    public List<Semestre> listarTodos() {
        var em = HibernateUtil.criarEntityManager();

        return em.createQuery("from Semestre e", Semestre.class)
                .getResultList();
    }
}
