package telas;

import alunoEscola.Semestre;
import servico.SemestreServico;
import java.util.Scanner;

public class TelaSemestre {
    public static void executar(Scanner scanner) {
        SemestreServico servico = new SemestreServico();
        System.out.println("Cursos Cadastrados:");
        var cursos = servico.listarTodos();
        for (var curso : cursos) {
            System.out.println(curso.getId() + " - " + curso.getDescricao());
        }
        System.out.println("Selecione uma Opção:");
        System.out.println("1 - Inserir");
        System.out.println("2 - Alterar");
        System.out.println("3 - Excluir");
        var opcao = scanner.nextLine();
        switch (opcao) {
            case "1":
                inserir(scanner, servico);
                break;
            case "2":
                alterar(scanner, servico);
                break;
            case "3":
                excluir(scanner, servico);
                break;
            default:
                System.out.println("Opcao Invalida!");
        }

    }
    private static void inserir(Scanner scanner, SemestreServico servico) {
        System.out.println("Descrição:");
        var descricao = scanner.nextLine();
        System.out.println("Ano Letivo:");
        var anoLetivo = Integer.parseInt(scanner.nextLine());
        var semestre = new Semestre();
        semestre.setDescricao(descricao);
        semestre.setAnoLetivo(anoLetivo);
        servico.inserir(semestre);
    }
    private static void alterar(Scanner scanner, SemestreServico servico) {
        System.out.println("Digite o ID do Semestre que deseja alterar:");
        var id = Long.parseLong(scanner.nextLine());
        var semestre = servico.encontrarSemestre(id);
        if (semestre != null){
        System.out.println("Descrição:");
        var descricao = scanner.nextLine();
        System.out.println("Ano Letivo:");
        var anoLetivo = Integer.parseInt(scanner.nextLine());
        semestre.setDescricao(descricao);
        semestre.setAnoLetivo(anoLetivo);
        servico.alterar(semestre);
    }
    }
    private static void excluir(Scanner scanner, SemestreServico servico) {
        System.out.println("Digite o ID do Semestre que deseja Excluir:");
        var id = Long.parseLong(scanner.nextLine());
        servico.excluir(id);
    }
}
