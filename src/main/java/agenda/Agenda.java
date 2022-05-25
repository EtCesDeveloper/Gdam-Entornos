
package agenda;

//import exceptions.ContactoInexistenteException;
import exceptions.ContactoRepetidoException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author loned
 */
public class Agenda {

    private HashMap<String, Contacto> contactos = new HashMap();
    private static int n = 0;
    private static int count = 0;
        private static String nombreAgenda="";

    public String getnombreAgenda(Agenda a){
            return this.nombreAgenda;
    }
    public void setnombreAgenda(String name){
            this.nombreAgenda=name;
    }

    public Agenda(String name){
    
        if (name != ""){
            this.nombreAgenda = name;
        }
        else this.nombreAgenda ="Untitled";
    }
 /**
  * Añade Contacto de la agenda
  * @param contacto un contacto que queremos añadir
  * @return Objeto contacto añadido o genera una ecepción si ya existía
  * @throws ContactoRepetidoException Excepción programada, ver paquete exception
  */
    public Contacto addContacto(Contacto contacto) throws ContactoRepetidoException {
        if (contactos.containsKey(contacto.getEmail())) {
            //
            throw new ContactoRepetidoException("Ya existe un contacto con email: " + contacto.getEmail());
        }
        n++;
        contacto.setN(n);
        contactos.put(contacto.getEmail(), contacto);
        count++;
        return contacto;
    }
/**
 * Run generate java docs
 * @param email Correo electronico que queremos añadir
 * @return Objeto email añadido o genera una ecepción si ya existía
 */
    public Contacto eliminarContacto(String email) { 
        Contacto contacto = buscarContacto(email);
        if (contacto != null) {
        contactos.remove(email);
        count--;
        }
        return contacto;
    }
/**
 * Elimina email de la agenda
 * @param email Correo electronico que queremos eliminar
 * @return Elimina email de la agenda
 */
    public Contacto buscarContacto(String email) { 
        Contacto contacto = null;
        if (!contactos.containsKey(email)) {

            return null;
        }
        else{
        return contactos.get(email);
        }
    }
/**
 * Busca contacto en la lista
 * @return Busca entre los contactos
 */
    public ArrayList<Contacto> getContactos() {
        ArrayList<Contacto> contactosList = new ArrayList<>();
        contactosList.addAll(contactos.values());
        return contactosList;
    }
    
    

}
