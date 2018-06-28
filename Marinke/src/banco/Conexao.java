/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe criada para
 * @since 27/06/2018 as 17:20:24
 */
public class Conexao {
    
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/cadastrocli";
    private Connection conexao = null;
    
    public Connection getConexao(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexao = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
            
            }
        catch(SQLException e){
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return conexao;
        
    }
   }


