package com.yoyo.restfullapi.restfullapi.model;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserRequest {

    //@Size hanya memvalidasi jika data terisi. jika data kosong, ga di divalidasi size nya
    @Size(max = 100)
    private String name;

    @Size(max = 100)
    private String password;
}
