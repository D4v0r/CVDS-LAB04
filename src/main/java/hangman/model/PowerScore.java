package hangman.model;

import static com.google.common.math.IntMath.pow;
import hangman.exceptions.HangmanException;

public class PowerScore implements GameScore {
    private final int puntaje = 0;
    private final int limite = 500;

    /**
     * @pre El juego inicia en 0 puntos.
     * @pos El puntaje minimo es 0
     * @param correctCount numero de letras correctas
     * @param incorrectCount numero de letras incorrectas
     * @throws HangmanException.PARAMETROS_NEGATIVOS si correctCount o incorrectCount son negativos.
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount) throws HangmanException {
        if ( correctCount <0 ||  incorrectCount < 0){
            throw new HangmanException(HangmanException.PARAMETROS_NEGATIVOS);
        }
        else if(pow(5,correctCount) < 8*incorrectCount ){
            throw new HangmanException(HangmanException.PARAMETRO_LIMITE_PUNTUACION);
        }
        else if(pow(5,correctCount)-8*incorrectCount>500 ){
            throw new HangmanException(HangmanException.PARAMETRO_LIMITE_PUNTUACION);
        }
        return pow(5,correctCount) - 8*incorrectCount;
    }

    public int getScore() {
        return puntaje;
    }

    public int getLimit(){
        return limite;
    }
}
