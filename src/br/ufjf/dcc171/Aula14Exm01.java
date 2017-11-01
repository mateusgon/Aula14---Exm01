package br.ufjf.dcc171;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Aula14Exm01 {

    public static void main(String[] args) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("Driver carregado com sucesso!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Aula14Exm01.class.getName()).log(Level.SEVERE, "Diver de banco não disponível");
            Logger.getLogger(Aula14Exm01.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        }
        String driverURL = "jdbc:derby://localhost:1527/2017-dcc171";
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(driverURL, "usuario", "senha");
            System.out.println("Conexão aberta com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(Aula14Exm01.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao abrir a conexão");
        }
        
        
        
        Statement operacao;
        try {
            operacao = conexao.createStatement();
            /*
            operacao.executeUpdate("CREATE TABLE produto("
                    +"nome VARCHAR (80),"
                    +"qtd INTEGER,"
                    +"atualizado TIMESTAMP"
                    + ")");
                    */
            operacao.executeUpdate("Insert into produto (nome, qtd, atualizado) values ('Camisa do Timao', 100, CURRENT_TIMESTAMP)");
        } catch (SQLException ex) {
            Logger.getLogger(Aula14Exm01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
