package com.platzi.cursoplatzi.persistence.crud;

import com.platzi.cursoplatzi.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    Optional<List<Producto>> finByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

}
