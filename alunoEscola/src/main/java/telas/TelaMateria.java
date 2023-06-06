package telas;

import alunoEscola.Materia;
import servico.MateriaServico;
import java.util.Scanner;

public class TelaMateria {
    public static void executar(Scanner scanner) {
        MateriaServico servico = new MateriaServico();
        System.out.println("Materias Cadastrados:");
        var cursos = servico.listarTodos();
        for (var curso : cursos) {
            System.out.println(curso.getId() + " - " + curso.getNome());
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
    private static void inserir(Scanner scanner, MateriaServico servico) {
        System.out.println("Nome:");
        var nome = scanner.nextLine();
        System.out.println("Carga:");
        var carga = Integer.parseInt(scanner.nextLine());
        System.out.println("Ementa:");
        var ementa = scanner.nextLine();
        var materia = new Materia();
        materia.setNome(nome);
        materia.setCarga(carga);
        materia.setEmenta(ementa);
        servico.inserir(materia);
    }
    private static void alterar(Scanner scanner, MateriaServico servico) {
        System.out.println("Digite o ID da Matéria que deseja alterar:");
        var id = Long.parseLong(scanner.nextLine());
        var materia = servico.encontrarMateria(id);
        if (materia != null){
            System.out.println("Nome: [" + materia.getNome() + "]");
            var nome = scanner.nextLine();
            System.out.println("Carga: [" + materia.getCarga() + "]");
            var carga = Integer.parseInt(scanner.nextLine());
            System.out.println("Ementa: [" + materia.getEmenta() + "]");
            var ementa = scanner.nextLine();
            materia.setNome(nome);
            materia.setCarga(carga);
            materia.setEmenta(ementa);
            servico.alterar(materia);
        }else {
            System.out.println("Materia nao encontrada.");
        }
    }
    private static void excluir(Scanner scanner, MateriaServico servico) {
        System.out.println("Digite o ID da Matéria que deseja Excluir:");
        var id = Long.parseLong(scanner.nextLine());
        servico.excluir(id);
    }
}
