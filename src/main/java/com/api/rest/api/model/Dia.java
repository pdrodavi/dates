package com.api.rest.api.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Dia {

    private String data;
    private String diaDaSemana;
    private String util;
    private String msg;

}
