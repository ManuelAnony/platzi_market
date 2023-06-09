package com.platzi.cursoplatzi.persistence;

import com.platzi.cursoplatzi.domain.Product;
import com.platzi.cursoplatzi.domain.repository.ProductRepository;
import com.platzi.cursoplatzi.persistence.crud.ProductoCrudRepository;
import com.platzi.cursoplatzi.persistence.entity.Producto;
import com.platzi.cursoplatzi.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return  Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos= productoCrudRepository.finByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProducts(int productId) {

        return productoCrudRepository.findById(productId).map(producto-> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toPrducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }
 }
