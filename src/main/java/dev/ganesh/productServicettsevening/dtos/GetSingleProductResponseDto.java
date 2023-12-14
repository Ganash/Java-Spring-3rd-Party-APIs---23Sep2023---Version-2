package dev.ganesh.productServicettsevening.dtos;

import dev.ganesh.productServicettsevening.models.Product;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GetSingleProductResponseDto {

    private Product product;

}
