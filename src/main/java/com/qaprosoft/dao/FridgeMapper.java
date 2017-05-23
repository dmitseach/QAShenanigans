package com.qaprosoft.dao;

import java.util.List;

import com.qaprosoft.objects.Fridge;

public interface FridgeMapper {

	Fridge getFridgeById(Integer id);

	List<Fridge> getFridges();

}
