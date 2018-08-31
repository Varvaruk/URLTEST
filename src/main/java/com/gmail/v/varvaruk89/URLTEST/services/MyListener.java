package com.gmail.v.varvaruk89.urltest.services;

import com.gmail.v.varvaruk89.urltest.entities.MyHost;
import com.gmail.v.varvaruk89.urltest.entities.MyResponse;

import java.io.IOException;
import java.net.MalformedURLException;

public interface MyListener {

    MyResponse listen(MyHost myHost) throws IOException;

}
