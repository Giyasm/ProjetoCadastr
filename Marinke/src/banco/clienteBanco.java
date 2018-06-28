/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import client.Cliente;

/**
 * Classe criada para
 * @since 27/06/2018 as 17:19:47
 */
public class clienteBanco extends Conexao {
    
      public boolean cadastra(Cliente c) {

        PreparedStatement zp;
        Connection conexao = getConexao();

        String sql = "INSERT INTO cliente (nome, credito)VALUES(?,?)";
        StringBuffer string = new StringBuffer(sql);
        try {
            zp = conexao.prepareStatement(string.toString());
            zp.setString(1, c.getNome());
            zp.setInt(2, c.getCredito());
            zp.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conexao.close();

            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }
      
      public boolean busca(Cliente c) {

        PreparedStatement zp;
        ResultSet rs = null;
        Connection conexao = getConexao();

        String sql = "SELECT nome, credito FROM cliente WHERE codigo=?";
        StringBuffer string = new StringBuffer(sql);

        try {
            zp = conexao.prepareStatement(string.toString());
            zp.setInt(1, c.getCodigo());
            rs = zp.executeQuery();

            if (rs.next()) {

                c.setNome(rs.getString("nome"));
                c.setCredito(rs.getInt("credito"));
                return true;
            }

            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conexao.close();

            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }
      
      public boolean apaga(Cliente c) {
            
        PreparedStatement zp;
        Connection conexao = getConexao();
        String sql = "DELETE FROM cliente WHERE codigo=?";
        StringBuffer sb = new StringBuffer(sql);
        
        try {
            zp = conexao.prepareStatement(sb.toString());
            zp.setInt(1, c.getCodigo());
            zp.execute();

            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conexao.close();

            } catch (SQLException e) {
                System.err.println(e);
            }
    }
    }
      public List<Cliente> Mostratudo() throws SQLException {

        Connection conexao = getConexao();
         PreparedStatement stmt = null;
        ResultSet zp = null;

        List<Cliente> cli2 = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement("SELECT * FROM cliente");
            zp = stmt.executeQuery();

            while (zp.next()) {

                Cliente cli = new Cliente();
                
                cli.setCodigo(zp.getInt("codigo"));
                cli.setNome(zp.getString("nome"));
                cli.setCredito(zp.getInt("credito"));
                cli2.add(cli);
            }

        } catch (SQLException ex) {
            Logger.getLogger(clienteBanco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.close();
        }

        return cli2;

    }
}

