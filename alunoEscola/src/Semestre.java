import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Semestre {
    @Id
    @GeneratedValue
    private long id;
    private String descricao;
    private int anoLetivo;

}
