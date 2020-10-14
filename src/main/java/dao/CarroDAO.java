package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.AssocTaxist;
import modelo.Carro;
import util.ConexaoDB;

/**
 *
 * @author GENATCHI
 */
public class CarroDAO {

    String INSERT = "INSERT INTO tb_carro(id_carro, modelo, matricula, idassoc_taxist) VALUES(?, ?, ?, ?)";
    String UPDATE = "UPDATE id_carro SET modelo = ?, matricula = ?, idassoc_taxist = ? WHERE id_carro = ?";
    String DELETE = "DELETE FROM  tb_carro WHERE id_carro = ?";
    String SELECT_ALL = "SELECT id_carro, modelo, matricula, idassoc_taxist FROM  tb_carro";
    
    String SELECT_BY_NOME = "SELECT idassoc_simples, nome_assoc_simples, bi_assoc_simples, tel_assoc_simples, data_nasc_assoc_simples, data_cadast_assoc_simples, cargo_assoc_simples, dat_cargo FROM  tb_assoc_simples a WHERE a.nome_assoc_simples LIKE ? ";
    String SELECT_BY_BI = "SELECT idassoc_simples, nome_assoc_simples, bi_simples, tel_assoc_simples, data_nasc_assoc_simples, data_cadast_assoc_simples, cargo_assoc_simples, dat_cargo FROM  tb_assoc_simples a WHERE a.nome_assoc_simples = ? AND a.bi_simples = ?";
    String SELECT_BY_DATA_NASCIMENTO = "SELECT idassoc_simples, nome_assoc_simples, bi_simples, tel_assoc_simples, data_nasc_assoc_simples, data_cadast_assoc_simples, cargo_assoc_simples, dat_cargo FROM tb_assoc_simples a WHERE a.data_nasc_assoc_simples BETWEEN ? AND ?";

    public void save(Carro c) {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = ConexaoDB.ligarBD();
            ps = conn.prepareStatement(INSERT);
            
            ps.setInt(1, c.getIdCarro());
            ps.setString(2, c.getModelo());
            ps.setString(3, c.getMatricula());
            ps.setString(4, String.valueOf(c.getNomeTaxista().getIdAssociadoT()));           
            
               
            ps.executeUpdate();
        } catch (SQLException e) {

            System.err.println("Erro ao inserir dados:"
                    + " CarroDAO:save" + e.getLocalizedMessage());
        }

    }

    public void edit(Carro c) {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = ConexaoDB.ligarBD();
            ps = conn.prepareStatement(UPDATE);
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, c.getModelo());
            ps.setString(2, c.getMatricula());
            ps.setString(3,String.valueOf(c.getNomeTaxista().getIdAssociadoT()));           
            
        ps.executeUpdate();
        } catch (SQLException e) {

            System.err.println("Erro ao actualizar dados:"
                    + " CarroDAO:edit" + e.getLocalizedMessage());
        }

    }

    public void delete(Carro c) {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = ConexaoDB.ligarBD();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, c.getIdCarro());
            ps.executeUpdate();
        } catch (SQLException e) {

            System.err.println("Erro ao eliminar dados:"
                    + " CarroDAO:delete" + e.getLocalizedMessage());
        }
    }


    public List<Carro> listaTodosCarros () {
        List<Carro> lista = new ArrayList<>();
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = ConexaoDB.ligarBD();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                
               Carro c = new Carro();
                c.setIdCarro(rs.getInt(1));
                c.setModelo(rs.getString("modelo"));
                c.setMatricula(rs.getString("matricula"));
                
               AssocTaxist taxista = new AssocTaxist();
               taxista.setIdAssociadoT(rs.getInt("idassoc_taxist"));
               c.setNomeTaxista(taxista);              
                
                
          

                lista.add(c);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados:"
                    + "CarroDAO:"
                    + " listaTodosCarros" + ex.getLocalizedMessage());
        }

        return lista;
    }

   
}
