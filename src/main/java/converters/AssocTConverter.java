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
import modelo.AssocTaxist;


/**
 *
 * @author DGTALE
 */
@FacesConverter("assocTConverter")
public class AssocTConverter implements Converter{
 private static Map<String, AssocTaxist> map = new HashMap<String, AssocTaxist>();
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
         return map.get(value);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
          if (value instanceof AssocTaxist) {
            AssocTaxist a = (AssocTaxist) value;
            map.put(String.valueOf(a.getIdAssociadoT()), a);
            return String.valueOf(a.getIdAssociadoT());
        } else {
            return "";
        }

    }
    
}
