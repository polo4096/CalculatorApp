package polo.edu.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSub, buttonDiv,
            buttonMul, buttonEqual;
    TextView operationTextView, resultTextView;

    float firstValue, secondValue;

    boolean boolAddition, boolSub, boolMul, boolDiv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.button0);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);

        buttonAdd = (Button) findViewById(R.id.button_add);
        buttonSub = (Button) findViewById(R.id.button_sub);
        buttonMul = (Button) findViewById(R.id.button_mul);
        buttonDiv = (Button) findViewById(R.id.button_div);

        buttonEqual = (Button) findViewById(R.id.button_equal);

        operationTextView = (TextView) findViewById(R.id.operation);

        resultTextView = (TextView) findViewById(R.id.result);
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

            case R.id.button_equal:
                secondValue = Float.parseFloat(operationTextView.getText() + "");

                if ( boolAddition) {
                    resultTextView.setText(firstValue+secondValue + "");
                    operationTextView.setText(null);
                    boolAddition= false;
                }else if (boolSub) {
                    resultTextView.setText(firstValue-secondValue + "");
                    operationTextView.setText(null);
                    boolSub= false;
                }else if(boolMul) {
                    resultTextView.setText(firstValue*secondValue + "");
                    operationTextView.setText(null);
                    boolMul= false;
                }else if(boolDiv) {
                    resultTextView.setText(firstValue/secondValue + "");
                    operationTextView.setText(null);
                    boolDiv= false;
                }


                break;






        }
    }
}

