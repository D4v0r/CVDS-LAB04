package hangman.model;

import hangman.exceptions.HangmanException;

public class BonusScore implements GameScore {
    private static int puntaje = 0;
    /**
     *
     *
     * @pre El juego inicia en 0 puntos.
     * @pos El puntaje minimo es 0
     * @param  correctCount numero de letras correctas
     * @param incorrectCount numero de letras incorrectas
     * @throws HangmanException.PARAMETROS_NEGATIVOS si correctCount o incorrectCount son negativos.
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount) throws HangmanException {

       if(correctCount < 0 || incorrectCount < 0){
           throw new HangmanException(HangmanException.PARAMETROS_NEGATIVOS);
       } else if(correctCount*2<incorrectCount){
           throw new HangmanException(HangmanException.PARAMETRO_LIMITE_PUNTUACION);
       }
       return correctCount*10-incorrectCount*5;
    }


    public int getScore() {
        return puntaje;
    }


    public int getLimit() {
        return 0;
    }
}
