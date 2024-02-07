package com.livecoding.estudos.domain.usuarios.enums;

public enum perfis {

    ADMIN("0","ROLE_ADMIN"),USUARIO("1","ROLE_USER"), USER_DIARIA_PJ("2", "ROLE_DIARIA_PJ");

    private String codigo;
    private String descricao;

    private perfis(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static perfis toEnum(String cod) {
        if(cod == null) {
            return null;
        }

        for (perfis x: perfis.values()) {
            if(cod.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Perfil Inválido");
    }



}