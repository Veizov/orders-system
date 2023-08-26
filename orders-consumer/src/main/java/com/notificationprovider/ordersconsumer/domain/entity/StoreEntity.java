package com.notificationprovider.ordersconsumer.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Cacheable(value = false)
@Table(name = "store", schema = "orders")
public class StoreEntity implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "review_url")
    private String reviewUrl;

}
