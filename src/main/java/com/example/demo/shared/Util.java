package com.example.demo.shared;

import java.util.Collection;

public interface Util {

    static boolean estaNuloOuVazio(Object valor) {
        return estaNulo(valor) || estaVazio(valor);
    }

    static boolean estaNulo(Object valor) {
        return valor == null;
    }

    static boolean estaVazio(Object valor) {
        return valor instanceof Collection ? ((Collection) valor).isEmpty() : "".equals(valor.toString().trim());
    }

}
