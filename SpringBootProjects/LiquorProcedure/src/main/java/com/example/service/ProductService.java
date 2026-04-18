package com.example.service;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final GroqService groqService;

    public Product save(Product product){
        return productRepository.save(product);
    }

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public Product getById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mod not found!!!!"));
    }

    public Product updateProduct(Long id, Product product){
        Product existing = getById(id);
        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        return productRepository.save(existing);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }

    public void updatePriceUsingProcedure(Long id, Double price){
        productRepository.updateProductPrice(id, price);
    }

    public String getRecommendations(String query){
        List<Product> products = productRepository.findAll();
        return groqService.getRecommendations(query, products);
    }
}
