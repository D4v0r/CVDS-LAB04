package hangman.model;

import hangman.model.GameScore;

public class OriginalScore implements GameScore {

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
    public int calculateScore(int correctCount, int incorrectCount) {
        return 0;
    }
}
