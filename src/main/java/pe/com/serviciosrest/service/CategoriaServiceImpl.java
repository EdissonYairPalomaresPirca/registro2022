package pe.com.serviciosrest.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.serviciosrest.entity.Categoria;
import pe.com.serviciosrest.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> finAll() {
        return categoriaRepository.findAllCustom();
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public List<Categoria> finByName(String name) {
        return categoriaRepository.findByName(name);
    }

    @Override
    public Categoria add(Categoria c) {
        return categoriaRepository.save(c);
    }

    @Override
    public Categoria update(Categoria c) {
        Categoria objcategoria = categoriaRepository.getById(c.getCodigo());
        BeanUtils.copyProperties(c, objcategoria);
        return categoriaRepository.save(objcategoria);
    }

    @Override
    public Categoria delete(Categoria c) {
        Categoria objcategoria = categoriaRepository.getById(c.getCodigo());
        objcategoria.setEstado(false);
        return categoriaRepository.save(objcategoria);
    }

}
