package com.boot.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.demo.dao.GirlRepository;
import com.boot.demo.persistBean.Girl;
import com.boot.demo.services.GirlService;

@RestController
@RequestMapping("girl")
public class GirlController {

  @Autowired
  private GirlRepository girlRepository;
  @Autowired
  private GirlService girlservice;

  /**
   * 検索女生リスト全部
   * @return
   */
  @GetMapping(value = "/girls")
  public List<Girl> girlList() {

    return girlRepository.findAll();

  }

  /**
   * 女生情報を追加ｓ
   * @param i_cupSize
   * @param i_age
   * @return
   */
  @PostMapping(value = "/girls")
  public Girl girlAdd(@RequestParam("cupSize") String cupSize,
      @RequestParam("age") Integer age) {

    Girl girl = new Girl();
    girl.setCupSize(cupSize);
    girl.setAge(age);

    return girlRepository.save(girl);
  }

  /*検索1つ女生*/
  @GetMapping(value = "/girls/{id}")
  public Optional<Girl> girlFindById(@PathVariable("id") Integer id) {
    //    Object ob = girlRepository.findById(id);
    //    Girl girl = new Girl();
    //    girl = (Girl) ob;
    return girlRepository.findById(id);
  }

  /*更新*/
  @PutMapping(value = "/girls/{id}")
  public Girl girlUpdate(@PathVariable("id") Integer id,
      @RequestParam("cupSize") String i_cupSize,
      @RequestParam("age") Integer i_age) {
    Girl girl = new Girl();
    girl.setId(id);
    girl.setCupSize(i_cupSize);
    girl.setAge(i_age);
    return girlRepository.save(girl);
  }

  /*削除*/
  @DeleteMapping(value = "/girls/{id}")
  public void girlDelete(@PathVariable("id") Integer id) {
    girlRepository.deleteById(id);
  }

  /*通过年龄查询*/
  @GetMapping(value = "/girls/age/{age}")
  public List<Girl> girlFindByAge(@PathVariable("age") Integer age) {
    return girlRepository.findByAge(age);

  }

  /* 二件を挿入する */

  @PutMapping(value = "/girls/two")
  public void insertTwo() {
    girlservice.insertTwo();
  }
}
