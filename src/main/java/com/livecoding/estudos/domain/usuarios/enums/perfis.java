package com.livecoding.estudos.domain.usuarios.enums;

public enum perfis {

    ADMIN(0,"ROLE_ADMIN"),USUARIO(1,"ROLE_USER");

    private Integer codigo;
    private String descricao;

    private perfis(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static perfis toEnum(Integer cod) {
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