package controller;

import dao.AssocSimplesDAO;
import dao.AssocTaxistaDAO;
import dao.CarroDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import modelo.AssocTaxist;
import modelo.Carro;

/**
 *
 * @author GENATCHI
 */
@Named
@RequestScoped
public class CarroCDIBean implements Serializable {

    Carro carro;
    CarroDAO carroDAO = new CarroDAO();
    AssocTaxistaDAO dao = new AssocTaxistaDAO();
    

    List<Carro> carros;

    @PostConstruct
    public void inicizalizar() {
        carro = new Carro();
        carros = new ArrayList<>();
        carros = carroDAO.listaTodosCarros();

    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
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
        carroDAO.save(carro);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String operacao = "Guardar";

        FacesMessage facesMessage
                = new FacesMessage(null, "Carro Guardado com sucesso" + " " + operacao);

        facesContext.addMessage(null, facesMessage);

        carro = new Carro();

        return "inserir-carro";
    }
//outro para salvar

    public String save() {
        carroDAO.save(carro);
        carro = new Carro();
        return "inserir-carro";
    }

    public String editar() {
        carroDAO.edit(carro);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String operacao = "Editar";

        FacesMessage facesMessage
                = new FacesMessage(null, " Dados do carro editados com sucesso" + " " + operacao);

        facesContext.addMessage(null, facesMessage);
        carro = new Carro();
        return "editar-Carro";
    }

    public String prepararEditar() {

        return "editar-carro";
    }

    public String eliminar() {
        carroDAO.delete(carro);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String operacao = "Eliminar";

        FacesMessage facesMessage
                = new FacesMessage(null, " Dados do carro eliminados com sucesso" + " " + operacao);

        facesContext.addMessage(null, facesMessage);

        return "lista-carro";
    }

    public String Cancelar() {

        return "lista-carro";
    }
    
//Para preencher o combobox
    public List<Carro> getListaCarros() {
        List<Carro> lista = new ArrayList<>();
        lista = carroDAO.listaTodosCarros();
        return lista;

    }

}
