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
import modelo.AssocSimples;


/**
 *
 * @author DGTALE
 */
@FacesConverter("AssocSConverter")
public class AssocSConverter implements Converter {

    private static Map<String, AssocSimples> map = new HashMap<String, AssocSimples>();

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        return map.get(arg2);
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        if (arg2 instanceof AssocSimples) {
           AssocSimples a = (AssocSimples) arg2;
            map.put(String.valueOf(a.getIdAssociadoS()), a);
            return String.valueOf(a.getIdAssociadoS());
        } else {
            return "";
        }

    }

}
