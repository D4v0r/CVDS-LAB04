package hangman;

import hangman.exceptions.HangmanException;
import hangman.model.GameScore;
import hangman.model.OriginalScore;
import hangman.model.BonusScore;
import hangman.model.PowerScore;
import org.junit.Assert;
import org.junit.Test;

public class GameScoreTest {
    private GameScore score;

    /**
     * Clases de Equivalencia
     * 1. 0>=incorrectCount<=10 & CorrectCount>=0
     * 2. correctCount<0 or incorrectCount<0
     * 3. incorrectCount>10
     */
    @Test
    public void OriginalScoreTest() {
        score = new OriginalScore();

        try {
            //Basados en las fronteras
            score.calculateScore(0, 0);
            score.calculateScore(1, 1);
            score.calculateScore(235, 9);
            score.calculateScore(100, 10);
        } catch (HangmanException e) {
            Assert.fail();
        }

        try {
            score.calculateScore(-1, -1);
            Assert.fail();
        } catch (HangmanException e) {
            Assert.assertEquals(e.getMessage(), HangmanException.PARAMETROS_NEGATIVOS);
        }

        try {
            score.calculateScore(-2, -2);
            Assert.fail();
        } catch (HangmanException e) {
            Assert.assertEquals(e.getMessage(), HangmanException.PARAMETROS_NEGATIVOS);
        }


        try {
            score.calculateScore(0, 11);
            Assert.fail();
        } catch (HangmanException e) {
            Assert.assertEquals(e.getMessage(), HangmanException.PARAMETRO_LIMITE_PUNTUACION);
        }

        try {
            score.calculateScore(0, 12);
            Assert.fail();
        } catch (HangmanException e) {
            Assert.assertEquals(e.getMessage(), HangmanException.PARAMETRO_LIMITE_PUNTUACION);
        }
        try {
            score.calculateScore(20, 11);
            Assert.fail();
        } catch (HangmanException e) {
            Assert.assertEquals(e.getMessage(), HangmanException.PARAMETRO_LIMITE_PUNTUACION);
        }
    }

    /**
     * Clases de Equivalencia
     *  1.correctCount*2 < IncorrectCount
     *  2.correctCount<0 or incorrectCount<0
     *  3.correctCount*2 >= IncorrectCount & CorrectCount>=0 & IncorrectCount >=0
     */
    @Test
    public void bonusScoreTest() {
        score = new BonusScore();

        try {
            score.calculateScore(0, 1);
            Assert.fail();
        } catch (HangmanException e) {
            Assert.assertEquals(e.getMessage(), HangmanException.PARAMETRO_LIMITE_PUNTUACION);
        }
        try {
            score.calculateScore(1, 3);

            Assert.fail();
        } catch (HangmanException e) {
            Assert.assertEquals(e.getMessage(), HangmanException.PARAMETRO_LIMITE_PUNTUACION);
        }


        try {
            score.calculateScore(-2, -2);
            Assert.fail();
        } catch (HangmanException e) {
            Assert.assertEquals(e.getMessage(), HangmanException.PARAMETROS_NEGATIVOS);
        }
        try {
            score.calculateScore(-1, -1);
            Assert.fail();
        } catch (HangmanException e) {
            Assert.assertEquals(e.getMessage(), HangmanException.PARAMETROS_NEGATIVOS);
        }


        try {
            score.calculateScore(1, 0);
            score.calculateScore(1, 1);
            score.calculateScore(1, 2);
            score.calculateScore(0, 0);
            score.calculateScore(2, 0);
        } catch (HangmanException e) {
            Assert.fail();
        }

    }

    /**
     * Clases de Equivalencia
     *  1. 5^CorrectCount < 8*IncorrectCount & (IncorrectCount >=0 & CorrectCount>=0)
     *  2. 5^CorrectCount -8*IncorrectCount > 500 & (IncorrectCount >=0 & CorrectCount>=0)
     *  3. IncorrectCount <0 or CorrectCount<0
     *  4. (5^CorrectCount >= 8*IncorrectCount) & (5^CorrectCount -8*IncorrectCount <= 500) & (IncorrectCount >=0 & CorrectCount >= 0)
     */
    @Test
    public void powerScoreTest(){
        score = new PowerScore();

        try{
            score.calculateScore(0,2);
            Assert.fail();
        }
        catch(HangmanException e){
            Assert.assertEquals(e.getMessage(), HangmanException.PARAMETRO_LIMITE_PUNTUACION);
        }
        try{
            score.calculateScore(0,1);
            Assert.fail();
        }
        catch(HangmanException e){
            Assert.assertEquals(e.getMessage(), HangmanException.PARAMETRO_LIMITE_PUNTUACION);
        }



        try{
            score.calculateScore(4,14);
            Assert.fail();
        }
        catch(HangmanException e){
            Assert.assertEquals(e.getMessage(), HangmanException.PARAMETRO_LIMITE_PUNTUACION);
        }
        try{
            score.calculateScore(4,15);
            Assert.fail();
        }
        catch(HangmanException e){
            Assert.assertEquals(e.getMessage(), HangmanException.PARAMETRO_LIMITE_PUNTUACION);
        }



        try{
            score.calculateScore(-2,0);
            Assert.fail();
        }
        catch(HangmanException e){
            Assert.assertEquals(e.getMessage(), HangmanException.PARAMETROS_NEGATIVOS);
        }
        try{
            score.calculateScore(-1,-1);
            Assert.fail();
        }
        catch(HangmanException e){
            Assert.assertEquals(e.getMessage(), HangmanException.PARAMETROS_NEGATIVOS);
        }



        try{
            score.calculateScore(2,1) ;
            score.calculateScore(0,0) ;
        }
        catch(HangmanException e){
            Assert.fail();
        }


    }
}



