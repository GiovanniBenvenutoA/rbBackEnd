package com.challenge.rb.services;

import java.util.concurrent.ExecutionException;

import com.challenge.rb.model.Authentication;

public interface IRbImplementService {

	

	Authentication validationAuth(String idNumber, String pass) throws InterruptedException, ExecutionException;

	Authentication RecoveryPass(String idNumber) throws InterruptedException, ExecutionException;

}
