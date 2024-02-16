package com.ecommerce.ecommerceproduct.api.controller;

import com.ecommerce.ecommerceproduct.api.mapper.ProductMapper;
import com.ecommerce.ecommerceproduct.api.mapper.dto.ProductDisableRequest;
import com.ecommerce.ecommerceproduct.api.mapper.dto.ProductRequest;
import com.ecommerce.ecommerceproduct.api.mapper.dto.ProductResponse;
import com.ecommerce.ecommerceproduct.domain.model.Product;
import com.ecommerce.ecommerceproduct.domain.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
@Log4j2
public class ProductController implements ProductControllerApi{

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ResponseEntity<?> getAllProducts() {

        List<Product> products = productService.getAllProducts();
        log.info("Received request to get all Products.");
        List<ProductResponse> productsResponseDto = productMapper.listProductDomainToResponseDto(products);
        log.info("Response request to get all Products.");
        return ResponseEntity.ok(productsResponseDto);
    }

    @Override
    public ResponseEntity<?> getProductById(UUID id) {
        log.info("Received request to get product id {}.", id.toString());
        try{
            Product product = productService.getProductById(id);
            ProductResponse productResponse = productMapper.productDomainToResponseDto(product);
            log.info("Response request to get product: {}", productResponse);
            return ResponseEntity.ok(productResponse);
        }catch (Exception e){
            log.error(e);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found!");
    }

    @Override
    public ResponseEntity<?> createProduct(ProductRequest productRequest) {

        log.info("Received request to create product {}.", productRequest);
        Product product = productMapper.productDtoToDomain(productRequest);
        Product productSave = productService.saveProduct(product);
        ProductResponse productResponse = productMapper.productDomainToResponseDto(productSave);
        log.info("Response created product successfully: {}", productResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }

    @Override
    public ResponseEntity<?> updateProduct(ProductRequest productRequest, UUID id) {
        log.info("Received product {} to update.",id.toString());

        Product product = productService.getProductById(id);

        BeanUtils.copyProperties(productRequest, product);

        Product productSave = productService.saveProduct(product);
        ProductResponse productResponse = productMapper.productDomainToResponseDto(productSave);
        log.info("Response product updated: {}", productResponse);
        return ResponseEntity.ok(productResponse);
    }

    @Override
    public ResponseEntity<?> disableProduct(ProductDisableRequest productDisableRequest, UUID id) {
        productService.updateStatusProduct(productDisableRequest.isStatus(), id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }


}
