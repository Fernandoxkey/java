import java.util.Scanner;

public class Login {
    private static final String LOGIN_PADRAO = "usuario";
    private static final String SENHA_PADRAO = "senha123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema de login!");
        System.out.print("Login: ");
        String login = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        if (validarLogin(login, senha)) {
            System.out.println("Login realizado com sucesso!");
            // Continuar com a lógica do sistema após o login bem-sucedido
        } else {
            System.out.println("Login ou senha inválidos.");
            String opcao = scanner.nextLine();
        }
    }

    private static boolean validarLogin(String login, String senha) {
        return login.equals(LOGIN_PADRAO) && senha.equals(SENHA_PADRAO);
    }


}