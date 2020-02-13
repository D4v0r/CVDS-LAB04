package hangman.model;

import hangman.exceptions.HangmanException;

public interface GameScore {

    /**
     * @param correctCount numero de letras correctas
     * @param incorrectCount numero de letras incorrectas
     * @throws HangmanException.PARAMETROS_NEGATIVOS si correctCount o incorrectCount son negativos.
     */
    int calculateScore(int correctCount, int incorrectCount) throws HangmanException;

}

