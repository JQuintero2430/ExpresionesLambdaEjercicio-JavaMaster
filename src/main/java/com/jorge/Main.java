package com.jorge;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ContadorPalabras contador = (frase) -> {
            Map<String, Integer> resultado = new HashMap<>();
            String[] palabras = frase.replace(".", " ")
                    .replace(",", " ")
                    .replace(";", " ")
                    .replace(":", " ")
                    .replace("!", " ")
                    .replace("?", " ")
                    .replace("¿", " ")
                    .toLowerCase()
                    .split(" ");
            for (String palabra : palabras) {
                if (!palabra.isEmpty()) {
                    if (resultado.containsKey(palabra)) {
                        resultado.put(palabra, resultado.get(palabra) + 1);
                    } else {
                        resultado.put(palabra, 1);
                    }
                }
            }
            String keyWithMaxValue = null;
            Integer maxValue = Integer.MIN_VALUE;

            for (Map.Entry<String, Integer> entry : resultado.entrySet()) {
                if (entry.getValue() > maxValue) {
                    maxValue = entry.getValue();
                    keyWithMaxValue = entry.getKey();
                }
            }
            return Collections.singletonMap(keyWithMaxValue, maxValue);
        };
        System.out.println(contador.contar("Santi, santo, salta santi cante santo santi santi"));
    }
}