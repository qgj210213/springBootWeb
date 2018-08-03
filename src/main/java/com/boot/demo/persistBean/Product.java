package com.boot.demo.persistBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author qiguangjie
 *
 */
@Entity
@Data
@Table(name = "db_product")
public class Product {
    @Id
    @GeneratedValue
    private Integer productId;
    @Column(length = 40)
    private String goodName;
    @Column(length = 20)
    private String goodType;
    @Column(precision = 12, scale = 2)
    private double price;

}
