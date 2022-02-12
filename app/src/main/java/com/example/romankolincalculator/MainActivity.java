package com.example.romankolincalculator;

import                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.text.SpannableStringBuilder;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    SharedPreferences savedresult;
    String RESULT = "Result";
    String MEMORY = "Memory";

    EditText editTextNumberDecimal1firstnum;
    EditText editTextNumberDecimal2afteroperation;
    EditText editTextNumberDecimal3beforeoperation;
    EditText editTextNumberDecimal4secondnum;
    TextView textView5plusminus;
    TextView textView6degree;
    TextView textView2memory;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumberDecimal1firstnum = findViewById(R.id.editTextNumberDecimal1firstnum);
        editTextNumberDecimal2afteroperation = findViewById(R.id.editTextNumberDecimal2afteroperation);
        editTextNumberDecimal3beforeoperation = findViewById(R.id.editTextNumberDecimal3beforeoperation);
        editTextNumberDecimal4secondnum = findViewById(R.id.editTextNumberDecimal4secondnum);
        textView5plusminus = findViewById(R.id.textView5plusminus);
        textView6degree = findViewById(R.id.textView6degree);
        textView2memory = findViewById(R.id.textView2memory);

        editTextNumberDecimal1firstnum.setShowSoftInputOnFocus(false);
        editTextNumberDecimal2afteroperation.setShowSoftInputOnFocus(false);
        editTextNumberDecimal3beforeoperation.setShowSoftInputOnFocus(false);
        editTextNumberDecimal4secondnum.setShowSoftInputOnFocus(false);

        savedresult = getPreferences(MODE_PRIVATE);
        String RESULTs = savedresult.getString(RESULT, "");
        editTextNumberDecimal1firstnum.setText(RESULTs);
        String MEMORYs = savedresult.getString(MEMORY, "");
        textView2memory.setText(MEMORYs);
    }

    public void cursfnum(String cursfnum)
    {
        int curs = editTextNumberDecimal1firstnum.getSelectionStart();
        String oldcurs = editTextNumberDecimal1firstnum.getText().toString();
        String cursl = oldcurs.substring(0, curs);
        String cursr = oldcurs.substring(curs);
        editTextNumberDecimal1firstnum.setText(String.format("%s%s%s", cursl, cursfnum, cursr));
        editTextNumberDecimal1firstnum.setSelection(curs + 1);
    }
    public void curssnum(String curssnum)
    {
        int curs = editTextNumberDecimal4secondnum.getSelectionStart();
        String oldcurs = editTextNumberDecimal4secondnum.getText().toString();
        String cursl = oldcurs.substring(0, curs);
        String cursr = oldcurs.substring(curs);
        editTextNumberDecimal4secondnum.setText(String.format("%s%s%s", cursl, curssnum, cursr));
        editTextNumberDecimal4secondnum.setSelection(curs + 1);
    }

    public void onclickfocusfnum(View focus)
    {
        editTextNumberDecimal1firstnum.setFocusableInTouchMode(true);
        editTextNumberDecimal3beforeoperation.setFocusable(false);
        editTextNumberDecimal4secondnum.setFocusable(false);
    }
    public void onclickfocussnum(View focus)
    {
        editTextNumberDecimal4secondnum.setFocusableInTouchMode(true);
        editTextNumberDecimal1firstnum.setFocusable(false);
        editTextNumberDecimal2afteroperation.setFocusable(false);
    }

    @SuppressLint("NonConstantResourceId")
    public void onclicknumber(View number)
    {
        editTextNumberDecimal1firstnum.setHint("");

        if (editTextNumberDecimal1firstnum.hasFocusable())
        {
            if (editTextNumberDecimal1firstnum.getSelectionStart() == 0)
            {
                editTextNumberDecimal1firstnum.setSelection(editTextNumberDecimal1firstnum.getText().toString().length());
            }

            switch (number.getId())
            {
                case R.id.button11:
                    cursfnum("1");
                    break;
                case R.id.button22:
                    cursfnum("2");
                    break;
                case R.id.button33:
                    cursfnum("3");
                    break;
                case R.id.button44:
                    cursfnum("4");
                    break;
                case R.id.button55:
                    cursfnum("5");
                    break;
                case R.id.button66:
                    cursfnum("6");
                    break;
                case R.id.button77:
                    cursfnum("7");
                    break;
                case R.id.button88:
                    cursfnum("8");
                    break;
                case R.id.button99:
                    cursfnum("9");
                    break;
                case R.id.button100:
                    cursfnum("0");
                    break;
                case R.id.button11dot:
                    if (!editTextNumberDecimal1firstnum.getText().toString().contains("."))
                    {
                        if (editTextNumberDecimal1firstnum.getText().toString().equals(""))
                        {
                            cursfnum("0.");
                            editTextNumberDecimal1firstnum.setSelection(editTextNumberDecimal1firstnum.getText().toString().length());
                        }
                        else
                        {
                            cursfnum(".");
                        }
                    }
                    break;
                case R.id.button12plusminus:
                    if (editTextNumberDecimal1firstnum.getText().toString().equals(""))
                    {
                        editTextNumberDecimal1firstnum.setHint(R.string.hint0);
                    }
                    else if (editTextNumberDecimal1firstnum.getText().toString().equals("π"))
                    {
                        editTextNumberDecimal1firstnum.setText("-π");
                    }
                    else if (editTextNumberDecimal1firstnum.getText().toString().equals("-π"))
                    {
                        editTextNumberDecimal1firstnum.setText("π");
                    }
                    else if (editTextNumberDecimal1firstnum.getText().toString().equals("e"))
                    {
                        editTextNumberDecimal1firstnum.setText("-e");
                    }
                    else if (editTextNumberDecimal1firstnum.getText().toString().equals("-e"))
                    {
                        editTextNumberDecimal1firstnum.setText("e");
                    }
                    else
                    {
                        double cfnum = Double.parseDouble(editTextNumberDecimal1firstnum.getText().toString());
                        double nfnum = cfnum - cfnum * 2;
                        editTextNumberDecimal1firstnum.setText(String.valueOf(nfnum));
                        char[] zero = editTextNumberDecimal1firstnum.getText().toString().toCharArray();
                        if (zero[zero.length - 1] == '0' && zero[zero.length - 1] == '0')
                        {
                            editTextNumberDecimal1firstnum.setText(editTextNumberDecimal1firstnum.getText().toString().replace(".0", ""));
                        }
                    }
                    editTextNumberDecimal1firstnum.setSelection(0);
                    break;
                case R.id.button36pi:
                    if (editTextNumberDecimal1firstnum.getText().toString().length() == 0)
                    {
                        cursfnum("π");
                    }
                    break;
                case R.id.button37e:
                    if (editTextNumberDecimal1firstnum.getText().toString().length() == 0)
                    {
                        cursfnum("e");
                    }
                    break;
                case R.id.button41memoryplus:
                case R.id.button42memoryminus:
                    double mp;
                    double a;
                    double res = 0;

                    if (editTextNumberDecimal1firstnum.getText().toString().equals(""))
                    {
                        editTextNumberDecimal1firstnum.setHint("0");
                    }
                    else if (editTextNumberDecimal1firstnum.getText().toString().equals("π"))
                    {
                        if (textView2memory.getText().toString().length() == 0)
                        {
                            textView2memory.setText("π");
                        }
                    }
                    else if (editTextNumberDecimal1firstnum.getText().toString().equals("e"))
                    {
                        if (textView2memory.getText().toString().length() == 0)
                        {
                            textView2memory.setText("e");
                        }
                    }
                    else if (editTextNumberDecimal1firstnum.getText().toString().equals("-π"))
                    {
                        if (textView2memory.getText().toString().length() == 0)
                        {
                            textView2memory.setText("-π");
                        }
                    }
                    else if (editTextNumberDecimal1firstnum.getText().toString().equals("-e"))
                    {
                        if (textView2memory.getText().toString().length() == 0)
                        {
                            textView2memory.setText("-e");
                        }
                    }
                    else if (editTextNumberDecimal1firstnum.getText().toString().contains("Error"))
                    {
                        editTextNumberDecimal1firstnum.setText(R.string.error);
                    }
                    else if (editTextNumberDecimal1firstnum.getText().toString().contains("Infinity"))
                    {
                        editTextNumberDecimal1firstnum.setText(R.string.infinity);
                    }
                    else if (textView2memory.getText().toString().length() == 0)
                    {
                        a = Double.parseDouble(editTextNumberDecimal1firstnum.getText().toString());
                        mp = a;
                        textView2memory.setText(String.valueOf(mp));
                        textView2memory.setText(textView2memory.getText().toString().replace(",", ""));
                        char[] zero = textView2memory.getText().toString().toCharArray();
                        if (zero[zero.length - 1] == '0' && zero[zero.length - 1] == '0')
                        {
                            textView2memory.setText(textView2memory.getText().toString().replace(".0", ""));
                        }
                    }
                    else
                    {
                        if (textView2memory.getText().toString().equals("π"))
                        {
                            mp = Math.PI;
                        }
                        else if (textView2memory.getText().toString().equals("e"))
                        {
                            mp = Math.E;
                        }
                        else if (textView2memory.getText().toString().equals("-π"))
                        {
                            mp = -Math.PI;
                        }
                        else if (textView2memory.getText().toString().equals("-e"))
                        {
                            mp = -Math.E;
                        }
                        else
                        {
                            mp = Double.parseDouble(textView2memory.getText().toString());
                        }
                        a = Double.parseDouble(editTextNumberDecimal1firstnum.getText().toString());

                        if (number.getId() == R.id.button41memoryplus)
                        {
                            res = a + mp;
                        }
                        if (number.getId() == R.id.button42memoryminus)
                        {
                            res = a - mp;
                        }
                        editTextNumberDecimal1firstnum.setText(String.valueOf(res));
                        editTextNumberDecimal1firstnum.setText(editTextNumberDecimal1firstnum.getText().toString().replace(",", ""));
                        char[] zero = editTextNumberDecimal1firstnum.getText().toString().toCharArray();
                        if (zero[zero.length - 1] == '0' && zero[zero.length - 1] == '0')
                        {
                            editTextNumberDecimal1firstnum.setText(editTextNumberDecimal1firstnum.getText().toString().replace(".0", ""));
                        }
                    }
                    break;
                case R.id.button43memoryread:
                    if (textView2memory.getText().toString().equals(""))
                    {
                        editTextNumberDecimal1firstnum.setHint(R.string.hint0);
                    }
                    else
                    {
                        editTextNumberDecimal1firstnum.setText(textView2memory.getText());
                    }
                    break;
                case R.id.button44memoryclear:
                    if (textView2memory.getText().toString().equals(""))
                    {
                        editTextNumberDecimal1firstnum.setHint(R.string.hint0);
                    }
                    else
                    {
                        textView2memory.setText("");
                        editTextNumberDecimal1firstnum.setHint(R.string.hint0);
                    }
                    break;
            }
        }
        else if (editTextNumberDecimal4secondnum.hasFocusable())
        {
            if (editTextNumberDecimal4secondnum.getSelectionStart() == 0)
            {
                editTextNumberDecimal4secondnum.setSelection(editTextNumberDecimal4secondnum.getText().toString().length());
            }

            switch (number.getId())
            {
                case R.id.button11:
                    curssnum("1");
                    break;
                case R.id.button22:
                    curssnum("2");
                    break;
                case R.id.button33:
                    curssnum("3");
                    break;
                case R.id.button44:
                    curssnum("4");
                    break;
                case R.id.button55:
                    curssnum("5");
                    break;
                case R.id.button66:
                    curssnum("6");
                    break;
                case R.id.button77:
                    curssnum("7");
                    break;
                case R.id.button88:
                    curssnum("8");
                    break;
                case R.id.button99:
                    curssnum("9");
                    break;
                case R.id.button100:
                    curssnum("0");
                    break;
                case R.id.button11dot:
                    if (!editTextNumberDecimal4secondnum.getText().toString().contains("."))
                    {
                        if (editTextNumberDecimal4secondnum.getText().toString().equals(""))
                        {
                            curssnum("0.");
                            editTextNumberDecimal4secondnum.setSelection(editTextNumberDecimal4secondnum.getText().toString().length());
                        }
                        else
                        {
                            curssnum(".");
                        }
                    }
                    break;
                case R.id.button12plusminus:
                    if (editTextNumberDecimal4secondnum.getText().toString().equals(""))
                    {
                        editTextNumberDecimal4secondnum.setHint(R.string.hint0);
                    }
                    else if (editTextNumberDecimal4secondnum.getText().toString().equals("π"))
                    {
                        editTextNumberDecimal4secondnum.setText("-π");
                    }
                    else if (editTextNumberDecimal4secondnum.getText().toString().equals("-π"))
                    {
                        editTextNumberDecimal4secondnum.setText("π");
                    }
                    else if (editTextNumberDecimal4secondnum.getText().toString().equals("e"))
                    {
                        editTextNumberDecimal4secondnum.setText("-e");
                    }
                    else if (editTextNumberDecimal4secondnum.getText().toString().equals("-e"))
                    {
                        editTextNumberDecimal4secondnum.setText("e");
                    }
                    else
                    {
                        double csnum = Double.parseDouble(editTextNumberDecimal4secondnum.getText().toString());
                        double nsnum = csnum - csnum * 2;
                        editTextNumberDecimal4secondnum.setText(String.valueOf(nsnum));
                        char[] zero = editTextNumberDecimal4secondnum.getText().toString().toCharArray();
                        if (zero[zero.length - 1] == '0' && zero[zero.length - 1] == '0')
                        {
                            editTextNumberDecimal4secondnum.setText(editTextNumberDecimal4secondnum.getText().toString().replace(".0", ""));
                        }
                    }
                    editTextNumberDecimal4secondnum.setSelection(0);
                    break;
                case R.id.button36pi:
                    if (editTextNumberDecimal4secondnum.getText().toString().length() == 0)
                    {
                        curssnum("π");
                    }
                    break;
                case R.id.button37e:
                    if (editTextNumberDecimal4secondnum.getText().toString().length() == 0)
                    {
                        curssnum("e");
                    }
                    break;
            }

            editTextNumberDecimal2afteroperation.setFocusable(false);
        }
    }

    @SuppressLint("NonConstantResourceId")
    public void onclickoperationanum(View operationanum)
    {
        textView5plusminus.setText("");

        editTextNumberDecimal2afteroperation.getLayoutParams().width = ViewGroup.LayoutParams.WRAP_CONTENT;
        editTextNumberDecimal2afteroperation.requestLayout();

        if (editTextNumberDecimal2afteroperation.getText().toString().length() == 0 && editTextNumberDecimal3beforeoperation.getText().toString().length() == 0)
        {
            switch (operationanum.getId())
            {
                case R.id.button13addition:
                case R.id.button14subtraction:
                case R.id.button15multiplication:
                case R.id.button16division:
                    if (operationanum.getId() == R.id.button13addition)
                    {
                        editTextNumberDecimal2afteroperation.setText("+");
                    }
                    if (operationanum.getId() == R.id.button14subtraction)
                    {
                        editTextNumberDecimal2afteroperation.setText("−");
                    }
                    if (operationanum.getId() == R.id.button15multiplication)
                    {
                        editTextNumberDecimal2afteroperation.setText("×");
                    }
                    if (operationanum.getId() == R.id.button16division)
                    {
                        editTextNumberDecimal2afteroperation.setText("÷");
                    }
                    editTextNumberDecimal1firstnum.setFocusable(false);
                    editTextNumberDecimal4secondnum.setFocusable(true);

                    if (editTextNumberDecimal1firstnum.getText().toString().equals(""))
                    {
                        editTextNumberDecimal1firstnum.setText("0");
                    }
                    break;
                case R.id.button19seconddegree:
                case R.id.button20thirddegree:
                    if (operationanum.getId() == R.id.button19seconddegree)
                    {
                        editTextNumberDecimal2afteroperation.setText("2");
                    }
                    if (operationanum.getId() == R.id.button20thirddegree)
                    {
                        editTextNumberDecimal2afteroperation.setText("3");
                    }
                    editTextNumberDecimal2afteroperation.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
                    editTextNumberDecimal2afteroperation.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
                    editTextNumberDecimal2afteroperation.requestLayout();
                    editTextNumberDecimal1firstnum.setFocusable(true);
                    break;
                case R.id.button18nroot:
                    editTextNumberDecimal2afteroperation.setText("√");
                    LinearLayout.LayoutParams weigfnumnroot = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT, 1);
                    editTextNumberDecimal1firstnum.setLayoutParams(weigfnumnroot);
                    LinearLayout.LayoutParams weigsnumnroot = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    editTextNumberDecimal4secondnum.setLayoutParams(weigsnumnroot);
                    editTextNumberDecimal1firstnum.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
                    editTextNumberDecimal1firstnum.setGravity(Gravity.END);
                    editTextNumberDecimal1firstnum.setHint("0");
                    editTextNumberDecimal4secondnum.setGravity(Gravity.START);
                    editTextNumberDecimal4secondnum.setHint("0");
                    if (editTextNumberDecimal1firstnum.getText().toString().length() > 0)
                    {
                        editTextNumberDecimal1firstnum.setFocusable(false);
                        editTextNumberDecimal4secondnum.setFocusable(true);
                    }
                    else
                    {
                        editTextNumberDecimal1firstnum.setFocusable(true);
                    }
                    break;
                case R.id.button21ndegree:
                    LinearLayout.LayoutParams weigoperanumndegree = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0);
                    editTextNumberDecimal2afteroperation.setLayoutParams(weigoperanumndegree);
                    LinearLayout.LayoutParams weigsnumndegree = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
                    editTextNumberDecimal4secondnum.setLayoutParams(weigsnumndegree);
                    editTextNumberDecimal4secondnum.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
                    editTextNumberDecimal4secondnum.setHint("0");
                    if (editTextNumberDecimal1firstnum.getText().toString().length() > 0)
                    {
                        editTextNumberDecimal1firstnum.setFocusable(false);
                        editTextNumberDecimal4secondnum.setFocusable(true);
                    }
                    break;
                case R.id.button25factorial:
                case R.id.button26doublefactorial:
                    if (operationanum.getId() == R.id.button25factorial)
                    {
                        editTextNumberDecimal2afteroperation.setText("!");
                    }
                    if (operationanum.getId() == R.id.button26doublefactorial)
                    {
                        editTextNumberDecimal2afteroperation.setText("!!");
                    }
                    editTextNumberDecimal1firstnum.setFocusable(true);
                    break;
                case R.id.button35percent:
                    editTextNumberDecimal2afteroperation.setText("%");
                    editTextNumberDecimal4secondnum.setFocusable(true);
                    editTextNumberDecimal1firstnum.setFocusable(false);
                    break;
            }
        }

        editTextNumberDecimal4secondnum.getLayoutParams().width = ViewGroup.LayoutParams.WRAP_CONTENT;
        editTextNumberDecimal4secondnum.requestLayout();

        editTextNumberDecimal2afteroperation.setFocusableInTouchMode(true);
    }

    @SuppressLint("NonConstantResourceId")
    public void onclickoperationbnum(View operationbnum)
    {
        textView5plusminus.setText("");
        LinearLayout.LayoutParams weigplusminus = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0);
        textView5plusminus.setLayoutParams(weigplusminus);

        LinearLayout.LayoutParams weigbnum = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        editTextNumberDecimal1firstnum.setLayoutParams(weigbnum);
        LinearLayout.LayoutParams weigoperbnum = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT, 1);
        editTextNumberDecimal3beforeoperation.setLayoutParams(weigoperbnum);

        if (editTextNumberDecimal3beforeoperation.getText().toString().length() == 0 && editTextNumberDecimal2afteroperation.getText().toString().length() == 0)
        {
            switch (operationbnum.getId())
            {
                case R.id.button17squareroot:
                    editTextNumberDecimal3beforeoperation.setText("√");
                    break;
                case R.id.button22logarithm:
                    editTextNumberDecimal3beforeoperation.setText(R.string.button22logarithm);
                    LinearLayout.LayoutParams weigfnumlog = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
                    editTextNumberDecimal1firstnum.setLayoutParams(weigfnumlog);
                    LinearLayout.LayoutParams weigoperanumlog = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT, 0);
                    editTextNumberDecimal2afteroperation.setLayoutParams(weigoperanumlog);
                    LinearLayout.LayoutParams weiglog = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT, 1);
                    editTextNumberDecimal3beforeoperation.setLayoutParams(weiglog);
                    LinearLayout.LayoutParams weigsnumlog = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
                    editTextNumberDecimal4secondnum.setLayoutParams(weigsnumlog);
                    editTextNumberDecimal1firstnum.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
                    editTextNumberDecimal1firstnum.setGravity(Gravity.BOTTOM);
                    editTextNumberDecimal4secondnum.setGravity(Gravity.START);
                    editTextNumberDecimal4secondnum.setHint("0");
                    break;
                case R.id.button23decimallogarithm:
                    editTextNumberDecimal3beforeoperation.setText(R.string.button23decimallogarithm);
                    break;
                case R.id.button24naturallogarithm:
                    editTextNumberDecimal3beforeoperation.setText(R.string.button24naturallogarithm);
                    break;
                case R.id.button27sin:
                case R.id.button28cos:
                case R.id.button29tan:
                case R.id.button30cot:
                    if (operationbnum.getId() == R.id.button27sin)
                    {
                        editTextNumberDecimal3beforeoperation.setText(R.string.button27sin);
                    }
                    if (operationbnum.getId() == R.id.button28cos)
                    {
                        editTextNumberDecimal3beforeoperation.setText(R.string.button28cos);
                    }
                    if (operationbnum.getId() == R.id.button29tan)
                    {
                        editTextNumberDecimal3beforeoperation.setText(R.string.button29tan);
                    }
                    if (operationbnum.getId() == R.id.button30cot)
                    {
                        editTextNumberDecimal3beforeoperation.setText(R.string.button30cot);
                    }
                    textView6degree.setText("°");
                    LinearLayout.LayoutParams weignumdegree = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    editTextNumberDecimal1firstnum.setLayoutParams(weignumdegree);
                    LinearLayout.LayoutParams weigdegree = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    textView6degree.setLayoutParams(weigdegree);
                    break;
                case R.id.button31arcsin:
                    editTextNumberDecimal3beforeoperation.setText(R.string.button31arcsin);
                    break;
                case R.id.button32arccos:
                    editTextNumberDecimal3beforeoperation.setText(R.string.button32arccos);
                    break;
                case R.id.button33arctan:
                    editTextNumberDecimal3beforeoperation.setText(R.string.button33arctan);
                    break;
                case R.id.button34arccot:
                    editTextNumberDecimal3beforeoperation.setText(R.string.button34arccot);
                    break;
            }
            if (editTextNumberDecimal1firstnum.getText().toString().length() > 0)
            {
                editTextNumberDecimal1firstnum.setFocusable(false);
                editTextNumberDecimal4secondnum.setFocusable(true);
            }
            else
            {
                editTextNumberDecimal1firstnum.setFocusable(true);
            }
        }

        editTextNumberDecimal3beforeoperation.setFocusableInTouchMode(true);
    }

    public void onclickequal(View result)
    {
        editTextNumberDecimal1firstnum.setTextSize(TypedValue.COMPLEX_UNIT_SP, 72);
        editTextNumberDecimal2afteroperation.setTextSize(TypedValue.COMPLEX_UNIT_SP, 72);
        editTextNumberDecimal4secondnum.setTextSize(TypedValue.COMPLEX_UNIT_SP, 72);
        editTextNumberDecimal4secondnum.setHint("");
        textView6degree.setText("");

        try
        {
            if (editTextNumberDecimal1firstnum.getText().toString().equals(""))
            {
                editTextNumberDecimal1firstnum.setText("0");
            }
            else if (editTextNumberDecimal1firstnum.getText().toString().contains("Error"))
            {
                editTextNumberDecimal1firstnum.setText(R.string.error);
            }
            else if (editTextNumberDecimal1firstnum.getText().toString().contains("Infinity"))
            {
                editTextNumberDecimal1firstnum.setText(R.string.infinity);
            }
            else if (editTextNumberDecimal4secondnum.getText().toString().length() == 0 && editTextNumberDecimal2afteroperation.getText().toString().length() == 0 && editTextNumberDecimal3beforeoperation.getText().toString().length() == 0)
            {
                if (editTextNumberDecimal1firstnum.getText().toString().equals("π"))
                {
                    editTextNumberDecimal1firstnum.setText(String.valueOf(Math.PI));
                }
                else if (editTextNumberDecimal1firstnum.getText().toString().equals("e"))
                {
                    editTextNumberDecimal1firstnum.setText(String.valueOf(Math.E));
                }
                else if (editTextNumberDecimal1firstnum.getText().toString().equals("-π"))
                {
                    editTextNumberDecimal1firstnum.setText(String.valueOf(-Math.PI));
                }
                else if (editTextNumberDecimal1firstnum.getText().toString().equals("-e"))
                {
                    editTextNumberDecimal1firstnum.setText(String.valueOf(-Math.E));
                }
                else
                {
                    editTextNumberDecimal1firstnum.setText(editTextNumberDecimal1firstnum.getText().toString());
                }
            }
            else if (editTextNumberDecimal1firstnum.getText().length() > 0 && editTextNumberDecimal4secondnum.getText().toString().length() > 0)
            {
                double a = 0;
                double b = 0;
                double res = 0;

                if (editTextNumberDecimal1firstnum.getText().toString().contains("π") || editTextNumberDecimal1firstnum.getText().toString().contains("e") || editTextNumberDecimal4secondnum.getText().toString().contains("π") || editTextNumberDecimal4secondnum.getText().toString().contains("e"))
                {
                    switch (editTextNumberDecimal1firstnum.getText().toString())
                    {
                        case "π":
                            a = Double.parseDouble(editTextNumberDecimal1firstnum.getText().toString().replace("π",String.valueOf(Math.PI)));
                            break;
                        case "e":
                            a = Double.parseDouble(editTextNumberDecimal1firstnum.getText().toString().replace("e",String.valueOf(Math.E)));
                            break;
                        case "-π":
                            a = Double.parseDouble(editTextNumberDecimal1firstnum.getText().toString().replace("-π",String.valueOf(-Math.PI)));
                            break;
                        case "-e":
                            a = Double.parseDouble(editTextNumberDecimal1firstnum.getText().toString().replace("-e",String.valueOf(-Math.E)));
                            break;
                    }
                    switch (editTextNumberDecimal4secondnum.getText().toString())
                    {
                        case "π":
                            b = Double.parseDouble(editTextNumberDecimal4secondnum.getText().toString().replace("π", String.valueOf(Math.PI)));
                            break;
                        case "e":
                            b = Double.parseDouble(editTextNumberDecimal4secondnum.getText().toString().replace("e", String.valueOf(Math.E)));
                            break;
                        case "-π":
                            b = Double.parseDouble(editTextNumberDecimal4secondnum.getText().toString().replace("-π",String.valueOf(-Math.PI)));
                            break;
                        case "-e":
                            b = Double.parseDouble(editTextNumberDecimal4secondnum.getText().toString().replace("-e",String.valueOf(-Math.E)));
                            break;
                    }

                    if ((a == Math.PI || a == -Math.PI || a == Math.E || a == -Math.E) && !(b == Math.PI || b == -Math.PI || b == Math.E || b == -Math.E))
                    {
                        b = Double.parseDouble(editTextNumberDecimal4secondnum.getText().toString());
                    }
                    if (!(a == Math.PI || a == -Math.PI || a == Math.E || a == -Math.E) && (b == Math.PI || b == -Math.PI || b == Math.E || b == -Math.E))
                    {
                        a = Double.parseDouble(editTextNumberDecimal1firstnum.getText().toString());
                    }
                }
                else
                {
                    a = Double.parseDouble(editTextNumberDecimal1firstnum.getText().toString());
                    b = Double.parseDouble(editTextNumberDecimal4secondnum.getText().toString());
                }

                switch (editTextNumberDecimal2afteroperation.getText().toString())
                {
                    case "+":
                        res = a + b;
                        break;
                    case "−":
                        res = a - b;
                        break;
                    case "×":
                        res = a * b;
                        break;
                    case "÷":
                        if (b == 0)
                        {
                            editTextNumberDecimal1firstnum.setText(R.string.error);
                        }
                        else
                        {
                            res = a / b;
                        }
                        break;
                    case "√":
                        if (a % 2 == 0 && a > 0 && b > 0)
                        {
                            res = Math.pow(b, 1/a);
                            textView5plusminus.setText("±");
                            LinearLayout.LayoutParams weigfnumplusminus = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                            editTextNumberDecimal1firstnum.setLayoutParams(weigfnumplusminus);
                            LinearLayout.LayoutParams weigplusminus = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
                            textView5plusminus.setLayoutParams(weigplusminus);
                        }
                        else if (a % 2 == 1 && a > 0 && b < 0)
                        {
                            res = -Math.pow(Math.abs(b), 1/a);
                        }
                        else if (a % 2 == 1 && a > 0 && b > 0)
                        {
                            res = Math.pow(b, 1/a);
                        }
                        else
                        {
                            editTextNumberDecimal1firstnum.setText(R.string.error);
                        }
                        break;
                    case "%":
                        if (editTextNumberDecimal1firstnum.getText().toString().equals("π") || editTextNumberDecimal1firstnum.getText().toString().equals("e"))
                        {
                            res = (b * a) / 100;
                        }
                        else if (Double.parseDouble(editTextNumberDecimal1firstnum.getText().toString()) <= 100 && Double.parseDouble(editTextNumberDecimal1firstnum.getText().toString()) >= 0)
                        {
                            res = (b * a) / 100;
                        }
                        else
                        {
                            editTextNumberDecimal1firstnum.setText(R.string.error);
                        }
                        break;
                }
                if (editTextNumberDecimal2afteroperation.getText().toString().length() == 0)
                {
                    res = Math.pow(a, b);
                }
                if (editTextNumberDecimal3beforeoperation.getText().toString().equals("log"))
                {
                    if (a <= 0 || a == 1 || b <= 0)
                    {
                        editTextNumberDecimal1firstnum.setText(R.string.error);
                    }
                    else
                    {
                        res = Math.log(b) / Math.log(a);
                    }
                }
                if (!editTextNumberDecimal1firstnum.getText().toString().equals("Error"))
                {
                    editTextNumberDecimal1firstnum.setText(String.valueOf(res));
                }
            }
            else
            {
                double a = 0;
                double res = 1;

                if (editTextNumberDecimal1firstnum.getText().toString().contains("π") || editTextNumberDecimal1firstnum.getText().toString().contains("e"))
                {
                    switch (editTextNumberDecimal1firstnum.getText().toString())
                    {
                        case "π":
                            a = Double.parseDouble(editTextNumberDecimal1firstnum.getText().toString().replace("π", String.valueOf(Math.PI)));
                            break;
                        case "e":
                            a = Double.parseDouble(editTextNumberDecimal1firstnum.getText().toString().replace("e", String.valueOf(Math.E)));
                            break;
                        case "-π":
                            a = Double.parseDouble(editTextNumberDecimal1firstnum.getText().toString().replace("-π", String.valueOf(-Math.PI)));
                            break;
                        case "-e":
                            a = Double.parseDouble(editTextNumberDecimal1firstnum.getText().toString().replace("-e", String.valueOf(-Math.E)));
                            break;
                    }
                }
                else
                {
                    a = Double.parseDouble(editTextNumberDecimal1firstnum.getText().toString());
                }

                if (editTextNumberDecimal1firstnum.getText().length() > 0 && editTextNumberDecimal3beforeoperation.getText().toString().length() == 0)
                {
                    switch (editTextNumberDecimal2afteroperation.getText().toString())
                    {
                        case "2":
                            res = Math.pow(a, 2);
                            break;
                        case "3":
                            res = Math.pow(a, 3);
                            break;
                        case "!":
                            if (a < 0 || editTextNumberDecimal1firstnum.getText().toString().contains(".") || editTextNumberDecimal1firstnum.getText().toString().contains("π") || editTextNumberDecimal1firstnum.getText().toString().contains("e"))
                            {
                                editTextNumberDecimal1firstnum.setText(R.string.error);
                            }
                            else
                            {
                                for (int aint = (int)a; aint > 1; aint--)
                                {
                                    if (aint == (int)a)
                                    {
                                        res = aint;
                                    }
                                    res *= aint - 1;
                                }
                            }
                            break;
                        case "!!":
                            if (a < 0 || editTextNumberDecimal1firstnum.getText().toString().contains(".") || editTextNumberDecimal1firstnum.getText().toString().contains("π") || editTextNumberDecimal1firstnum.getText().toString().contains("e"))
                            {
                                editTextNumberDecimal1firstnum.setText(R.string.error);
                            }
                            else
                            {
                                if (Integer.parseInt(editTextNumberDecimal1firstnum.getText().toString()) % 2 == 0)
                                {
                                    if (a == 2)
                                    {
                                        res = a;
                                    }
                                    else
                                    {
                                        for (int aint = (int)a; aint > 2; aint -= 2)
                                        {
                                            if (aint == (int)a)
                                            {
                                                res = aint;
                                            }
                                            res *= aint - 2;
                                        }
                                    }
                                }
                                else
                                {
                                    for (int aint = (int)a; aint > 1; aint -= 2)
                                    {
                                        if (aint == Integer.parseInt(editTextNumberDecimal1firstnum.getText().toString()))
                                        {
                                            res = aint;
                                        }
                                        res *= aint - 2;
                                    }
                                }
                            }
                            break;
                        case "%":
                            if (editTextNumberDecimal1firstnum.getText().toString().equals("π") || editTextNumberDecimal1firstnum.getText().toString().equals("e"))
                            {
                                res = a / 100;
                            }
                            else if (Double.parseDouble(editTextNumberDecimal1firstnum.getText().toString()) <= 100 && Double.parseDouble(editTextNumberDecimal1firstnum.getText().toString()) >= 0)
                            {
                                res = a / 100;
                            }
                            else
                            {
                                editTextNumberDecimal1firstnum.setText(R.string.error);
                            }
                            break;
                    }
                    if (!editTextNumberDecimal1firstnum.getText().toString().equals("Error"))
                    {
                        editTextNumberDecimal1firstnum.setText(String.valueOf(res));
                    }
                }
                else if (editTextNumberDecimal3beforeoperation.getText().length() > 0)
                {
                    switch (editTextNumberDecimal3beforeoperation.getText().toString())
                    {
                        case "√":
                            if (a < 0)
                            {
                                editTextNumberDecimal1firstnum.setText(R.string.error);
                            }
                            else
                            {
                                res = Math.sqrt(a);
                            }
                            break;
                        case "lg":
                        case "ln":
                            if (a <= 0)
                            {
                                editTextNumberDecimal1firstnum.setText(R.string.error);
                            }
                            else
                            {
                                if (editTextNumberDecimal3beforeoperation.getText().toString().equals("lg"))
                                {
                                    res = Math.log10(a);
                                }
                                if (editTextNumberDecimal3beforeoperation.getText().toString().equals("ln"))
                                {
                                    res = Math.log(a);
                                }
                            }
                            break;
                        case "sin":
                        case "cos":
                        case "tan":
                        case "cot":
                            if (a == Math.PI || a == -Math.PI)
                            {
                                a = Math.toDegrees(a);
                            }
                            if (editTextNumberDecimal3beforeoperation.getText().toString().equals("sin"))
                            {
                                res = Math.sin(Math.toRadians(a));
                            }
                            if (editTextNumberDecimal3beforeoperation.getText().toString().equals("cos"))
                            {
                                res = Math.cos(Math.toRadians(a));
                            }
                            if (editTextNumberDecimal3beforeoperation.getText().toString().equals("tan"))
                            {
                                res = Math.tan(Math.toRadians(a));
                            }
                            if (editTextNumberDecimal3beforeoperation.getText().toString().equals("cot"))
                            {
                                res = 1 / Math.tan(Math.toRadians(a));
                            }
                            break;
                        case "asin":
                        case "acos":
                        case "atan":
                        case "acot":
                            if (editTextNumberDecimal3beforeoperation.getText().toString().equals("atan"))
                            {
                                res = Math.toDegrees(Math.atan(a));
                            }
                            else if (editTextNumberDecimal3beforeoperation.getText().toString().equals("acot"))
                            {
                                res = 90 - Math.toDegrees(Math.atan(a));
                            }
                            else
                            {
                                if (a < -1 || a > 1)
                                {
                                    editTextNumberDecimal1firstnum.setText(R.string.error);
                                }
                                else
                                {
                                    if (editTextNumberDecimal3beforeoperation.getText().toString().equals("asin"))
                                    {
                                        res = Math.toDegrees(Math.asin(a));
                                    }
                                    if (editTextNumberDecimal3beforeoperation.getText().toString().equals("acos"))
                                    {
                                        res = Math.toDegrees(Math.acos(a));
                                    }
                                }
                            }
                            break;
                    }
                    if (!editTextNumberDecimal1firstnum.getText().toString().equals("Error"))
                    {
                        editTextNumberDecimal1firstnum.setText(String.valueOf(res));
                    }
                }
            }
            if (!editTextNumberDecimal1firstnum.getText().toString().equals("Error"))
            {
                double res = Double.parseDouble(editTextNumberDecimal1firstnum.getText().toString());
                editTextNumberDecimal1firstnum.setText(String.valueOf(res));
                char[] zero = editTextNumberDecimal1firstnum.getText().toString().toCharArray();
                if (zero[zero.length - 1] == '0' && zero[zero.length - 1] == '0')
                {
                    editTextNumberDecimal1firstnum.setText(editTextNumberDecimal1firstnum.getText().toString().replace(".0", ""));
                }
            }
            if (editTextNumberDecimal1firstnum.getText().toString().equals("-0"))
            {
                editTextNumberDecimal1firstnum.setText("0");
            }
            editTextNumberDecimal1firstnum.setText(editTextNumberDecimal1firstnum.getText().toString().replace("∞", "Infinity"));
            editTextNumberDecimal1firstnum.setText(editTextNumberDecimal1firstnum.getText().toString().replace(",", ""));

            editTextNumberDecimal2afteroperation.setText("");
            editTextNumberDecimal3beforeoperation.setText("");
            editTextNumberDecimal4secondnum.setText("");
        }
        catch (Exception unexpected)
        {
            editTextNumberDecimal1firstnum.setText(R.string.error);
        }

        editTextNumberDecimal1firstnum.setFocusable(true);
        editTextNumberDecimal1firstnum.setSelection(0);
    }

    @SuppressLint("NonConstantResourceId")
    public void onclickclear(View clear)
    {
        if (editTextNumberDecimal1firstnum.getSelectionStart() == 0)
        {
            editTextNumberDecimal1firstnum.setSelection(editTextNumberDecimal1firstnum.getText().toString().length());
        }
        switch (clear.getId())
        {
            case R.id.button40clear:
                editTextNumberDecimal1firstnum.setText("");
                editTextNumberDecimal1firstnum.setHint("0");
                editTextNumberDecimal2afteroperation.setText("");
                editTextNumberDecimal3beforeoperation.setText("");
                editTextNumberDecimal4secondnum.setText("");
                editTextNumberDecimal4secondnum.setHint("");
                textView5plusminus.setText("");
                textView6degree.setText("");
                editTextNumberDecimal1firstnum.setTextSize(TypedValue.COMPLEX_UNIT_SP, 72);
                editTextNumberDecimal2afteroperation.setTextSize(TypedValue.COMPLEX_UNIT_SP, 72);
                editTextNumberDecimal4secondnum.setTextSize(TypedValue.COMPLEX_UNIT_SP, 72);

                editTextNumberDecimal1firstnum.setFocusable(true);
                editTextNumberDecimal4secondnum.setFocusable(false);
            case R.id.button39clearsymbol:
                textView5plusminus.setText("");
                editTextNumberDecimal1firstnum.setHint("");
                editTextNumberDecimal4secondnum.setHint("");
                if (editTextNumberDecimal1firstnum.getText().toString().equals("Error"))
                {
                    editTextNumberDecimal1firstnum.setText("");
                    editTextNumberDecimal1firstnum.setHint(R.string.hint0);
                    editTextNumberDecimal4secondnum.setFocusable(false);
                }
                else if (editTextNumberDecimal1firstnum.getText().toString().equals("Infinity"))
                {
                    editTextNumberDecimal1firstnum.setText("");
                    editTextNumberDecimal1firstnum.setHint(R.string.hint0);
                    editTextNumberDecimal4secondnum.setFocusable(false);
                }
                else
                {
                    if (editTextNumberDecimal4secondnum.getText().toString().length() == 0)
                    {
                        editTextNumberDecimal2afteroperation.setFocusable(true);
                    }
                    if (editTextNumberDecimal2afteroperation.getText().toString().length() == 0)
                    {
                        editTextNumberDecimal1firstnum.setFocusable(true);
                    }
                    if (editTextNumberDecimal1firstnum.getText().toString().length() == 0)
                    {
                        editTextNumberDecimal3beforeoperation.setFocusable(true);

                        editTextNumberDecimal3beforeoperation.setText("");
                        textView6degree.setText("");
                        editTextNumberDecimal1firstnum.setTextSize(TypedValue.COMPLEX_UNIT_SP, 72);
                    }
                    if (editTextNumberDecimal1firstnum.hasFocusable())
                    {
                        editTextNumberDecimal2afteroperation.setFocusable(false);
                        editTextNumberDecimal3beforeoperation.setFocusable(false);
                        editTextNumberDecimal4secondnum.setFocusable(false);

                        int curs = editTextNumberDecimal1firstnum.getSelectionStart();
                        if (editTextNumberDecimal1firstnum.length() > 0 && curs > 0)
                        {
                            SpannableStringBuilder clsymb = (SpannableStringBuilder) editTextNumberDecimal1firstnum.getText();
                            clsymb.replace(curs - 1 , curs, "");
                        }
                        editTextNumberDecimal1firstnum.setHint(R.string.hint0);
                    }
                    if (editTextNumberDecimal2afteroperation.hasFocusable())
                    {
                        editTextNumberDecimal4secondnum.setFocusable(false);
                        editTextNumberDecimal2afteroperation.setText("");
                        if (editTextNumberDecimal2afteroperation.getText().toString().equals(""))
                        {
                            editTextNumberDecimal1firstnum.setFocusable(true);
                        }
                    }
                    if (editTextNumberDecimal3beforeoperation.hasFocusable())
                    {
                        editTextNumberDecimal1firstnum.setFocusable(false);
                        editTextNumberDecimal3beforeoperation.setText("");
                    }
                    if (editTextNumberDecimal4secondnum.hasFocusable())
                    {
                        editTextNumberDecimal1firstnum.setFocusable(false);
                        editTextNumberDecimal2afteroperation.setFocusable(false);
                        editTextNumberDecimal3beforeoperation.setFocusable(false);

                        int curs = editTextNumberDecimal4secondnum.getSelectionStart();
                        if (editTextNumberDecimal4secondnum.length() > 0 && curs > 0)
                        {
                            SpannableStringBuilder clsymb = (SpannableStringBuilder) editTextNumberDecimal4secondnum.getText();
                            clsymb.replace(curs - 1 , curs, "");
                        }
                    }
                }
        }
    }

    public  void  onStop()
    {
        super.onStop();

        savedresult = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor savedresulteditor = savedresult.edit();
        savedresulteditor.putString(RESULT, editTextNumberDecimal1firstnum.getText().toString());
        savedresulteditor.putString(MEMORY, textView2memory.getText().toString());
        savedresulteditor.apply();
    }
}