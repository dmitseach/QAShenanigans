package com.qaprosoft.dao;

import java.util.List;

import com.qaprosoft.objects.Phone;

public interface PhoneMapper {

	Phone getPhoneById(Integer id);

	List<Phone> getPhones();

}
