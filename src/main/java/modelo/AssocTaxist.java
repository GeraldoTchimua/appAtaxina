/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author GENATCHI
 */
public class AssocTaxist {
    
    
    private int idAssociadoT;
    private String nome;
    private String numBi;
    private String cartaCond;
    private String telefone;
    private Date datNasc;
    private Date datCastro;
    private String cargo;
    private Date datCargo;

    public AssocTaxist() {
    }

    public int getIdAssociadoT() {
        return idAssociadoT;
    }

    public void setIdAssociadoT(int idAssociadoT) {
        this.idAssociadoT = idAssociadoT;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumBi() {
        return numBi;
    }

    public void setNumBi(String numBi) {
        this.numBi = numBi;
    }

    public String getCartaCond() {
        return cartaCond;
    }

    public void setCartaCond(String cartaCond) {
        this.cartaCond = cartaCond;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDatNasc() {
        return datNasc;
    }

    public void setDatNasc(Date datNasc) {
        this.datNasc = datNasc;
    }

    public Date getDatCastro() {
        return datCastro;
    }

    public void setDatCastro(Date datCastro) {
        this.datCastro = datCastro;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getDatCargo() {
        return datCargo;
    }

    public void setDatCargo(Date datCargo) {
        this.datCargo = datCargo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idAssociadoT;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AssocTaxist other = (AssocTaxist) obj;
        if (this.idAssociadoT != other.idAssociadoT) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AssocTaxist{" + "idAssociadoT=" + idAssociadoT + '}';
    }
    
    
}
