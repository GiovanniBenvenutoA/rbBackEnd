package com.challenge.rb.services;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.challenge.rb.controller.RbController;
import com.challenge.rb.model.Authentication;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;


@Service
public class RbImplementService implements IRbImplementService{
	
	public static final String COL_NAME="users";
	private static Logger log = LoggerFactory.getLogger(RbController.class);
	
	@Override
	public Authentication validationAuth(String idNumber,String pass) throws InterruptedException, ExecutionException {
		
		
		Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(idNumber);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();
        Authentication auth = null;

        if(document.exists()) {
        	auth = document.toObject(Authentication.class);
        	if(auth.getIdNumber().equals(idNumber) && auth.getPassword().equals(pass)) {
        		return auth;
        	}
        	else {
        		return null;
        	}
            
        }else {
            return null;
        }
		
		
		
		
	}
	
	
	
	public Authentication RecoveryPass(String idNumber) throws InterruptedException, ExecutionException {
		
		Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(idNumber);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();
        Authentication auth = null;

        if(document.exists()) {
        	auth = document.toObject(Authentication.class);
            return auth;
        }else {
            return null;
        }
		
	}

}
