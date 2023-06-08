package telas;

import alunoEscola.Curso;
import servico.CursoServico;

import java.util.Scanner;

public class TelaCurso {
    public static void executar(Scanner scanner) {
        CursoServico servico = new CursoServico();
        System.out.println("Cursos Cadastrados:");
        var cursos = servico.listarTodos();
        for (var curso : cursos) {
            System.out.println(curso.getId() + " - " + curso.getNome());
        }
        System.out.println("Selecione uma Opção:");
        System.out.println("1 - Inserir");
        System.out.println("2 - Alterar");
        System.out.println("3 - Excluir");
        System.out.println("0 - Voltar ao Menu Inicial");
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
            case "0":
                break;
            default:
                System.out.println("Opcao Invalida!");
        }

    }
    private static void inserir(Scanner scanner, CursoServico servico) {
        System.out.println("Nome:");
        var nome = scanner.nextLine();
        System.out.println("Descricao:");
        var descricao = scanner.nextLine();
        var curso = new Curso();
        curso.setNome(nome);
        curso.setDescricao(descricao);
        servico.inserir(curso);
    }
    private static void alterar(Scanner scanner, CursoServico servico) {
        System.out.println("Digite o ID do Curso que deseja alterar:");
        var id = Long.parseLong(scanner.nextLine());
        var curso = servico.encontrarCurso(id);
        if (curso != null) {
            System.out.println("Nome:[" + curso.getNome() + "]");
            var nome = scanner.nextLine();
            System.out.println("Descrição: [" + curso.getDescricao() + "]");
            var descricao = scanner.nextLine();
            curso.setNome(nome);
            curso.setDescricao(descricao);
            servico.alterar(curso);
        }
    }
    private static void excluir(Scanner scanner, CursoServico servico) {
        System.out.println("Digite o ID do Curso que deseja Excluir:");
        var id = Long.parseLong(scanner.nextLine());
        servico.excluir(id);
    }
    }



