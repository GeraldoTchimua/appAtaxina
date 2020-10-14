
package converters;

import java.util.HashMap;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Carro;
import modelo.Cota;

/**
 *
 * @author GENATCHI
 */

@FacesConverter("CotaConverter")
public class CotaConveter implements Converter{
    
     private static Map<String, Cota> mapa = new HashMap<String, Cota>();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return mapa.get(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Cota) {
            Cota c = (Cota) value;
            mapa.put(String.valueOf(c.getIdCota()), c);
            return String.valueOf(c.getIdCota());
        } else {
            return "";
        }

    }

    
    
    
}
