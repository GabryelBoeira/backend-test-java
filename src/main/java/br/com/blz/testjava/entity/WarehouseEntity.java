package br.com.blz.testjava.entity;

import br.com.blz.testjava.enums.TYPE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseEntity {

    private String locality;
    private Long quantity;
    private TYPE type;
}
