package com.gestioninventario.api_gestion_inventario.repository;

import com.gestioninventario.api_gestion_inventario.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GestionInvetarioRepository extends JpaRepository<Product, Long> {
}
