package com.api.rest.api.service;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class DiaUtilService {

    public LocalDate convertDate(String dateReq) throws ParseException {
        SimpleDateFormat format1 = new SimpleDateFormat("ddMMyyyy");
        SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
        String dateFormated = format2.format(format1.parse(dateReq));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        return LocalDate.parse(dateFormated, formatter);
    }

    public static boolean fimDeSemana(LocalDate ld) {
        DayOfWeek d = ld.getDayOfWeek();
        return d == DayOfWeek.SATURDAY || d == DayOfWeek.SUNDAY;
    }

}
