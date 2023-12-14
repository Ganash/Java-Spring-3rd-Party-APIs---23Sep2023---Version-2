package dev.ganesh.productServicettsevening.services;

import dev.ganesh.productServicettsevening.dtos.ProductDto;
import dev.ganesh.productServicettsevening.models.Category;
import dev.ganesh.productServicettsevening.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService {

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder){

        // using dependency injection, to get an object of restTemplateBuilder
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<Product> getAllProducts() {

        // I need to call third party API
        // I will implement getAllProducts at the end
        // when we are using third party API, we are not able to call List

        return null;
    }

    /*
    getSingleProduct(Long productId) returns Product object with all details of the fetched product. The Id of the category will be null but the name of the category shall be correct.

     */
    @Override
    public Product getSingleProduct(Long productId) {

        // In getSingleProduct, we will make another call to FakeStoreAPI and get the output.

        // RestTemplateBuilder will allow us to create an object of RestTemplate.

        // restTemplate can make delete, get, head, post, patch, put requests.

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto> response = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", ProductDto.class, productId);

        //     restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", ProductDto.class, productId); - going to return the object of ProductDTO.class

        // so the return type should be ResponseEntity<ProductDTO> response

//        if (response.getStatusCode().is2xxSuccessful()){
//
//            if status code is successful
//
//        } else {
//
//            if status code is not successful then throw an error
//
//        }

        // From this response entity we will get a ProductDTO object

        ProductDto productDto = response.getBody();

        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setImageURL(productDto.getImage());

        return product;
    }

    @Override
    public Product addNewProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Boolean deleteProduct(Long productId) {
        return null;
    }
}
