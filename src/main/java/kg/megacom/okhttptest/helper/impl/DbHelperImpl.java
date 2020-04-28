package kg.megacom.okhttptest.helper.impl;

import kg.megacom.okhttptest.helper.DbHelper;
import kg.megacom.okhttptest.models.StatusDto;

import java.util.Arrays;
import java.util.List;

public class DbHelperImpl implements DbHelper {

        public List<StatusDto> getStatus() {
        List<StatusDto> statusDtoList= Arrays.asList(
                new StatusDto("Активен"),
                new StatusDto("Закрыт"),
                new StatusDto("Не начат"),
                new StatusDto("Определен победитель")
        );
        return statusDtoList;
    }
}
