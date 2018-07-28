package com.boot.demo.Resourse;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Component
@ConfigurationProperties(prefix = "girl")
@Getter
@Setter
@NoArgsConstructor
public class GirlProperties {

  private String cupSize;
  private int age;
  private int height;

}
