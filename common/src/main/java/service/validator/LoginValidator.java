package service.validator;

import domain.to.Employee;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/* Validator for Employee entity.
        * Cheks the correctness of Employee object fields using regular expressions.
        * Regular expression for login "[а-яА-ЯёЁa-zA-Z]{2,25}" .
        * Regular expression for password "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$".
        */
public class LoginValidator implements ValidatorInterface<Employee> {

    private static final ValidatorInterface<Employee> instance = new LoginValidator();

    private LoginValidator(){}

    public static ValidatorInterface<Employee> getInstance(){
        return instance;
    }

    private static final String REGULAR_EXP_LOGIN = "[а-яА-Яa-zA-Z]{2,25}";
    private static final String REGULAR_EXP_PASSWORD = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";

    private static final Pattern patternLogin = Pattern.compile(REGULAR_EXP_LOGIN);
    private static final Pattern patternPassword = Pattern.compile(REGULAR_EXP_PASSWORD);

    /* Validates fields of parameter object for correct values.
            *
            * @param employee Employee object which is need to be validated for correctness fields.
            * @return true if validation fields of object was successfully: login contains letters of the Russian and English
     * and no longer than 25 characters,
            * password contains uppercase and lowercase letters of the English language and figures;
     * else false
             */
    @Override
    public boolean isValid(Employee employee) {
        String idRoom = String.valueOf(employee.getLogin());
        String cost = String.valueOf(employee.getPassword());

        Matcher matcherLogin = patternLogin.matcher(idRoom);
        Matcher matcherPassword = patternPassword.matcher(cost);

        return matcherLogin.find() &
                matcherPassword.find();
    }
}
