package com.example.demo.noDI;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BeanDTO {
	String beanName;
	String beanCode;
}
