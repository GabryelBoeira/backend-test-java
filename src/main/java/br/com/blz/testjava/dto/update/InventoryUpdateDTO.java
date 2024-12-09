package br.com.blz.testjava.dto.update;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record InventoryUpdateDTO(

    @Valid
    @NotNull
    List<WarehouseUpdateDTO> warehouses
) {
}
