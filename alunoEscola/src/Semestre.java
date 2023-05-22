import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Table(name = "semestres")
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String descricao;
    private int anoLetivo;

}
