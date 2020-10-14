package controller;

import dao.AssocTaxistaDAO;
import dao.CotaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import modelo.AssocTaxist;
import modelo.Cota;

/**
 *
 * @author GENATCHI
 */
@Named(value = "cotaCDIBean")
@RequestScoped
public class CotaCDIBean {

    Cota cota;
    CotaDAO cotaDAO = new CotaDAO();
    AssocTaxistaDAO dao = new AssocTaxistaDAO();

    List<Cota> cotas;

    @PostConstruct
    public void inicizalizar() {
        cota = new Cota();
        cotas = new ArrayList<>();
        cotas = cotaDAO.listaTodasCotas();

    }

    public Cota getCota() {
        return cota;
    }

    public void setCota(Cota cota) {
        this.cota = cota;
    }

    public List<Cota> getCotas() {
        return cotas;
    }

    public void setCotas(List<Cota> cotas) {
        this.cotas = cotas;
    }

   

    public List<SelectItem> getSelectTaxistas() {
        List<SelectItem> lista = new ArrayList<>();
        for (AssocTaxist a : dao.listaTodosAssicTaxista()) {
            lista.add(new SelectItem(a, a.getNome()));
        }
        return lista;
    }

    // CRUD - Create , Read , Update , Delete
    public String guardar() {
        cotaDAO.save(cota);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String operacao = "Guardar";

        FacesMessage facesMessage
                = new FacesMessage(null, "Carro Guardado com sucesso" + " " + operacao);

        facesContext.addMessage(null, facesMessage);

        cota = new Cota();

        return "inserir-cota";
    }
//outro para salvar

    public String save() {
        cotaDAO.save(cota);
        
        cota = new Cota();
        return "inserir-carro";
    }

    public String editar() {
        cotaDAO.edit(cota);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String operacao = "Editar";

        FacesMessage facesMessage
                = new FacesMessage(null, " Dados do carro editados com sucesso" + " " + operacao);

        facesContext.addMessage(null, facesMessage);
        cota = new Cota();
        return "editar-Cota";
    }

    public String prepararEditar() {

        return "editar-cota";
    }

    public String eliminar() {
        cotaDAO.delete(cota);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String operacao = "Eliminar";

        FacesMessage facesMessage
                = new FacesMessage(null, " Dados da cota eliminados com sucesso" + " " + operacao);

        facesContext.addMessage(null, facesMessage);

        return "lista-cota";
    }

    public String Cancelar() {

        return "lista-cota";
    }

//Para preencher o combobox
    public List<Cota> getListaCotas() {
        List<Cota> lista = new ArrayList<>();
        lista = cotaDAO.listaTodasCotas();
        return lista;

    }

}
