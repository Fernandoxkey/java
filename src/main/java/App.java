import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args){
        var factory = Persistence.createEntityManagerFactory("hibernate-example");
        var em = factory.createEntityManager();

        var resultado = em.createQuery("SELECT p FROM Pessoa p WHERE p.nome = :nome", Pessoa.class)
                .setParameter("nome", "Milton")
                .getResultList();


        for (Pessoa p : resultado) {
            System.out.println(p.getId() + ": " + p.getNome());
        }

        em.close();
        factory.close();


    }
}
