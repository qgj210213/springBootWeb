package com.boot.demo.Resourse;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author qiguangjie
 * 画面で表示のメッセージ
 * application-prod.yml中でmessage内容を配置
 *
 */

@Component
@ConfigurationProperties(prefix="message")
@Getter
@Setter
@NoArgsConstructor
public class Message {
  public String errorInfo;
  public String okInfo;
  public String reistInfo;
}
