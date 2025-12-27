import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner digitacao = new Scanner(System.in);
        int opcao = 0;

        UsuariosService usuariosService = new UsuariosService();

        while (opcao != 6) {
            System.out.println("---------- BANCO 1DE USUÁRIOS ----------");
            System.out.println("Digite 1 para cadastrar um novo usuário");
            System.out.println("Digite 2 para atualizar um usuário existente");
            System.out.println("Digite 3 para listar todos os usuários existentes");
            System.out.println("Digite 4 para buscar por um usuário existente");
            System.out.println("Digite 5 para remover um usuário");
            System.out.println("Digite 6 para finalizar o programa");
            System.out.println("---------------------------------------");

            opcao = digitacao.nextInt();

            switch (opcao) {
                case 1:
                    usuariosService.cadastrarUsuario("", "");
                    break;
                case 2:
                    usuariosService.atualizarUsuario(0,"", "");
                    break;
                case 3:
                    usuariosService.listarUsuarios();
                    break;
                case 4:
                    usuariosService.buscarPorId(0);
                    break;
                case 5:
                    usuariosService.removerUsuario(0);
                    break;
                case 6:
                    System.out.println("Finalizando o programa...");
                    break;
            }
        }

    }
}
