package com.questionpro.grocerybooking.model.db;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@Entity(name = "user_orders")
@NoArgsConstructor
@AllArgsConstructor
public class UserOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userOrderId;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_order_id")
    private Set<OrderedGroceryItem> groceryItems = new HashSet<>();
    private Double totalOrderValue=0.0;
    private Date orderedDate;
}
