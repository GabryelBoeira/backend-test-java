package br.com.blz.testjava.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

    private Long sku;
    private String name;
    private InventoryEntity inventory;
    private Boolean isMarketable;

}
