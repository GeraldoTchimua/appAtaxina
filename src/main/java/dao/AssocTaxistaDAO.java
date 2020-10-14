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
import modelo.AssocTaxist;
import util.ConexaoDB;

/**
 *
 * @author GENATCHI
 */
public class AssocTaxistaDAO {
    
    String INSERT = "INSERT INTO tb_assoc_taxist(idassoc_taxist, nome_taxist, bi_taxist, carta_taxist, tel_taxist, data_nasc_taxist, data_cadast_taxist, cargo_taxist, dat_cargo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE = "UPDATE tb_assoc_taxist SET nome_assoc_taxist = ?, bi_taxist = ?,carta_taxist = ?, tel_assoc_simples = ?, data_nasc_taxist = ?, data_cadast_taxist = ?, cargo_assoc_taxist = ?, dat_cargo = ? WHERE idassoc_taxist = ?";
    String DELETE = "DELETE FROM  tb_assoc_taxist WHERE idassoc_taxist = ?";

    String SELECT_ALL = "SELECT idassoc_taxist, nome_taxist, bi_taxist, carta_taxist, tel_taxist, data_nasc_taxist, data_cadast_taxist, cargo_taxist, dat_cargo FROM  tb_assoc_taxist";
    String SELECT_BY_NOME = "SELECT idassoc_simples, nome_assoc_simples, bi_assoc_simples, tel_assoc_simples, data_nasc_assoc_simples, data_cadast_assoc_simples, cargo_assoc_simples, dat_cargo FROM  tb_assoc_taxist a WHERE a.nome_assoc_simples LIKE ? ";
    String SELECT_BY_BI = "SELECT idassoc_simples, nome_assoc_simples, bi_simples, tel_assoc_simples, data_nasc_assoc_simples, data_cadast_assoc_simples, cargo_assoc_simples, dat_cargo FROM  tb_assoc_taxist a WHERE a.nome_assoc_simples = ? AND a.bi_simples = ?";
    String SELECT_BY_DATA_NASCIMENTO = "SELECT idassoc_simples, nome_assoc_simples, bi_simples, tel_assoc_simples, data_nasc_assoc_simples, data_cadast_assoc_simples, cargo_assoc_simples, dat_cargo FROM tb_assoc_taxist a WHERE a.data_nasc_assoc_simples BETWEEN ? AND ?";

    public void save(AssocTaxist a) {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = ConexaoDB.ligarBD();
            ps = conn.prepareStatement(INSERT);

            ps.setInt(1, a.getIdAssociadoT());
            ps.setString(2, a.getNome());
            ps.setString(3, a.getNumBi());
            ps.setString(4, a.getCartaCond());
            ps.setString(5, a.getTelefone());
            ps.setDate(6, new java.sql.Date(a.getDatNasc().getTime()));
            ps.setDate(7, new java.sql.Date(a.getDatCastro().getTime()));
            ps.setString(8, a.getCargo());
            ps.setDate(9, new java.sql.Date(a.getDatCargo().getTime()));

            ps.executeUpdate();
        } catch (SQLException e) {

            System.err.println("Erro ao inserir dados:"
                    + " AssocTaxistaDAO:save" + e.getLocalizedMessage());
        }

    }

    public void edit(AssocTaxist a) {
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

    public void delete(AssocTaxist a) {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = ConexaoDB.ligarBD();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, a.getIdAssociadoT());
            ps.executeUpdate();
        } catch (SQLException e) {

            System.err.println("Erro ao eliminar dados:"
                    + " AssocTaxistaDAO:delete" + e.getLocalizedMessage());
        }

    }

    public List<AssocTaxist> listaTodosAssicTaxista() {
        List<AssocTaxist> lista = new ArrayList<>();
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = ConexaoDB.ligarBD();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
             
                AssocTaxist a = new AssocTaxist();
                a.setIdAssociadoT(rs.getInt(1));
                a.setNome(rs.getString("nome_taxist"));
                a.setNumBi(rs.getString("bi_taxist"));
                a.setNumBi(rs.getString("carta_taxist"));
                a.setTelefone(rs.getString("tel_taxist"));
                a.setDatNasc(rs.getDate("data_nasc_taxist"));
                a.setDatCastro(rs.getDate("data_cadast_taxist"));
                a.setCargo(rs.getString("cargo_taxist"));
                a.setDatCargo(rs.getDate("dat_cargo"));
                
              lista.add(a);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados:"
                    + "AssocTaxistaDAO:"
                    + "listaTodosAssocTaxista" + ex.getLocalizedMessage());
        }

        return lista;
    }
    
}
