package br.com.lbr.beerApi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BeerType {

    PILSEN("Pilsen"),
    BOCK("Bock"),
    WITBIER("Witbier"),
    WEISSBIER("Weissbier"),
    IPA("American IPA"),
    JUICY("Juicy"),
    STOUT("Stout");

    private final String description;
}
