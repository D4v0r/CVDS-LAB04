package hangman.model;

import hangman.exceptions.HangmanException;


public class OriginalScore implements GameScore {
    private final int puntaje = 100;
    private final int limite = 100;

    /**
     *
     *
     * @pre El juego inicia en 100 puntos.
     * @pos El puntaje mínimo es 0
     * @param correctCount numero de letras correctas.
     * @param incorrectCount numero de letras incorrectas.
     * @throws HangmanException.PARAMETROS_NEGATIVOS si correctCount o incorrectCount son negativos.
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount) throws  HangmanException{
        if(incorrectCount >10){
            throw new HangmanException(HangmanException.PARAMETRO_LIMITE_PUNTUACION);
        }
        if(incorrectCount <0 || incorrectCount <0 ){
            throw new HangmanException(HangmanException.PARAMETROS_NEGATIVOS);
        }
        return puntaje-(incorrectCount*-10);
    }

    public int getScore() {
        return puntaje;
    }

    public int getLimit() {
        return limite;
    }
}
