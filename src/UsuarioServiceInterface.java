public interface UsuarioServiceInterface {

    //Cria um novo usuário, gera o ID automaticamente e adiciona na lista.
    void cadastrarUsuario(String nome, String email);

    //Retorna ou exibe todos os usuários cadastrados.
    void listarUsuarios();

    //Localiza um usuário específico dentro da lista pelo ID.
    void buscarPorId(int id);

    //Localiza o usuário pelo ID e atualiza os dados.
    void atualizarUsuario(int id, String novoNome, String novoEmail);

    //Remove o usuário da lista com base no ID.
    void removerUsuario(int id);

}
