package br.com.blz.testjava.dto.detail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDetailDTO {

    private List<WarehouseDetailDTO> warehouses;
    private Long quantity;
}
