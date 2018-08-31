package com.gmail.v.varvaruk89.urltest.services;

import com.gmail.v.varvaruk89.urltest.entities.MyHost;
import com.gmail.v.varvaruk89.urltest.entities.MyResponse;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class MyListenerImpl implements MyListener {

    @Override
    public MyResponse listen(MyHost myHost)  {
        MyResponse myResponse = new MyResponse();
        String resp = "";
        URL url = null;
        try {
            url = new URL(myHost.getMyUrl());
            long milliStart = System.currentTimeMillis();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while (in.readLine() != null) {
                resp =  resp + in.readLine();

            }
            long milliEnd = System.currentTimeMillis();
            myResponse.setResponseTime(milliEnd-milliStart);
            myResponse.setResponseCode(connection.getResponseCode());
            myResponse.setResponseLength(connection.getContentLengthLong());
            myResponse.setContainsWord(checkForWord(resp,myHost.getSearchWord()));
            myResponse.setMyHost(myHost);
            myResponse.setTime(LocalDateTime.now());
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return myResponse;
    }


    private boolean  checkForWord(String line, String word){
        return line.contains(word);
    }


}
