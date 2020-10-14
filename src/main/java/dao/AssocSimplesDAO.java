/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.AssocSimples;
import util.ConexaoDB;

/**
 *
 * @author GENATCHI
 */
public class AssocSimplesDAO {
     String INSERT = "INSERT INTO tb_assoc_simples(idassoc_simples, nome_assoc_simples, bi_simples, tel_assoc_simples, data_nasc_assoc_simples, data_cadast_assoc_simples, cargo_assoc_simples, dat_cargo) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE = "UPDATE tb_assoc_simples SET nome_assoc_simples = ?, bi_simples = ?, data_nascimento = ?, tel_assoc_simples = ?, data_nasc_assoc_simples = ?, data_cad_assoc_simples = ?, cargo_assoc_simples = ?, dat_cargo = ? WHERE idassoc_simples = ?";
    String DELETE = "DELETE FROM  tb_assoc_simples WHERE idassoc_simples = ?";
    String SELECT_ALL = "SELECT idassoc_simples, nome_assoc_simples, bi_simples, tel_assoc_simples, data_nasc_assoc_simples, data_cadast_assoc_simples, cargo_assoc_simples, dat_cargo FROM  tb_assoc_simples";
    String SELECT_BY_NOME = "SELECT idassoc_simples, nome_assoc_simples, bi_assoc_simples, tel_assoc_simples, data_nasc_assoc_simples, data_cadast_assoc_simples, cargo_assoc_simples, dat_cargo FROM  tb_assoc_simples a WHERE a.nome_assoc_simples LIKE ? ";
    String SELECT_BY_BI = "SELECT idassoc_simples, nome_assoc_simples, bi_simples, tel_assoc_simples, data_nasc_assoc_simples, data_cadast_assoc_simples, cargo_assoc_simples, dat_cargo FROM  tb_assoc_simples a WHERE a.nome_assoc_simples = ? AND a.bi_simples = ?";
    String SELECT_BY_DATA_NASCIMENTO = "SELECT idassoc_simples, nome_assoc_simples, bi_simples, tel_assoc_simples, data_nasc_assoc_simples, data_cadast_assoc_simples, cargo_assoc_simples, dat_cargo FROM tb_assoc_simples a WHERE a.data_nasc_assoc_simples BETWEEN ? AND ?";

    public void save(AssocSimples a) {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = ConexaoDB.ligarBD();
            ps = conn.prepareStatement(INSERT);
            
            ps.setInt(1, a.getIdAssociadoS());
            ps.setString(2, a.getNome());
            ps.setString(3, a.getNumBi());
            ps.setString(4, a.getTelefone());
            ps.setDate(5, new java.sql.Date(a.getDatNasc().getTime()));
            ps.setDate(6, new java.sql.Date(a.getDatCastro().getTime()));
            ps.setString(7, a.getCargo());
            ps.setDate(8, new java.sql.Date(a.getDatCargo().getTime()));
            
            ps.executeUpdate();
        } catch (SQLException e) {

            System.err.println("Erro ao inserir dados:"
                    + " AssocSimplesDAO:save" + e.getLocalizedMessage());
        }

    }

    public void edit(AssocSimples a) {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = ConexaoDB.ligarBD();
            ps = conn.prepareStatement(UPDATE);
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, a.getNome());
            ps.setString(2, a.getNumBi());
            ps.setString(3, a.getTelefone());
            ps.setDate(4, new java.sql.Date(a.getDatNasc().getTime()));
            ps.setDate(5, new java.sql.Date(a.getDatCastro().getTime()));
            ps.setString(6, a.getCargo());
            ps.setDate(7, new java.sql.Date(a.getDatCargo().getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {

            System.err.println("Erro ao actualizar dados:"
                    + " DepartamentoDAO:edit" + e.getLocalizedMessage());
        }

    }

    public void delete(AssocSimples a) {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = ConexaoDB.ligarBD();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, a.getIdAssociadoS());
            ps.executeUpdate();
        } catch (SQLException e) {

            System.err.println("Erro ao eliminar dados:"
                    + " AssocSimplesDAO:delete" + e.getLocalizedMessage());
        }

    }

    public List<AssocSimples> listaTodosAssocSimples () {
        List<AssocSimples> lista = new ArrayList<>();
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = ConexaoDB.ligarBD();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                /*nome, sobrenome, data_nascimento, 
                rua, casa, bairro, sexo, id_municipio*/
                AssocSimples a = new AssocSimples();
                a.setIdAssociadoS(rs.getInt(1));
                a.setNome(rs.getString("nome_assoc_simples"));
                a.setNumBi(rs.getString("bi_simples"));
                a.setTelefone(rs.getString("tel_assoc_simples"));
                 a.setDatNasc(rs.getDate("data_nasc_assoc_simples"));
                 a.setDatCastro(rs.getDate("data_cadast_assoc_simples"));
                 a.setCargo(rs.getString("cargo_assoc_simples"));
                 a.setDatCargo(rs.getDate("dat_cargo"));
                 
              

                lista.add(a);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados:"
                    + "AssocSimplesDAO:"
                    + "listaTodosAssocSimples" + ex.getLocalizedMessage());
        }

        return lista;
    }

    
}
