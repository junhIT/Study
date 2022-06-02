package com.example.demo.noDI;

import java.util.List;

public interface BeanRepository {
	List<BeanDTO> search(String q);
	
}
