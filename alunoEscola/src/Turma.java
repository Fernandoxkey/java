import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Turma {
    @Id
    @GeneratedValue
    private long id;
    private String periodo;
    private int dataInicio;


}
