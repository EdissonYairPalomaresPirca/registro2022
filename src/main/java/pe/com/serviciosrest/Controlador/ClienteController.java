package pe.com.serviciosrest.Controlador;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.serviciosrest.entity.Cliente;
import pe.com.serviciosrest.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> findAll() {
        return clienteService.findAll();
    }

    @PostMapping
    public Cliente add(@RequestBody Cliente cl) {
        return clienteService.add(cl);

    }

    @GetMapping("/{id}")
    public Optional<Cliente> findById(@PathVariable long id) {
        return clienteService.findById(id);
    }

    @PutMapping("/{id}")
    public Cliente update(@PathVariable long id, @RequestBody Cliente cl) {
        cl.setCodigo(id);
        return clienteService.update(cl);
    }
    
    @DeleteMapping("/{id}")
    public Cliente delete(@PathVariable long id) {
        Cliente objcliente = new Cliente();
        objcliente.setCodigo(id);
        return clienteService.delete(Cliente.builder().codigo(id).build());
    }
}
