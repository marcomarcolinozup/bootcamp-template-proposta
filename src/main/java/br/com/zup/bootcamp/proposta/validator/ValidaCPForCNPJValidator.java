package br.com.zup.bootcamp.proposta.validator;

import br.com.zup.bootcamp.proposta.model.PropostaEntity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class ValidaCPForCNPJValidator implements ConstraintValidator<ValidaCPForCNPJ, String> {

    public void initialize(PropostaEntity contactInfo) {
     }

    private Pattern patternCpf = Pattern.compile("\\d{11}");
    private Pattern patternCnpj = Pattern.compile("\\d{14}");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(patternCpf.matcher(value).find() ){
            return ValidaCPF.isCPF(value);
        }
        if(patternCnpj.matcher(value).find()){
            return ValidaCNPJ.isCNPJ(value);
        }
        return false;
    }
}
