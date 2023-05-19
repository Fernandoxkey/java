import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Funcionario {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String nome;
    private int cpf;
    private int dataNascimento;
    private int telefone;
    private String email;
    private String endereco;
    private String municipio;
}
