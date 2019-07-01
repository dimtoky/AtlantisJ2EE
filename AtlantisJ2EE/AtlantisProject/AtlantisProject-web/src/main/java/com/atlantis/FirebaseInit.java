/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlantis;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author root
 */
@ApplicationScoped
public class FirebaseInit {

    FirebaseInit() {
        FileInputStream firebasefile = null;
        try {
            firebasefile = new FileInputStream("/var/local/atlantisfirebaseadminsdk.json");
            System.out.println(firebasefile);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(firebasefile))
                    .setDatabaseUrl("https://atlantis-49d9d.firebaseio.com")
                    .build();
            FirebaseApp.initializeApp(options);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FirebaseInit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FirebaseInit.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }

}
