package pe.com.serviciosrest.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.com.serviciosrest.entity.Producto;
import pe.com.serviciosrest.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAllCustom();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public List<Producto> finByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto add(Producto p) {
        return productoRepository.save(p);

    }

    @Override
    public Producto update(Producto p) {
        Producto objproducto = productoRepository.getById(p.getCodigo());
        BeanUtils.copyProperties(p, objproducto);
        return productoRepository.save(objproducto);
    }

    @Override
    public Producto delete(Producto p) {
        Producto objproducto = productoRepository.getById(p.getCodigo());
        objproducto.setEstado(false);
        return productoRepository.save(objproducto);

    }
}