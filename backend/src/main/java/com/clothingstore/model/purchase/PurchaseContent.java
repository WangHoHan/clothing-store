package com.clothingstore.model.purchase;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PurchaseContent {

    private Long productId;

    private String size;

    private Long quantity;
}
