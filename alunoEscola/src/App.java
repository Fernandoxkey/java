import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        var factory = Persistence.createEntityManagerFactory("hibernate-escola");
        var em = factory.createEntityManager();



        em.close();
        factory.close();

    }
}