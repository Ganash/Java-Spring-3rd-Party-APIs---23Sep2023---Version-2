package dev.ganesh.productServicettsevening.services;

import dev.ganesh.productServicettsevening.dtos.ProductDto;
import dev.ganesh.productServicettsevening.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();


    Product getSingleProduct(Long productId);


    Product addNewProduct(Product product);


    Product updateProduct(Long productId, Product product);


    Boolean deleteProduct(Long productId);
}
