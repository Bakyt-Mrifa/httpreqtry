package kg.megacom.okhttptest.http;

import kg.megacom.okhttptest.http.impl.HttpClientHelperImpl;
import kg.megacom.okhttptest.models.Lot;

import java.io.IOException;

public interface HttpClientHelper {
    HttpClientHelper INSTANCE=new HttpClientHelperImpl();

    Lot saveLot(Lot lot, String httpPostServer) throws IOException;
    //Lot saveLot(Lot lot) throws IOException;
    Lot getLot(Lot lot);
}
