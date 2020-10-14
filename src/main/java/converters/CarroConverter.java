/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;


import java.util.HashMap;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Carro;


/**
 *
 * @author desenvolvimento
 */
@FacesConverter("CarroConverter")
public class CarroConverter implements Converter {

    private static Map<String, Carro> mapa = new HashMap<String, Carro>();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return mapa.get(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Carro) {
            Carro c = (Carro) value;
            mapa.put(String.valueOf(c.getIdCarro()), c);
            return String.valueOf(c.getIdCarro());
        } else {
            return "";
        }

    }

}
