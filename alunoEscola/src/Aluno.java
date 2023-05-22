import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Table(name = "alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, length = 200)
    private String nome;
    private int cpf;
    private int dataNascimento;
    private int telefone;
    private String email;
    private String endereco;
    private String municipio;




}
