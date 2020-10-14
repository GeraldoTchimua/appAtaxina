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
import modelo.Cota;
import util.ConexaoDB;

/**
 *
 * @author GENATCHI
 */
public class CotaDAO {

    String INSERT = "INSERT INTO tb_cota(id_cota, valor, data_cota, idassoc_taxist) VALUES(?, ?, ?, ?)";
    String UPDATE = "UPDATE id_cota SET valor = ?, data_cota = ?, idassoc_taxist = ? WHERE id_cota = ?";
    String DELETE = "DELETE FROM  tb_cota WHERE id_cota = ?";
    String SELECT_ALL = "SELECT id_cota, valor, data_cota, idassoc_taxist FROM  tb_cota";

    String SELECT_BY_NOME_TAXISTA = "SELECT idassoc_simples, nome_assoc_simples, bi_assoc_simples, tel_assoc_simples, data_nasc_assoc_simples, data_cadast_assoc_simples, cargo_assoc_simples, dat_cargo FROM  tb_assoc_simples a WHERE a.nome_assoc_simples LIKE ? ";
    String SELECT_BY_BI = "SELECT idassoc_simples, nome_assoc_simples, bi_simples, tel_assoc_simples, data_nasc_assoc_simples, data_cadast_assoc_simples, cargo_assoc_simples, dat_cargo FROM  tb_assoc_simples a WHERE a.nome_assoc_simples = ? AND a.bi_simples = ?";
    String SELECT_BY_DATA_NASCIMENTO = "SELECT idassoc_simples, nome_assoc_simples, bi_simples, tel_assoc_simples, data_nasc_assoc_simples, data_cadast_assoc_simples, cargo_assoc_simples, dat_cargo FROM tb_assoc_simples a WHERE a.data_nasc_assoc_simples BETWEEN ? AND ?";

    public void save(Cota c) {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = ConexaoDB.ligarBD();
            ps = conn.prepareStatement(INSERT);

            ps.setInt(1, c.getIdCota());
            ps.setDouble(2, c.getValor());
            ps.setDate(3, new java.sql.Date(c.getDatCota().getTime()));

            ps.setString(4, String.valueOf(c.getNomeTaxista().getIdAssociadoT()));

            ps.executeUpdate();
        } catch (SQLException e) {

            System.err.println("Erro ao inserir dados:"
                    + " CotaDAO:save" + e.getLocalizedMessage());
        }

    }

    public void edit(Cota c) {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = ConexaoDB.ligarBD();
            ps = conn.prepareStatement(UPDATE);
            ps = conn.prepareStatement(INSERT);
            ps.setDouble(1, c.getValor());
            ps.setDate(2, new java.sql.Date(c.getDatCota().getTime()));
            ps.setString(3, String.valueOf(c.getNomeTaxista().getIdAssociadoT()));

            ps.executeUpdate();
        } catch (SQLException e) {

            System.err.println("Erro ao actualizar dados:"
                    + " CotaDAO:edit" + e.getLocalizedMessage());
        }

    }

    public void delete(Cota c) {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = ConexaoDB.ligarBD();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, c.getIdCota());
            ps.executeUpdate();
        } catch (SQLException e) {

            System.err.println("Erro ao eliminar dados:"
                    + " CotaDAO:delete" + e.getLocalizedMessage());
        }
    }

    public List<Cota> listaTodasCotas() {
        List<Cota> lista = new ArrayList<>();
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = ConexaoDB.ligarBD();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {

                Cota c = new Cota();
                c.setIdCota(rs.getInt(1));
                c.setValor(rs.getDouble("valor"));
                c.setDatCota(rs.getDate("data_cota"));
               
                AssocTaxist taxista = new AssocTaxist();
                taxista.setIdAssociadoT(rs.getInt("idassoc_taxist"));
                c.setNomeTaxista(taxista);

                lista.add(c);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados:"
                    + "CotaDAO:"
                    + " listaTodasCotas" + ex.getLocalizedMessage());
        }

        return lista;
    }

}
