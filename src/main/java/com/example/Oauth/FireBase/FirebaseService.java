package com.example.Oauth.FireBase;

import com.example.Database.UserData;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class FirebaseService {

    public void saveUser(String email,String googleID, String name,String photo,String iat) throws ExecutionException, InterruptedException{
        System.out.println("In fireservice");
        Firestore dbFirestore = FirestoreClient.getFirestore();
        UserData userData = new UserData(email,googleID,true,name,photo,iat);
        dbFirestore.collection("User").document(googleID).set(userData);

    }

}
