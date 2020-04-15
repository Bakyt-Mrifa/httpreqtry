package kg.megacom.okhttptest.http.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.*;
import kg.megacom.okhttptest.models.Lot;

import java.io.IOException;
import java.util.Date;

public class OkhttpHelper {

    public static OkhttpHelper getInstance() {
        return new OkhttpHelper();
    }

    private ObjectMapper om=new ObjectMapper();
    private OkHttpClient httpClient=new OkHttpClient();

    public void get () throws IOException {
        Request request=new Request.Builder()
                .addHeader("Content-type","application/json")
                .url("http://localhost:8080/lots/get/15")
                .build();
        Response response = httpClient.newCall(request).execute();

        int code=response.code();
        System.out.println("Response code: "+ code);
        if (response.isSuccessful()){
            //System.out.println(response.body().string());
            Lot lot=om.readValue(response.body().string(), Lot.class);
            System.out.println("Lot class type: " + lot);

        }else{
            System.out.println("Произошла ошибка запроса");
        }

    }
   /* public void post() throws Exception {

     Lot lot=new Lot();
     lot.setEndDate(new Date());
     lot.setName("Car");
     lot.setPrice(12000);



        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json"), om.writeValueAsString(lot));
        Request request=new Request.Builder()
                .addHeader("Content-Type", "application/json")
                .url("http://localhost:8080/lots/save")
                .post(requestBody)
                .build();

        Response response=httpClient.newCall(request).execute();

        if (response.isSuccessful()) {
            lot=om.readValue(response.body().string(), Lot.class);
            System.out.println(lot);
        }
    }*/
}
