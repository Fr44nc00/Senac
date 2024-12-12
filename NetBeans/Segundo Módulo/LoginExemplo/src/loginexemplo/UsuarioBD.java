package loginexemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioBD {
    public static Usuario validarUsuarioSeguro(Usuario usuario) {
        // Criando consulta parametrizada
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
        Usuario usuarioEncontrado = null;

        try {
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                    + "login_exemplo", "root", "simone04");
            PreparedStatement statement = conexao.prepareStatement(sql);

            // Atribuindo os valores na consulta
            statement.setString(1, usuario.getLogin());
            statement.setString(2, usuario.getSenha());
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                usuarioEncontrado = new Usuario();
                usuarioEncontrado.setId(rs.getInt("id"));
                usuarioEncontrado.setNome(rs.getString("nome"));
                usuarioEncontrado.setLogin(rs.getString("login"));
                usuarioEncontrado.setSenha(rs.getString("senha"));
                usuarioEncontrado.setTipo(rs.getString("tipo"));
            }
        } catch (SQLException ex) {
            System.out.println("Sintaxe de comando invalida");
        }

        return usuarioEncontrado;
    }


    // MÉTODO INSEGURO!!!
    public static Usuario validarUsuarioInseguro(Usuario usuario) {
        String sql = "SELECT * FROM usuario WHERE login = "+ usuario.getLogin() +" AND senha = " + usuario.getSenha();
        Usuario usuarioEncontrado = null;

        try {
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                    + "login_exemplo", "root", "simone04");
            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                usuarioEncontrado = new Usuario();
                usuarioEncontrado.setId(rs.getInt("id"));
                usuarioEncontrado.setNome(rs.getString("nome"));
                usuarioEncontrado.setLogin(rs.getString("login"));
                usuarioEncontrado.setSenha(rs.getString("senha"));
                usuarioEncontrado.setTipo(rs.getString("tipo"));
            }
        } catch (SQLException ex) {
            System.out.println("Sintaxe de comando invalida");
        }

        return usuarioEncontrado;
    }    
}

//[PARA JPA]
//String jql = "SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha";
//Executar consulta e retornar resultados mapeados (omitido)

//[INJECTION POR BOOLEAN]
//Nesse cenário, a SQL injection é explorada por meio da lógica booleana true (verdadeiro)
//ou false (falso). A forma mais simples para realizá-la é adicionando um OR 1=1 na
//verificação WHERE da consulta do banco de dados. A comparação “1=1” é sempre verdadeira.
//Se o operador lógico OR for combinado na instrução SQL, significa que basta uma condição
//ser verdadeira para a consulta ser executada.
//
//Após isso, execute o projeto e preencha o formulário de login com os seguintes dados:
//
//Login: 1 OR 1=1
//Senha: 1 OR 1=1
//Observe a seguir a consulta que será executada no banco de dados e o GIF, para compreender
//melhor:
//
//SELECT * FROM usuario WHERE login = 1 OR 1=1 AND senha = 1 OR 1=1
//
//Perceba que, independentemente de a tabela ter um registro de id com valor 1 ou não, a
//consulta é realizada com sucesso por conta do OR 1=1.
//
//Essa exploração costuma ser o ponto de início de um ataque de SQL injection. Se
//bem-sucedido, o invasor pode ter acesso a outras áreas do sistema, nas quais poderá
//realizar outras tentativas de manipulação de dados. Também é comum que essa injeção de
//código seja acompanhada de comandos de manipulação de dados (como os comandos DELETE e
//DROP, por exemplo), os quais serão executados logo em seguida.

//[INJECTION POR TEMPO]
//Em injeções SQL baseadas em tempo, funções especiais são injetadas na consulta e podem
//pausar a execução por um período de tempo específico. Esse ataque diminui a velocidade
//do servidor de banco de dados e pode derrubar sistemas afetando o desempenho
//desse servidor.
//
//Para essa prática, execute o projeto e preencha o formulário de login com os seguintes
//dados:
//
//Login: 1 + SLEEP(5)
//Senha: 1 + SLEEP(5)
//Confira a seguir a consulta que será executada no banco de dados e o GIF, para
//compreender melhor:
//
//SELECT * FROM usuario WHERE login=1 + SLEEP(5) AND senha=1 + SLEEP(5)
//
//Perceba que agora, antes de executar a consulta SQL, o sistema ficará “congelado”. Isso
//ocorre porque a consulta só será executada depois de se passarem dez segundos (cinco
//segundos do campo “login” e cinco segundos do campo “senha”), nos quais o sistema ficará
//aguardando uma resposta do servidor SQL.

//[INJECTION POR ERRO]
//Nessa variação, o invasor tenta obter informações com um código de erro e uma mensagem do
//banco de dados. O invasor injeta SQL que está sintaticamente incorreta para que o
//servidor de banco de dados retorne o código de erro e as mensagens que podem ser usadas
//para obter informações do banco de dados e do sistema.
//
//Um exemplo simples em que esse tipo de situação pode ocorrer é quando se apresenta para o
//usuário explicitamente o conteúdo das exceções que são geradas na aplicação. Observe a
//imagem:
//
//Figura 3 – Aplicação "Login Exemplo"
//
//Fonte: Senac EAD (2022)
//
//Para reproduzir esse exemplo, execute o projeto e clique no botão Entrar sem preencher
//nenhum campo. Uma nova janela se abrirá com esta mensagem:
//
//Erro: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the
//manual that corresponds to your MariaDB server version for the right syntax to use near
//'' at line 1
//
//Nesse exemplo, as informações podem parecer inofensivas, mas, em uma situação real, uma
//pessoa mal-intencionada já saberia a linguagem de programação utilizada para construir o
//sistema (Java), o banco de dados utilizado (que, nesse exemplo, seria MariaDB) e em qual
//linha da instrução SQL ocorre a primeira manipulação de dados (nesse caso, na linha 1).
//Essas são informações suficientes para um invasor aplicar outras técnicas de exploração
//de vulnerabilidades.
