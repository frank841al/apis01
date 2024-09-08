package com.gestioninventario.api_gestion_inventario.controller;

import com.gestioninventario.api_gestion_inventario.entity.Product;
import com.gestioninventario.api_gestion_inventario.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Operation(summary = "Obtener todos los productos", description = "Devuelve una lista de todos los productos.")
    @ApiResponse(responseCode = "200", description = "Operación exitosa")
    @GetMapping
    public List<Product> getAllProduct(){
        return productService.getAll();
    };

    @Operation(summary = "Agregar productos", description = "Crea y agrega nuevos productos.")
    @ApiResponse(responseCode = "200", description = "Operación exitosa")
    @PostMapping
    public Product saveProduct(@RequestBody Product product){
      return productService.saveAll(product);
    };

    @Operation(summary = "Actualiza productos", description = "Modifica y actualiza los productos por id.")
    @ApiResponse(responseCode = "200", description = "Operación exitosa")
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable  Long id,@RequestBody Product product){
        return productService.updateProduct(id, product);
    };

    @Operation(summary = "Elimina productos", description = "Elimina  los productos por id .")
    @ApiResponse(responseCode = "200", description = "Operación exitosa")
    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id){
        productService.deleteProduct(id);
    }

}
