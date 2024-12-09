package br.com.blz.testjava.service;

import br.com.blz.testjava.dto.detail.ProductDetailDTO;
import br.com.blz.testjava.dto.save.InventorySaveDTO;
import br.com.blz.testjava.dto.save.ProductSaveDTO;
import br.com.blz.testjava.exception.BusinessException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ProductServiceUnitTest {

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ProductService productService;

    @Test
    public void testSaveProduct_DuplicateSku() {
        ProductSaveDTO product = new ProductSaveDTO(1L, "sku1", new InventorySaveDTO(new ArrayList<>()));
        productService.saveProduct(product);

        // Expected exception with specific message
        assertThrows(BusinessException.class, () -> productService.saveProduct(product));
    }

    @Test
    public void testGetProduct_NonexistentSku() {
        ProductDetailDTO product = productService.getProduct(10L);
        assertNull(product);
    }

}
