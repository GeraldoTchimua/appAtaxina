package controller;

import dao.AssocSimplesDAO;
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

/**
 *
 * @author GENATCHI
 */
@Named
@RequestScoped
public class AssocSimplesCDIBean implements Serializable{

    AssocSimples assocSimple;
    AssocSimplesDAO assocSimplesDAO = new AssocSimplesDAO();

    List<AssocSimples> assocSimples;

    @PostConstruct
    public void inicizalizar() {
        assocSimple = new AssocSimples();
        assocSimples = new ArrayList<>();
        assocSimples = assocSimplesDAO.listaTodosAssocSimples();
        
    }

    public AssocSimples getAssocSimple() {
        return assocSimple;
    }

    public void setAssocSimple(AssocSimples assocSimple) {
        this.assocSimple = assocSimple;
    }

    public List<AssocSimples> getAssocSimples() {
        return assocSimples;
    }

    public void setAssocSimples(List<AssocSimples> assocSimples) {
        this.assocSimples = assocSimples;
    }

    // CRUD - Create , Read , Update , Delete
    public String guardar() {
        assocSimplesDAO.save(assocSimple);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String operacao = "Guardar";

        FacesMessage facesMessage
                = new FacesMessage(null, "Associado Guardado com sucesso" + " " + operacao);

        facesContext.addMessage(null, facesMessage);

        assocSimple = new AssocSimples();

        return "inserir-associadoS";
    }
//outro para salvar
    public String save() {
         assocSimplesDAO.save(assocSimple);
        assocSimple = new AssocSimples();
         return "inserir-associadoS";
    }

    public String editar() {
        assocSimplesDAO.edit(assocSimple);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String operacao = "Editar";

        FacesMessage facesMessage
                = new FacesMessage(null, " Dados do associado editados com sucesso" + " " + operacao);

        facesContext.addMessage(null, facesMessage);
        assocSimple = new AssocSimples();
        return "editar-associadoS";
    }

    public String prepararEditar() {

        return "editar-funcionario";
    }

    public String eliminar() {
        assocSimplesDAO.delete(assocSimple);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String operacao = "Eliminar";

        FacesMessage facesMessage
                = new FacesMessage(null, " Dados do associado eliminados com sucesso" + " " + operacao);

        facesContext.addMessage(null, facesMessage);

        return "lista-associadoS";
    }

    public String Cancelar(){
        
        return "lista-associadoS";
    }
    
    public List<AssocSimples> getListaAssocSimples() {
        List<AssocSimples> lista = new ArrayList<>();
        lista = assocSimplesDAO.listaTodosAssocSimples();
        return lista;

    }

}
