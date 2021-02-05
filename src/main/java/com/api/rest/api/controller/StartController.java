package com.api.rest.api.controller;

import com.api.rest.api.model.Dia;
import com.api.rest.api.service.DiaUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.time.LocalDate;

@RestController
@RequestMapping(value = "/api")
public class StartController {

    @Autowired
    DiaUtilService diaUtilService;

    @GetMapping(value = "/check-day/{data}")
    public Dia checkDia(@PathVariable("data") String req) throws ParseException {

        if (req.length() != 8){
            return Dia.builder().msg("ERRO! Data tem que conter 8 caracteres. Ex: DDMMAAAA").build();
        }

        LocalDate date = diaUtilService.convertDate(req);

        String day = date.getDayOfWeek().name();

        String dia = switch (day) {
            case "SUNDAY" -> "Domingo";
            case "SATURDAY" -> "Sábado";
            case "MONDAY" -> "Segunda";
            case "TUESDAY" -> "Terça";
            case "WEDNESDAY" -> "Quarta";
            case "THURSDAY" -> "Quinta";
            case "FRIDAY" -> "Sexta";
            default -> "";
        };

        if (DiaUtilService.fimDeSemana(date)){
            return Dia.builder().data(date.toString()).diaDaSemana(dia).util("Não").msg("OK").build();
        }

        return Dia.builder().data(date.toString()).diaDaSemana(dia).util("Sim").msg("OK").build();
    }

}
