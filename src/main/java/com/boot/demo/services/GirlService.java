package com.boot.demo.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.demo.dao.GirlRepository;
import com.boot.demo.persistBean.Girl;

@Service
public class GirlService {

  @Autowired
  GirlRepository girlRepository;

  @Transactional
  public void insertTwo() {
    Girl girlA = new Girl();
    girlA.setCupSize("F");
    girlA.setAge(15);
    girlRepository.save(girlA);

    Girl girlB = new Girl();
    girlB.setCupSize("C");
    girlB.setAge(16);
    girlRepository.save(girlB);

  }
}
