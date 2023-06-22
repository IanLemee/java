import java.sql.Connection;
import java.sql.DriverManager;
 
public class ConexaoDb {
 
 //objeto estático para guardar uma instância da conexão
 public static ConexaoDb conexao = null;
 
 //método estático para criar uma instância do objeto

 public static ConexaoDb getInstance(){
   try{
//verifica se ja existe uma conexão
     if(conexao==null || conexao.sqlConnection.isClosed()){
       conexao = new ConexaoDb(); //cria uma nova conexão caso não exista uma
       
     }
   }catch(Exception e){
     e.printStackTrace();
   }
   return conexao;
 }
 
 //cria um objeto Connection chamado sqlConnection
 public Connection sqlConnection;
 
 //construtor para inicializar a conexão
 private ConexaoDb()
 {
   try{
 
//cria uma nova instancia utilizando o driver que foi adicionado
     //à biblioteca atraves do arquivo .jar
     Class.forName("com.mysql.jdbc.Driver").newInstance();
 
//define a string de conexão com o banco de dados MySQL.
     //Lembrando que meuUsuario e minhaSenha devem ser substituídos
     //pelo usuário e senha utilizados para conectar com o banco de dados.
     String textoConexao = "jdbc:mysql://192.168.10.43/pessoa?user=root&amp;password=admin1";
 
//adquire a conexão
     sqlConnection = DriverManager.getConnection(textoConexao);
}catch(Exception e){
       e.printStackTrace();
    }
  }
}
    

