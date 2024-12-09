package br.com.blz.testjava.service;

import br.com.blz.testjava.dto.detail.ProductDetailDTO;
import br.com.blz.testjava.dto.save.ProductSaveDTO;
import br.com.blz.testjava.dto.update.ProductUpdateDTO;
import br.com.blz.testjava.entity.ProductEntity;
import br.com.blz.testjava.entity.WarehouseEntity;
import br.com.blz.testjava.exception.BusinessException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {

    //Simula o banco de dados
    private final static Map<Long, ProductEntity> PRODUCTS = new HashMap<>();

    private final ModelMapper modelMapper;

    @Autowired
    public ProductService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /**
     * Save a product in the database.
     *
     * @param product The product to be saved.
     */
    public void saveProduct(ProductSaveDTO product) {
        if (PRODUCTS.containsKey(product.sku()))
            throw new BusinessException("Product with sku " + product.sku() + " already exists");

        PRODUCTS.put(product.sku(), modelMapper.map(product, ProductEntity.class));
    }

    /**
     * Retrieves a product by sku.
     *
     * @param sku The sku of the product to be retrieved.
     * @return The product with the given sku, or null if no product was found.
     */
    public ProductDetailDTO getProduct(Long sku) {
        if (!PRODUCTS.containsKey(sku)) return null;

        var entity = PRODUCTS.get(sku);
        calculateInventory(entity);
        return modelMapper.map(entity, ProductDetailDTO.class);
    }

    /**
     * Updates a product.
     *
     * @param product The product to be updated.
     * @return The updated product.
     */
    public ProductDetailDTO updateProduct(Long sku, ProductUpdateDTO product) {
        var entity = modelMapper.map(product, ProductEntity.class);
        entity.setSku(sku);
        PRODUCTS.put(sku, entity);
        return getProduct(sku);
    }

    /**
     * Deletes a product by its sku.
     *
     * @param sku The sku of the product to be deleted.
     */
    public void deleteProduct(Long sku) {
        if (!PRODUCTS.containsKey(sku)) return;
        PRODUCTS.remove(sku);
    }

    /**
     * Calculates the total quantity of a product in all its warehouses.
     *
     * @param productEntity The product to have its inventory calculated.
     */
    private void calculateInventory(ProductEntity productEntity) {
        Long quantity = productEntity.getInventory().getWarehouses().stream().mapToLong(WarehouseEntity::getQuantity).sum();

        if (quantity > 0) {
            productEntity.getInventory().setQuantity(quantity);
            productEntity.setIsMarketable(true);
        } else {
            productEntity.getInventory().setQuantity(quantity);
            productEntity.setIsMarketable(false);
        }
    }

}
