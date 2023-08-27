package com.notificationprovider.ordersconsumer.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Cacheable(value = false)
@Table(name = "order", schema = "orders")
public class OrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private StoreEntity store;

    @Column(name = "external_id")
    private Long externalId;

    @Column(name = "shopper_email")
    private String shopperEmail;

    @Column(name = "shopper_first_name")
    private String shopperFirstName;

    @Column(name = "shopper_last_name")
    private String shopperLastName;

    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @Column(name = "date_ordered")
    private LocalDateTime dateOrdered;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductEntity> products;

}
