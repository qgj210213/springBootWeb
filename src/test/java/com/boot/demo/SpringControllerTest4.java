package com.boot.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.boot.demo.controller.SpringController;

import junit.framework.TestCase;

/**
 * @author qiguangjie
 * Junit Test4
 * 1.指明测试什么(@SpringBootTest)-测试功能在哪(classes = SpringController.class)
 * 2.指明进行测试的类是谁@RunWith(SpringJUnit4ClassRunner.class)
 * 3.同WEB整合@WebAppConfiguration
 *
 */
//@SpringBootTest(classes = SpringController.class)
//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SpringControllerTest4 {
  @Autowired
  private SpringController springController;

  /**
   * springController.yes test
   */
  @Test
  public void test001() {
    System.out.println("junit test4");
    TestCase.assertEquals(this.springController.yes(), "hello");
  }

}
