package kg.megacom.okhttptest.helper.impl;

import kg.megacom.okhttptest.helper.DbHelper;
import kg.megacom.okhttptest.models.StatusDto;

import java.util.ArrayList;
import java.util.List;

public class DbHelperImpl implements DbHelper {
    StatusDto statusDtoActive = new StatusDto();
    StatusDto statusDtoNoActive = new StatusDto();

        public List<StatusDto> getStatus() {

            statusDtoActive.setId(1l);
            statusDtoActive.setName("Active");

            statusDtoNoActive.setId(2l);
            statusDtoNoActive.setName("NoActive");

        List<StatusDto> statusDtoList=new ArrayList<StatusDto>();
        statusDtoList.add(statusDtoActive);
        statusDtoList.add(statusDtoNoActive);
        return statusDtoList;
    }
}
