package hangman.exceptions;

public class HangmanException extends Exception {
    public static  String PARAMETROS_NEGATIVOS = "Los parametros no pueden ser negativos.";
    public static final String PARAMETRO_LIMITE_PUNTUACION = "Hay un parametro que supera la puntuacion limite";

    public HangmanException(String message){
        super(message);
    }
}
