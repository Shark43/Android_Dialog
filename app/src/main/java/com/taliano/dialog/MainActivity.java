package com.taliano.dialog;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        final TextView textView = findViewById(R.id.textView);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle(R.string.alert_dialog_title_1);
                builder.setMessage(R.string.alert_dialog_message_1);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setCancelable(false);

                builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textView.setText(getString(R.string.press_yes));
                    }
                });

                builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textView.setText(getString(R.string.press_no));
                    }
                });

                builder.setNeutralButton(R.string.press_cancel, null);

                final AlertDialog alertDialog = builder.create();

                alertDialog.setOnShowListener( new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface arg0) {
                        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.RED);
                        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.GREEN);
                        alertDialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(Color.BLUE);
                    }
                });
                alertDialog.show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle(R.string.alert_dialog_title_2);
                builder.setMessage(R.string.alert_dialog_message_2);
                builder.setIcon(R.mipmap.ic_launcher);

                final EditText editText = new EditText(v.getContext());
                editText.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(editText);

                builder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textView.setText(editText.getText());
                    }
                });

                builder.setNeutralButton(R.string.press_cancel, null);

                final AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
}
