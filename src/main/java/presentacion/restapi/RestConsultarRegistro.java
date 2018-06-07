package presentacion.restapi;

import com.liquid.restApi.datos.model.Distrito;
import com.liquid.restApi.presentacion.controller.contrato.base.ConsultarBaseController;
import com.liquid.restApi.presentacion.controller.util.InjectHibernate;
import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.*;
import presentacion.restapi.util.Hibernate;

import java.util.List;

/**
 * Created by Jse on 12/05/2018.
 */
@RestController
public class RestConsultarRegistro implements ConsultarBaseController<Distrito> {

    private final ConsultarBaseController<Distrito> distritoConsultarBaseController;

    public RestConsultarRegistro() {
        SessionFactory factory = new Hibernate().buildSessionFactory();
        this.distritoConsultarBaseController = InjectHibernate.injectDistritoControllerHibernate(factory);
    }

    @RequestMapping("/distrito")
    public String welcome() {//Welcome page, non-rest
        return "Welcome to RestTemplate Example.";
    }

    @RequestMapping(value = "/distrito", method = RequestMethod.POST)
    @Override
    public List<Distrito> allObjeto() {
        return distritoConsultarBaseController.allObjeto();
    }

    @RequestMapping(value = "/distrito/{id}", method = RequestMethod.POST)
    @Override
    public Distrito getObjeto(@PathVariable int id) {
        return distritoConsultarBaseController.getObjeto(id);
    }

    @RequestMapping(value = "/distrito/save", method = RequestMethod.POST)
    @Override
    public Distrito save(@RequestBody Distrito distrito) {
        return distritoConsultarBaseController.save(distrito);
    }

    @RequestMapping(value = "/distrito/update", method = RequestMethod.POST)
    @Override
    public boolean updateObjecto(@RequestBody Distrito distrito) {
        return distritoConsultarBaseController.updateObjecto(distrito);
    }

    @RequestMapping(value = "/distrito/delete", method = RequestMethod.POST)
    @Override
    public boolean deleteObjeto(@RequestBody Distrito distrito) {
        return distritoConsultarBaseController.deleteObjeto(distrito);
    }
}
