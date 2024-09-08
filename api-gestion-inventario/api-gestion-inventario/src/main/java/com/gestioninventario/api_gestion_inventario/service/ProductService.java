package com.gestioninventario.api_gestion_inventario.service;

import com.gestioninventario.api_gestion_inventario.entity.Product;
import com.gestioninventario.api_gestion_inventario.repository.GestionInvetarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private GestionInvetarioRepository GeInRepo;

    public List<Product> getAll(){
        return GeInRepo.findAll();
    };

    public Product saveAll(Product product){
        return this.GeInRepo.save(product);
    };

    public Product updateProduct(Long id, Product product){
        Product existeProduct = GeInRepo.findById(id)
                .orElseThrow(()->new RuntimeException("no encontrado"));
        existeProduct.setName(product.getName());
        existeProduct.setQuantity(product.getQuantity());
        existeProduct.setPrice(product.getPrice());
        return GeInRepo.save(existeProduct);
    };

    public void deleteProduct(Long id){
         GeInRepo.deleteById(id);
    };
}
