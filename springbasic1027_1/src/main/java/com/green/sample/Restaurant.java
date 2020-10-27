package com.green.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Restaurant {

	@Setter(onMethod_ = @Autowired) //�ڵ�����(autowired) setter �̿��Ͽ�
	private Chef chef; // Restaurant ������� chef�� �������� �˾Ƽ� ����(Inject)
	
	
}
