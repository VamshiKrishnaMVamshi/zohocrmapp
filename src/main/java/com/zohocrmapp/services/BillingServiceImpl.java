package com.zohocrmapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrmapp.entities.Billing;
import com.zohocrmapp.repositories.BillingRepository;

@Service
public class BillingServiceImpl implements BillingService{
	
	@Autowired
	private BillingRepository billingRepository;

	@Override
	public void saveBill(Billing billing) {
		billingRepository.save(billing);
	}

}
