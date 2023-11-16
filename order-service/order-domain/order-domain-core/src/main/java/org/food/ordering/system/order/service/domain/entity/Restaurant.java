package org.food.ordering.system.order.service.domain.entity;

import org.food.ordering.system.domain.entity.AggregateRoot;
import org.food.ordering.system.domain.valueobject.RestaurantId;

import java.util.List;
import java.util.UUID;

public class Restaurant extends AggregateRoot<RestaurantId> {

    private final List<Product> productList;
    private boolean active;

    private Restaurant(Builder builder) {
        super.setId(builder.restaurantId);
        productList = builder.productList;
        active = builder.active;
    }


    public List<Product> getProductList() {
        return productList;
    }

    public boolean isActive() {
        return active;
    }

    public static final class Builder {
        private RestaurantId restaurantId;
        private List<Product> productList;
        private boolean active;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder restaurantId(RestaurantId val) {
            restaurantId = val;
            return this;
        }

        public Builder productList(List<Product> val) {
            productList = val;
            return this;
        }

        public Builder active(boolean val) {
            active = val;
            return this;
        }

        public Restaurant build() {
            return new Restaurant(this);
        }
    }
}
