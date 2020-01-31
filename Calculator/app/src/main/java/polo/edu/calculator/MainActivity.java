package polo.edu.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonEqual;
    TextView operationTextView, resultTextView;

    LinearLayout tab;

    float firstValue, secondValue;

    boolean boolAddition, boolSub, boolMul, boolDiv;

    Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operationTextView = (TextView) findViewById(R.id.operation);

        resultTextView = (TextView) findViewById(R.id.result);

        tab = findViewById(R.id.tab);

        buttonEqual = new Button(this);


        buttonEqual.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                1.0f)
        );
        buttonEqual.setText("=");

        //buttonEqual.setOnClickListener(myEqualHandler());  //Uncomment to use AsyncTask
        buttonEqual.setOnClickListener(mySecondEqualHandler());  //Using Handler


        tab.addView(buttonEqual);

        handler = new Handler();
    }

    //HANDLER
    View.OnClickListener mySecondEqualHandler() {

        return new View.OnClickListener() {
            public void onClick(View v) {
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        String stringTo = "";

                        secondValue = Float.parseFloat(operationTextView.getText() + "");

                        if ( boolAddition) {
                            stringTo = firstValue+secondValue + "";

                            boolAddition= false;
                        }else if (boolSub) {
                            stringTo = firstValue-secondValue + "";
                            boolSub= false;
                        }else if(boolMul) {
                            stringTo = firstValue*secondValue + "";
                            boolMul= false;
                        }else if(boolDiv) {
                            stringTo = firstValue/secondValue + "";
                            boolDiv= false;
                        }

                        final String finalStringTo = stringTo;
                        handler.post(
                                new Runnable() {
                                    @Override
                                    public void run() {

                                        resultTextView.setText(finalStringTo);
                                        operationTextView.setText(null);

                                    }
                                }
                        );
                    }
                };
                new Thread(runnable).start();
            }
        };
    }

    //ASYNC
    View.OnClickListener myEqualHandler()  {
        return new View.OnClickListener() {
            public void onClick(View v) {
                new AsyncEqual().execute();
            }
        };
    }

    private class AsyncEqual extends AsyncTask<Void, Integer, String> {
        protected String doInBackground(Void... vals) {
            String stringTo = "";

            secondValue = Float.parseFloat(operationTextView.getText() + "");

            if ( boolAddition) {
                stringTo = firstValue+secondValue + "";

                boolAddition= false;
            }else if (boolSub) {
                stringTo = firstValue-secondValue + "";
                boolSub= false;
            }else if(boolMul) {
                stringTo = firstValue*secondValue + "";
                boolMul= false;
            }else if(boolDiv) {
                stringTo = firstValue/secondValue + "";
                boolDiv= false;
            }

            return stringTo;
        }
        protected void onProgressUpdate(Integer... progress) {
            //...
        }
        protected void onPostExecute(String result) {

            //Affiche le resultat
            resultTextView.setText(result);
            operationTextView.setText(null);
        }
    }

    public void myClickHandler(View view) {
        switch (view.getId()) {
            case R.id.button1:
                operationTextView.setText(operationTextView.getText() + "1");
                break;
            case R.id.button2:
                operationTextView.setText(operationTextView.getText() + "2");
                break;
            case R.id.button3:
                operationTextView.setText(operationTextView.getText() + "3");
                break;
            case R.id.button4:
                operationTextView.setText(operationTextView.getText() + "4");
                break;
            case R.id.button5:
                operationTextView.setText(operationTextView.getText() + "5");
                break;
            case R.id.button6:
                operationTextView.setText(operationTextView.getText() + "6");
                break;
            case R.id.button7:
                operationTextView.setText(operationTextView.getText() + "7");
                break;
            case R.id.button8:
                operationTextView.setText(operationTextView.getText() + "8");
                break;

                case R.id.button9:
                operationTextView.setText(operationTextView.getText() + "9");
                break;
            case R.id.button0:
                operationTextView.setText(operationTextView.getText() + "0");
                break;


            case R.id.button_add:
                if(operationTextView.getText()==null){
                    operationTextView.setText("");
                }else {
                    firstValue = Float.parseFloat(operationTextView.getText() + "");
                    boolAddition = true;
                    operationTextView.setText("");
                }

                break;

            case R.id.button_sub:
                if(operationTextView.getText()==null){
                    operationTextView.setText("");
                }else {
                    firstValue = Float.parseFloat(operationTextView.getText() + "");
                    boolSub = true;
                    operationTextView.setText("");
                }

                break;

            case R.id.button_mul:
                if(operationTextView.getText()==null){
                    operationTextView.setText("");
                }else {
                    firstValue = Float.parseFloat(operationTextView.getText() + "");
                    boolMul = true;
                    operationTextView.setText("");
                }

                break;

            case R.id.button_div:
                if(operationTextView.getText()==null){
                    operationTextView.setText("");
                }else {
                    firstValue = Float.parseFloat(operationTextView.getText() + "");
                    boolDiv = true;
                    operationTextView.setText("");
                }

                break;


        }
    }
}

