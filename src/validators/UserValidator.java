package validators;

public class UserValidator {
    public static boolean isEmailValid(String email){
        if (email == null || email.isEmpty()) return false;

        int indexAt = email.indexOf('@');

        if (indexAt <= 0 || indexAt != email.lastIndexOf('@')) return false;


        int indexFirstDotAfterAt = email.indexOf('.', indexAt);
        if (email.indexOf('.',indexAt) == -1 || indexFirstDotAfterAt == indexAt +1) return false;

        if (email.lastIndexOf('.') >= email.length() -2) return false;

        if (!Character.isAlphabetic(email.charAt(0))) return false;

        boolean isCharAlphbetic = Character.isAlphabetic(email.charAt(0));

        if(!isCharAlphbetic) return false;

        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);


            boolean isCharValid = (Character.isAlphabetic(c)
                    || Character.isDigit(c)
                    || c == '-'
                    || c == '_'
                    || c == '.'
                    || c == '@');

            if (!isCharValid) return false;



        }

        return true;
    }

    public static boolean isPasswordValid(String password){
        if (password == null || password.isEmpty()) return false;

        if (password.length() < 8){
            return false;
        }

        boolean isLowerCase = false;
        boolean isUpperCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (int i = 0; i < password.length(); i++) {
            char a = password.charAt(i);

            if (Character.isLowerCase(a)){
                isLowerCase = true;
                continue;
            }

            if (Character.isUpperCase(a)) {
                isUpperCase = true;
                continue;
            }

            if (Character.isDigit(a)) {
                hasDigit = true;
                continue;
            }

            if ("!%$@&*()[]".indexOf(a) >= 0) {
                hasSpecialChar = true;
                continue;
            }


        }

        return isLowerCase && isUpperCase && hasDigit && hasSpecialChar;
    }
}
