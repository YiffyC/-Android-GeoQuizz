package swag.berenger.geoquizz;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //Variables
    private Button mBoutonVrai, mBoutonFaux, mBoutonSuivant;
    private TextView mQuestionTextView;

    //Tableau de questions avec les bonnes reponses
    private VraiFaux[] mTabQuestions = new VraiFaux[]
            {
                new VraiFaux(R.string.question_oceans, true),
                new VraiFaux(R.string.question_africa, false),
                new VraiFaux(R.string.question_americas, true),
                new VraiFaux(R.string.question_asia, true),
                new VraiFaux(R.string.question_mideast, false),
            };

    //Index pour parourir le tableau
    private int mIndexActuel = 0;


    private void majQuestions()
    {
        int question = mTabQuestions[mIndexActuel].getQuestion();
        mQuestionTextView.setText(question);
    }

    private void verifierReponse(boolean userVrai)
    {
        boolean reponseVraie = mTabQuestions[mIndexActuel].isQuestionVraie();

        int messReponseId =0;

        if(userVrai == reponseVraie)
        {
            messReponseId = R.string.toast_correct;
        }
        else
        {
            messReponseId = R.string.toast_faux;
        }

        Toast.makeText(MainActivity.this, messReponseId, Toast.LENGTH_SHORT).show();
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Lien avec la textview
        mQuestionTextView = (TextView)findViewById(R.id.QuestionTextView);
        int question = mTabQuestions[mIndexActuel].getQuestion(); //Le getQuestions() recupere le texte de la question
        //^ int ici car l'id est de type entier
        mQuestionTextView.setText(question);


        mBoutonVrai = (Button)findViewById(R.id.bouton_vrai);
        mBoutonVrai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(true);
            }
        });


        mBoutonVrai = (Button)findViewById(R.id.bouton_suivant);
        mBoutonVrai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mIndexActuel = (mIndexActuel+1)% mTabQuestions.length;
                int question = mTabQuestions[mIndexActuel].getQuestion();
                mQuestionTextView.setText(question);
            }
        });


        mBoutonFaux = (Button)findViewById(R.id.bouton_faux);

        mBoutonFaux.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               verifierReponse(false);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
