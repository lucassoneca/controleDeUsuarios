import java.util.ArrayList;
import java.util.Scanner;

public class UsuariosService implements UsuarioServiceInterface {
    Scanner cadastrar = new Scanner(System.in);
    ArrayList<Usuarios> usuarios = new ArrayList<>();

    //cadastrar usuario
    @Override
    public void cadastrarUsuario(String nome, String email) {
        System.out.println("Digite o nome do usuário que deseja cadastrar: ");
        nome = cadastrar.nextLine();
        System.out.println("Digete o email do usuário: ");
        email = cadastrar.nextLine();

        Usuarios novoUsuario = new Usuarios(nome, email);
        usuarios.add(novoUsuario);
        System.out.println("Usuário cadastrado com sucesso! ID gerado");
        System.out.println("ID: " + novoUsuario.getId());
        System.out.println("Nome: " + novoUsuario.getNome());
        System.out.println("Email: " + novoUsuario.getEmail());
    }

    //listar usuarios
    @Override
    public void listarUsuarios() {
        for (Usuarios i : usuarios) {
            System.out.println(i);
        }
        if (usuarios.isEmpty()) {
            System.out.println("A lista está vazia");
        }
    }

    //busca por id
    @Override
    public void buscarPorId(int id) {
        System.out.println("Digite o id do usuário que você deseja buscar: ");
        int idbuscar = cadastrar.nextInt();
        cadastrar.nextLine();
        if (usuarios.isEmpty()) {
            System.out.println("Esse ID não existe na lista");
        } else {
            System.out.println(usuarios.get(idbuscar));
        }
    }

    //atualizar usuario
    @Override
    public void atualizarUsuario(int id, String novoNome, String novoEmail) {
        System.out.println("Digite o id do usuário que você deseja atualizar os dados: ");
        int buscarID = cadastrar.nextInt();
        cadastrar.nextLine();
        System.out.println(usuarios.get(buscarID));

        System.out.println("Deseja atualizar os dados de: " + usuarios.get(buscarID) + "?");
        System.out.println("digite 1 para Sim");
        System.out.println("digite 2 para Não");
        int escolha = cadastrar.nextInt();
        cadastrar.nextLine();
        if (escolha == 1) {
            System.out.println("Digite o novo nome: ");
            String nome = cadastrar.nextLine();
            System.out.println("Digite o novo email: ");
            String email = cadastrar.nextLine();

            System.out.println("Novo nome e email cadastrados: ");
            System.out.println("Nome: " + nome);
            System.out.println("Email: " + email);
            Usuarios atualizado = new Usuarios(nome, email);
            usuarios.set(buscarID, atualizado);
        } else {
            System.out.println("Opção cancelada.");
        }
   }

    //remover usuario
    @Override
    public void removerUsuario(int id) {
        System.out.println("Digite o id de usuário que você deseja remover: ");
        int removerUsuario = cadastrar.nextInt();
        cadastrar.nextLine();
        id = removerUsuario;
        if (usuarios.isEmpty() == false ) {
            System.out.println("Usuário " + usuarios.get(id) + " removido com sucesso!");
            usuarios.remove(id);
        } else {
            System.out.println("Esse ID não existe na lista");
        }
    }

    @Override
    public String toString() {
        return "Usuarios: " + usuarios;
    }
}
