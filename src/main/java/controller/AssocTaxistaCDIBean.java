package controller;

import dao.AssocSimplesDAO;
import dao.AssocTaxistaDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.AssocSimples;
import modelo.AssocTaxist;

/**
 *
 * @author GENATCHI
 */
@Named
@RequestScoped
public class AssocTaxistaCDIBean implements Serializable{

    AssocTaxist assocTaxista;
    AssocTaxistaDAO assocTaxistaDAO = new AssocTaxistaDAO();

    List<AssocTaxist> assocTaxistas;

    @PostConstruct
    public void inicizalizar() {
      assocTaxista = new AssocTaxist();
        assocTaxistas = new ArrayList<>();
        assocTaxistas = assocTaxistaDAO.listaTodosAssicTaxista();
        
    }

    public AssocTaxist getAssocTaxista() {
        return assocTaxista;
    }

    public void setAssocTaxista(AssocTaxist assocTaxista) {
        this.assocTaxista = assocTaxista;
    }

    public List<AssocTaxist> getAssocTaxistas() {
        return assocTaxistas;
    }

    public void setAssocTaxistas(List<AssocTaxist> assocTaxistas) {
        this.assocTaxistas = assocTaxistas;
    }

   

    // CRUD - Create , Read , Update , Delete
    public String guardar() {
        assocTaxistaDAO.save(assocTaxista);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String operacao = "Guardar";

        FacesMessage facesMessage
                = new FacesMessage(null, "Associado Guardado com sucesso" + " " + operacao);

        facesContext.addMessage(null, facesMessage);

        assocTaxista = new AssocTaxist();

        return "inserir-associadoT";
    }
//outro para salvar
    public String save() {
        assocTaxistaDAO.save(assocTaxista);
        assocTaxista = new AssocTaxist();
         return "inserir-associadoT";
    }

    public String editar() {
        assocTaxistaDAO.edit(assocTaxista);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String operacao = "Editar";

        FacesMessage facesMessage
                = new FacesMessage(null, " Dados do associado editados com sucesso" + " " + operacao);

        facesContext.addMessage(null, facesMessage);
        assocTaxista = new AssocTaxist();
        return "editar-associadoT";
    }

    public String prepararEditar() {

        return "editar-funcionario";
    }

    public String eliminar() {
        assocTaxistaDAO.delete(assocTaxista);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String operacao = "Eliminar";

        FacesMessage facesMessage
                = new FacesMessage(null, " Dados do associado eliminados com sucesso" + " " + operacao);

        facesContext.addMessage(null, facesMessage);

        return "lista-associadoT";
    }

    public String Cancelar(){
        
        return "lista-associadoT";
    }
    
    public List<AssocTaxist> getListaAssocTaxista() {
        List<AssocTaxist> lista = new ArrayList<>();
        lista = assocTaxistaDAO.listaTodosAssicTaxista();
        return lista;

    }

}
