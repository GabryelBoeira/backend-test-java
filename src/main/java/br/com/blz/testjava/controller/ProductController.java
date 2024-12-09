package br.com.blz.testjava.controller;

import br.com.blz.testjava.dto.detail.ProductDetailDTO;
import br.com.blz.testjava.dto.save.ProductSaveDTO;
import br.com.blz.testjava.dto.update.ProductUpdateDTO;
import br.com.blz.testjava.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@Valid @RequestBody ProductSaveDTO product) {
        try {
            productService.saveProduct(product);
            return ResponseEntity.ok("Product created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{sku}")
    public ResponseEntity<ProductDetailDTO> getProduct(@PathVariable Long sku) {
        return ResponseEntity.ok().body(productService.getProduct(sku));
    }

    @PutMapping("/{sku}")
    public ResponseEntity<ProductDetailDTO> updateProduct(@PathVariable Long sku, @RequestBody ProductUpdateDTO product) {
        return ResponseEntity.ok().body(productService.updateProduct(sku, product));
    }

    @DeleteMapping("/{sku}")
    public void deleteProduct(@PathVariable Long sku) {
        productService.deleteProduct(sku);
    }

}
