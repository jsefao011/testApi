package presentacion.restapi;

import com.liquid.restApi.datos.model.EstadoCivil;
import com.liquid.restApi.datos.model.Persona;
import com.liquid.restApi.presentacion.controller.contrato.ConsultarPersonaController;
import com.liquid.restApi.presentacion.controller.contrato.base.ConsultarBaseController;
import com.liquid.restApi.presentacion.controller.util.InjectHibernate;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import presentacion.restapi.util.Hibernate;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Jse on 12/05/2018.
 */
@RestController
public class RestConsultarPersona implements ConsultarPersonaController {

    private ConsultarPersonaController personaController;

    public RestConsultarPersona() {
        SessionFactory factory = new Hibernate().buildSessionFactory();
        this.personaController = InjectHibernate.injectPersonaControllerHibernate(factory);
    }

    @RequestMapping("/persona")
    public String welcome() {//Welcome page, non-rest
        return "Welcome to RestTemplate Example.";
    }

    @RequestMapping(value = "/persona", method = RequestMethod.POST)
    @Override
    public List<Persona> allObjeto() {
        return personaController.allObjeto();
    }

    @RequestMapping(value = "/persona/{id}", method = RequestMethod.POST)
    @Override
    public Persona getObjeto(@PathVariable int id) {
        return personaController.getObjeto(id);
    }

    @RequestMapping(value = "/persona/save", method = RequestMethod.POST)
    @Override
    public Persona save(@RequestBody Persona persona) {
        return personaController.save(persona);
    }

    @RequestMapping(value = "/persona/update", method = RequestMethod.POST)
    @Override
    public boolean updateObjecto(@RequestBody Persona persona) {
        return personaController.updateObjecto(persona);
    }

    @RequestMapping(value = "/persona/delete", method = RequestMethod.POST)
    @Override
    public boolean deleteObjeto(@RequestBody Persona persona) {
        return personaController.deleteObjeto(persona);
    }
}