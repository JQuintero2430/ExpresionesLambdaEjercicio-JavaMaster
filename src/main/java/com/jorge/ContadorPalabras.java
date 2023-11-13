package com.jorge;

import java.util.Map;

@FunctionalInterface
public interface ContadorPalabras {
    Map<String, Integer> contar(String texto);
}
