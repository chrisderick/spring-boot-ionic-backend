package br.gov.df.chris.cg.cursomc.api.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL {
    public static String decodeParam(String s){
        try {
            return URLDecoder.decode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }

    }
    public static List<Integer> decodeInsList(String s) {
        String[] vet = s.split(",");
        List<Integer> list = new ArrayList<>();
        for (String aVet : vet) {
            list.add(Integer.parseInt(aVet));
        }
        return list;
    }
}
