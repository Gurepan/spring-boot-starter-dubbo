package com.alibaba.boot.dubbo.service.impl;

import com.alibaba.boot.dubbo.annotation.Provide;
import org.springframework.stereotype.Component;

import com.alibaba.boot.dubbo.service.IHelloService;
import com.alibaba.dubbo.config.annotation.Service;

@Provide(interfaceClass = IHelloService.class,version = "1.0")
public class HelloServiceImpl implements IHelloService {

  @Override
  public String hello() {
    return "hello";
  }
}
