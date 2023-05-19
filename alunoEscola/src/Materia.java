import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class Materia {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String nome;
    private int carga;
    private String emente;

}
