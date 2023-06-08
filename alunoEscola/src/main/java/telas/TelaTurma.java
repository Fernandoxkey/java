package telas;

import alunoEscola.Turma;
import servico.TurmaServico;

import java.util.Scanner;

public class TelaTurma {
    public static void executar(Scanner scanner) {
        TurmaServico servico = new TurmaServico();
        System.out.println("Turmas Cadastrados:");
        var turmas = servico.listarTodos();
        for (var turma : turmas) {
            System.out.println(turma.getId() + " - " + turma.getPeriodo());
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
    private static void inserir(Scanner scanner, TurmaServico servico) {
        System.out.println("Periodo:");
        var periodo = scanner.nextLine();
        System.out.println("Data de Inicio:");
        var dataInicio= Integer.parseInt(scanner.nextLine());
        var turma = new Turma();
        turma.setPeriodo(periodo);
        turma.setDataInicio(dataInicio);
        servico.inserir(turma);
    }
    private static void alterar(Scanner scanner, TurmaServico servico) {
        System.out.println("Digite o ID da Turma que deseja alterar:");
        var id = Long.parseLong(scanner.nextLine());
        var turma = servico.encontrarTurma(id);
        if (turma != null) {
            System.out.println("Periodo: [" + turma.getPeriodo() + "]");
            var periodo = scanner.nextLine();
            System.out.println("Data de Inicio: [" + turma.getDataInicio() + "]");
            var dataInicio = Integer.parseInt(scanner.nextLine());
            turma.setPeriodo(periodo);
            turma.setDataInicio(dataInicio);
            servico.alterar(turma);
        } else {
            System.out.println("Turma nao encontrada.");
        }
    }

    private static void excluir(Scanner scanner, TurmaServico servico) {
            System.out.println("Digite o ID da Turma que deseja Excluir:");
            var id = Long.parseLong(scanner.nextLine());
            servico.excluir(id);
    }
}
