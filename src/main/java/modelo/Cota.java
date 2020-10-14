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
public class Cota {
    
    private int idCota;
    private Double valor;
    private Date datCota;
    private AssocTaxist nomeTaxista;

    public Cota() {
    }

    public int getIdCota() {
        return idCota;
    }

    public void setIdCota(int idCota) {
        this.idCota = idCota;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDatCota() {
        return datCota;
    }

    public void setDatCota(Date datCota) {
        this.datCota = datCota;
    }

    public AssocTaxist getNomeTaxista() {
        return nomeTaxista;
    }

    public void setNomeTaxista(AssocTaxist nomeTaxista) {
        this.nomeTaxista = nomeTaxista;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.idCota;
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
        final Cota other = (Cota) obj;
        if (this.idCota != other.idCota) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cota{" + "idCota=" + idCota + '}';
    }
    
    
    
}
