package kg.megacom.okhttptest.http.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.*;
import kg.megacom.okhttptest.http.HttpClientHelper;
import kg.megacom.okhttptest.models.Lot;

import java.io.IOException;

public class HttpClientHelperImpl implements HttpClientHelper {
    private ObjectMapper om=new ObjectMapper();
    private OkHttpClient okHttpClient=new OkHttpClient();
    public Lot saveLot(Lot lot, String httpPostServer) throws IOException {
            RequestBody requestBody=RequestBody.create(MediaType.parse("application/json"), om.writeValueAsString(lot));

            Request request=new Request.Builder()
                    .addHeader("Content-Type", "application/json")
                    .url(httpPostServer)
                    .post(requestBody)
                    .build();

            Response response=okHttpClient.newCall(request).execute();
            int code=response.code();
        System.out.println("Код запроса: "+code+" - Успешно!!!");

            if (response.isSuccessful()) {
                lot=om.readValue(response.body().string(), Lot.class);
                System.out.println("После метода saveLot: "+lot);
            }else {
                System.out.println("Произошла системная ошибка!");
            }
        return lot;
    }

    public Lot getLot(Lot lot) {
        return null;
    }
}
