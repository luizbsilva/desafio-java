package br.com.globo.desafio.domain.enums;

public enum ProfileEnum {
    ROLE_NULL(0),
    ROLE_INTEGRATION(1);


    ProfileEnum(int codeRole) {
    }

    public static ProfileEnum fromInteger(int codeRole) {
        switch (codeRole) {

            case 1:
                return ProfileEnum.ROLE_INTEGRATION;
        }
        return ROLE_NULL;
    }
}
