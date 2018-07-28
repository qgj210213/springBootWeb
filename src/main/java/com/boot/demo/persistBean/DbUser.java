package com.boot.demo.persistBean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author qiguangjie
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class DbUser {
  @Id
  @GeneratedValue
  private Integer id;
  private String userName;
  private String passWd;
  private String email;
  private String telephone;

}
