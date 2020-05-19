package com.ibm.handsOn.convertcurrency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.handsOn.convertcurrency.service.CurrencyConverterService;

@RestController
@RequestMapping(path = "/currencyconverter")
public class CurrencyConverterController {
	
	@Autowired
	private CurrencyConverterService currencyConverterService;
	
	@GetMapping("/converttorupee/{countrycode}/{amount}")
	public String convertToRupee(@PathVariable("countrycode") String countryCode,
			@PathVariable("amount") double amount)
	{
		
		String amountInRupees = currencyConverterService.convertToRupee(countryCode,amount);
		StringBuilder tmpReturn = new StringBuilder("Amount of ")
				.append(amount)
				.append(" in ")
				.append(countryCode)
				.append(" is equivalent to ")
				.append( amountInRupees)
				.append(" Rupees.");
		return tmpReturn.toString();
	}

}
