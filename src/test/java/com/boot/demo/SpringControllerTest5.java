package com.boot.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.boot.demo.controller.SpringController;

import junit.framework.TestCase;

//@SpringBootTest(classes=SpringController.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
//@WebAppConfiguration
public class SpringControllerTest5 {
  @Autowired
  private SpringController springController;

  @Test

  public void test001() {
    System.out.println("junit test5");
    TestCase.assertEquals(this.springController.say(), "qgj");
  }
}
