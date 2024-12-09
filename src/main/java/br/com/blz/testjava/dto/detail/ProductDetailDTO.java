package br.com.blz.testjava.dto.detail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailDTO {

    private Long sku;
    private String name;
    private InventoryDetailDTO inventory;
    private Boolean isMarketable;

}
