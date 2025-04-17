package services;

import lombok.Getter;
import lombok.Setter;
import models.Product;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class SupplyService {
    private final Set<Product> products = new HashSet<>();

    public List<Product> listProduct() {
        return this.products.stream().toList();
    }

}
