package com.example.simpleandroidcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Double ans = null;
    public Double number1 = 0.0;
    public Double number2 = 0.0;
    public Integer num;
    public char[] operatorArray = {' ', '+', '-', '*', '/'};
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btn_delete, btn_eq, btn_multi, btn_div, btn_sub, btn_plus, btn_dell, btn_ac;
    TextView display;


    public int op;

    
    public String separate(CharSequence reading, char operator) {
        /* This method takes out the next operand when called */
        StringBuilder nextNum = new StringBuilder(reading);
        nextNum.delete(0, reading.toString().indexOf(operator) + 1);
        return nextNum.toString();
    }

    public String decimalCtrl(Double a) {
        // Format decimal numbers for displaying
        int sp = 0;
        String temp2 = a.toString();
        Integer iv = a.intValue();
        int b = iv.toString().length();
        for (int i = b + 1; i < temp2.length() - 2; i++) {

            if (temp2.charAt(i) == temp2.charAt(i + 1) && temp2.charAt(i + 1) == temp2.charAt(i + 2)) {
                sp = i;
                break;
            }
        }
        if (sp > 0) {
            int scale = (int) Math.pow(10, sp - b + 1);
            return String.valueOf(Math.floor(a * scale) / scale);
        } else {
            return temp2;
        }
    }

    public boolean checkForOp(String store, int op) {
        // chacks whether an operator is present in a display reading
        boolean opishere = false;
        for (int i = 0; i < store.length(); i++) {
            if (operatorArray[op] == store.charAt(i)) {
                opishere = true;
                break;
            }
        }
        return opishere;
    }

    public boolean duplicatedSym(Double num1, int ind, CharSequence disp) {
        //checks 'operand1+operator' is present
        num = num1.intValue();
        return ((disp.toString().equals(number1.toString() + operatorArray[ind]))) || (((disp.toString().equals(num.toString() + operatorArray[ind]))));

    }

    public void acAction() {
        // procedure for AC button is pressed(clear all)
        ans = null;
        op = 0;
        number1 = 0.0;
        number2 = 0.0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MainActivity object1 = new MainActivity();

        final Toast toast = Toast.makeText(getApplicationContext(), "Syntax Eror!", Toast.LENGTH_LONG);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);
        btn_delete = findViewById(R.id.btn_delete);
        btn_eq = findViewById(R.id.btn_eq);
        btn_multi = findViewById(R.id.btn_Multi);
        btn_div = findViewById(R.id.btn_div);
        btn_sub = findViewById(R.id.btn_sub);
        btn_plus = findViewById(R.id.btn_plus);
        btn_dell = findViewById(R.id.btn_dell);
        btn_ac = findViewById(R.id.btn_ac);

        display = findViewById(R.id.txt_disp);

        display.setText("");
        //programming buttons
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "1");

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "9");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "0");
            }
        });


        //operator buttons

        //plus operator
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op = 1;
                if (ans == null) {
                    if (object1.duplicatedSym(number1, op, display.getText())) {
                    } else {
                        try {
                            number1 = Double.parseDouble(display.getText().toString());
                            display.setText(display.getText() + "+");
                        } catch (NumberFormatException e) {
                            object1.acAction();
                            display.setText("");
                            toast.show();
                        }
                    }
                } else {
                    number1 = ans;
                    display.setText(ans.toString() + "+");
                }

            }
        });

        //Minus operator
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op = 2;
                if (ans == null) {
                    if (object1.duplicatedSym(number1, op, display.getText())) {
                    } else {
                        try {
                            number1 = Double.parseDouble(display.getText().toString());
                            display.setText(display.getText() + "-");
                        } catch (NumberFormatException e) {
                            object1.acAction();
                            display.setText("");
                            toast.show();
                        }
                    }
                } else {
                    number1 = ans;
                    display.setText(ans.toString() + "-");
                }

            }
        });

        // Multiplication operator
        btn_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op = 3;
                if (ans == null) {
                    if (object1.duplicatedSym(number1, op, display.getText())) {
                    } else {
                        try {
                            number1 = Double.parseDouble(display.getText().toString());
                            display.setText(display.getText() + "*");
                        } catch (NumberFormatException e) {
                            object1.acAction();
                            display.setText("");
                            toast.show();
                        }
                    }
                } else {
                    number1 = ans;
                    display.setText(ans.toString() + "*");
                }

            }
        });

        // Division operator
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op = 4;
                if (ans == null) {
                    if (object1.duplicatedSym(number1, op, display.getText())) {
                    } else {
                        try {
                            number1 = Double.parseDouble(display.getText().toString());
                            display.setText(display.getText() + "/");
                        } catch (NumberFormatException e) {
                            object1.acAction();
                            display.setText("");
                            toast.show();
                        }
                    }
                } else {
                    number1 = ans;
                    display.setText(ans.toString() + "/");
                }

            }
        });


        //equals button
        btn_eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    number2 = Double.parseDouble(object1.separate(display.getText(), operatorArray[op]));
                } catch (NumberFormatException e) {
                    object1.acAction();
                    display.setText("");
                    toast.show();
                }
                // performing the operation
                switch (op) {
                    case 1:
                        ans = number1 + number2;
                        break;
                    case 2:
                        ans = number1 - number2;
                        break;
                    case 3:
                        ans = number1 * number2;
                        break;
                    case 4:
                        ans = number1 / number2;
                        break;
                    default:
                        ans = 0.0;
                }
                //check whether the answer has decimal points or not
                if (ans % 1 == 0) {
                    Integer ansInt = ans.intValue();
                    display.setText(display.getText() + "=" + ansInt.toString());
                } else {
                    display.setText(display.getText() + "=" + object1.decimalCtrl(ans));
                }
            }
        });

        // Deleting one character
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int length = display.getText().length();
                int num = display.getText().length() - 1;
                String store;
                if (length > 0) {
                    StringBuilder back = new StringBuilder(display.getText());
                    back.deleteCharAt(num);
                    store = back.toString();
                    display.setText(store);
                    //reset the number1 input when a character is backspaced
                    if (!object1.checkForOp(store, op)) {
                        number1 = 0.0;
                    }
                }
                if (length == 1 || length == 0) {
                    ans = null;
                    display.setText("");
                }
            }
        });
        
        // AC button
        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean ok = false;
                if (display.getText().equals("2000630")) {
                    ok = true;
                }
                ans = null;
                display.setText("");
                op = 0;
                number1 = 0.0;
                if (ok) {
                    display.setText("© Oshan_Sandeep(2023/09/19)");
                }
            }
        });

        // . button
        btn_dell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp;
                if (number1 != 0.0) {
                    temp = object1.separate(display.getText(), operatorArray[op]);
                } else {
                    temp = display.getText().toString();
                }
                boolean flag = true;
                char dot = '.';
                for (int i = 0; i < temp.length(); i++) {
                    if (dot == temp.charAt(i)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    display.setText(display.getText() + ".");
                }
            }
        });

    }
}