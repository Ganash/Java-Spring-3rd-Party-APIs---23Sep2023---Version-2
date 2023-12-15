package dev.ganesh.productServicettsevening.controllers;

import com.sun.net.httpserver.Authenticator;
import dev.ganesh.productServicettsevening.dtos.GetSingleProductResponseDto;
import dev.ganesh.productServicettsevening.dtos.ProductDto;
import dev.ganesh.productServicettsevening.models.Product;
import dev.ganesh.productServicettsevening.services.ProductService;
import org.springframework.boot.actuate.endpoint.web.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/*
*
* RestController tells Spring that this particular class (ProductController) is having
* restapis internally. This particular class has some api implemented.
*
* so basically @RestController annotation will basically register that particular class in
* spring dispatcher.
*
* So @RestController annotation tells spring that in this particular class there are
* endpoints are implemented, please register those in your dispatcher, if you get some
* rest request.
*
*
*
* */
@RestController
@RequestMapping("/products")
public class ProductController {

    /*
    *
    * Controller is nothing but a set of methods, Each method serves particular request.
    *
    * */

    private ProductService productService;

    public ProductController(ProductService productService){

        this.productService = productService;

    }

    @GetMapping()
    public String getAllProducts(){

        return "Getting ALL Products";
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId){

        // We couldn't able to use HashMap because it is not Map class. MultiValueMap and LinkedMultiValueMap are new that spring class created.

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add(
                "auth-token", "noaccess4uheyhey"
        );

        ResponseEntity<Product> response = new ResponseEntity(

                productService.getSingleProduct(productId),
                headers,
                HttpStatus.OK
        );

        return response;
    }

    @PostMapping("")
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto product){

        Product newProduct = productService.addNewProduct(
                product
        );

        ResponseEntity<Product> response = new ResponseEntity<>(newProduct, HttpStatus.OK);

        return response;
    }

    @PostMapping("{productId}")
    public String updateProduct(@PathVariable("productId") Long productId){

        return "Updating a Product with id: " + productId;
    }

    @DeleteMapping("{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId){

        return "Deleting a Product with id: " + productId;
    }

}
