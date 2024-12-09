package br.com.blz.testjava.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryEntity {

    private Long quantity;
    private List<WarehouseEntity> warehouses;

}
