package kg.megacom.okhttptest.helper;

import kg.megacom.okhttptest.helper.impl.DbHelperImpl;
import kg.megacom.okhttptest.models.StatusDto;

import java.util.List;

public interface DbHelper {
    DbHelper INSTANCE=new DbHelperImpl();
    List<StatusDto> getStatus();
}
