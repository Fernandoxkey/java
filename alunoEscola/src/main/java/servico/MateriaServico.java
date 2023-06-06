package servico;

import alunoEscola.Materia;

import java.util.List;

public class MateriaServico {

    public void inserir(Materia materia) {
        var em = HibernateUtil.criarEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(materia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println(ex);
        } finally {
            em.close();
        }
    }
    public void alterar(Materia materia) {

        var em = HibernateUtil.criarEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(materia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println(ex);
        } finally {
            em.close();
        }
    }
    public Materia encontrarMateria(long id) {
        try (var em = HibernateUtil.criarEntityManager()) {
            return em.find(Materia.class, id);
        }
    }
    public void excluir(long id){
        var em = HibernateUtil.criarEntityManager();
        try {
            em.getTransaction().begin();
            var materia = em.find(Materia.class, id);
            if (materia != null) {
                em.remove(materia);
            }
            em.getTransaction().commit();
        }catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println(ex);
        }finally {
            em.close();
        }
    }


    public List<Materia> listarTodos() {
        var em = HibernateUtil.criarEntityManager();
        return em.createQuery("from Materia e", Materia.class)
                .getResultList();
    }
}
