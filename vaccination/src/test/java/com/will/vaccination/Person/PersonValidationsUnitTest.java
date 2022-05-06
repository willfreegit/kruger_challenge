package com.will.vaccination.Person;

import com.will.vaccination.person.application.ValidatePersonInputData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonValidationsUnitTest {

    @Test
    public void validateRequiredFieldsOfPersonOK(){
        assertTrue(ValidatePersonInputData.validateRequieredFields("0104112347","wilson vinicio","monge ll","wilson@hotmial.com"));
    }

    @Test
    public void validateRequiredFieldsOfPersonFail(){
        assertFalse(ValidatePersonInputData.validateRequieredFields("0104112347","wilson vinicio",null,"wilson@hotmial.com"));
    }

    @Test
    public void validateCorrectCedula(){
        assertTrue(ValidatePersonInputData.validateCedula("0104112347"));
    }

    @Test
    public void validateIncorrectCedula(){
        assertFalse(ValidatePersonInputData.validateCedula("0104223154"));
    }

    @Test
    public void validateNotNumericalCedula(){
        assertFalse(ValidatePersonInputData.validateCedula("010411234a"));
    }

    @Test
    public void validateEmptyCedula(){
        assertFalse(ValidatePersonInputData.validateCedula(""));
    }

    @Test
    public void validateNullCedula(){
        assertFalse(ValidatePersonInputData.validateCedula(null));
    }

    @Test
    public void validateEmailPersonOK(){
        assertTrue(ValidatePersonInputData.validateEmail("wilson@hotmail.com"));
    }

    @Test
    public void validateEmailPersonFail(){
        assertFalse(ValidatePersonInputData.validateEmail("xxxxxx"));
    }

    @Test
    public void validateEmailEmptyPersonFail(){
        assertFalse(ValidatePersonInputData.validateEmail(""));
    }

    @Test
    public void validateEmailNullPersonFail(){
        assertFalse(ValidatePersonInputData.validateEmail(null));
    }

    @Test
    public void validateNamesOnlyAlphabeticalCharacterOK(){
        assertTrue(ValidatePersonInputData.validateNames("wilson vinicio"));
    }

    @Test
    public void validateNamesOnlyAlphabeticalCharacterFail(){
        assertFalse(ValidatePersonInputData.validateNames("wilson vinicio 666"));
    }

    @Test
    public void validateNamesWithSpecialCharactersOnlyAlphabeticalCharacterFail(){
       assertFalse(ValidatePersonInputData.validateNames("wilson vinício"));
    }

    @Test
    public void validateEmptyNamesOnlyAlphabeticalCharacterFail(){assertFalse(ValidatePersonInputData.validateNames(""));
    }

    @Test
    public void validateNullNamesOnlyAlphabeticalCharacterFail(){
        assertFalse(ValidatePersonInputData.validateNames(null));
    }
}
