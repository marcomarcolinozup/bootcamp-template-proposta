package br.com.zup.bootcamp.proposta.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum STATUS_PROPOSTA {

    NAO_ELEGIVEL, ELEGIVEL;

}
