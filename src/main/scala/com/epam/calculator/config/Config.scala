/*
  author Anastasiya
  created on 27/03/2021
  */

package com.epam.calculator.config

import org.springframework.context.annotation.{Bean, ComponentScan, Configuration}
import org.springframework.web.client.RestTemplate
@Configuration
@ComponentScan
class Config {
  @Bean
  def restTemplate: RestTemplate = {
    new RestTemplate()
  }
}
