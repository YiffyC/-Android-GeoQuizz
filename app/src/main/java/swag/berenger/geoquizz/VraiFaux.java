package swag.berenger.geoquizz;

/**
 * Created by YiffyCupcake on 10/11/2016.
 */
public class VraiFaux {

    private int mQuestion;
    private boolean mQuestionVraie;

    //Constructeur
    public VraiFaux(int question, boolean questionVraie)
    {
        mQuestion = question;
        mQuestionVraie = questionVraie;

    }

    public int getQuestion() {
        return mQuestion;
    }

    public boolean isQuestionVraie() {
        return mQuestionVraie;
    }

    public void setQuestion(int question) {
        mQuestion = question;
    }

    public void setQuestionVraie(boolean questionVraie) {
        mQuestionVraie = questionVraie;
    }
}
