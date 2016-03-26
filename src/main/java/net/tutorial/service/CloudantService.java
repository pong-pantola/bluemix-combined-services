package net.tutorial.service;

import com.cloudant.client.api.*;
import com.cloudant.client.api.model.Response;
import net.tutorial.service.credential.CloudantCredential;
import net.tutorial.utility.InputStreamUtility;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStream;
import java.net.URL;
import java.util.List;


/**
 * Created by pongpantola.
 */
public class CloudantService {
    CloudantClient cloudant;

    public CloudantService(){
        CloudantCredential cloudantCred = new CloudantCredential();
        try {
            cloudant = (CloudantClient) ClientBuilder.url(new URL("https://" + cloudantCred.host + ":" + cloudantCred.port))
                    .username(cloudantCred.username)
                    .password(cloudantCred.password)
                    .build();
        }catch(Exception e){
            System.err.println("CloudantService.CloudantService() Exception: " + e.getMessage());
        }
    }

    public void putJSON(String dbName, String strJSON){
        Database db = cloudant.database(dbName, true);
        JSONParser parser = new JSONParser();


        try {
            JSONObject json = (JSONObject) parser.parse(strJSON);

            Response rs = db.save(json);
        }catch(Exception e){
            System.err.println("CloudantService.putJSON(String dbName, String strJSON) Exception: " + e.getMessage());
        }
    }

    public List<String> getID(String dbName) {
        Database db = cloudant.database(dbName, true);

        List<String> idList = null;
        try{
            idList = db.getAllDocsRequestBuilder().build().getResponse().getDocIds();
        }catch(Exception e){
            System.err.println("CloudantService.getID(String dbName) Exception: " + e.getMessage());
        }

        return idList;
    }

    public String getLast(String dbName){
        List<String> idList = getID(dbName);
        String strJSON = null;

        if (idList.size() > 0) {
            String strID = idList.get(idList.size() - 1);
            Database db = cloudant.database(dbName, true);
            InputStream inStream = db.find(strID);
            strJSON = InputStreamUtility.toString(inStream);
            try{
            inStream.close();
            }catch(Exception e){
                System.err.println("CloudantService.getLast(String dbName) Exception: " + e.getMessage());
            }

        }

        return strJSON;
    }




}
