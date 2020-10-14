/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author GENATCHI
 */
public class Carro {
    
        private int idCarro;
    private String modelo;
    private String matricula;
    private AssocTaxist nomeTaxista;

    public Carro() {
    }

    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public AssocTaxist getNomeTaxista() {
        return nomeTaxista;
    }

    public void setNomeTaxista(AssocTaxist nomeTaxista) {
        this.nomeTaxista = nomeTaxista;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idCarro;
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
        final Carro other = (Carro) obj;
        if (this.idCarro != other.idCarro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Carro{" + "idCarro=" + idCarro + '}';
    }
    
}
