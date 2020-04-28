package kg.megacom.okhttptest.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class StatusDto {
    private Long id;
    @NonNull
    private String name;
    @Override
    public String toString(){
        return name;
    }


}
