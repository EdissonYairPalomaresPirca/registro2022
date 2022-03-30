package pe.com.serviciosrest.service;
import java.util.List;
import java.util.Optional;
import pe.com.serviciosrest.entity.Categoria;



public interface CategoriaService {



List<Categoria> finAll();



Optional<Categoria> findById(Long id);



List<Categoria> finByName(String name);



Categoria add(Categoria c);



Categoria update(Categoria c);



Categoria delete(Categoria c);



}