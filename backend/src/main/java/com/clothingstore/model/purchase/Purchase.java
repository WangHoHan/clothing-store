package com.clothingstore.model.purchase;

import com.clothingstore.model.ShippingInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Purchase {

    private String shippingMethod;

    private String paymentMethod;

    private ShippingInfo shippingInfo;

    private List<PurchaseContent> orderContentList;
}
