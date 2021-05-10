package com.example.demo.shared;

import java.util.Collection;

public interface Utils {

    static boolean estaNuloOuVazio(Object valor) {
        return estaNulo(valor) || estaVazio(valor);
    }

    static boolean naoEstaNuloNemVazio(Object valor) {
        return naoEstaNulo(valor) && naoEstaVazio(valor);
    }

    static boolean estaNulo(Object valor) {
        return valor == null;
    }

    static boolean naoEstaNulo(Object valor) {
        return !estaNulo(valor);
    }

    static boolean naoEstaVazio(Object valor) {
        return !estaVazio(valor);
    }

    static boolean estaVazio(Object valor) {
        return valor instanceof Collection ? ((Collection) valor).isEmpty() : "".equals(valor.toString().trim());
    }

}
