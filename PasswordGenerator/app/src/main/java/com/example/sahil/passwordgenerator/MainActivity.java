package com.example.sahil.passwordgenerator;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    EditText sizeOfPassword;
    Button generate;
    TextView outputText;
    CheckBox smallLetters;
    CheckBox capitalLetters;
    CheckBox numbers;
    CheckBox specialCharacters;
    CheckBox recommended;
    Button copyToClipboard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generate = (Button) findViewById(R.id.generate);

        outputText = (TextView) findViewById(R.id.output_text);

        sizeOfPassword = (EditText) findViewById(R.id.sizeOfPassword);

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (sizeOfPassword.getText().toString().trim().length() == 0) {

                    Toast.makeText(getApplicationContext(), "Please Enter the size", Toast.LENGTH_LONG).show();

                } else {

                    if (Integer.parseInt(sizeOfPassword.getText().toString()) > 500 || Integer.parseInt(sizeOfPassword.getText().toString()) < 5) {

                        Toast.makeText(getApplicationContext(), "Size of password must be between 5 and 500", Toast.LENGTH_LONG).show();

                    } else {

                        int numOfCharactersInPassword = Integer.parseInt(sizeOfPassword.getText().toString());

                        smallLetters = (CheckBox) findViewById(R.id.smallLetters);

                        capitalLetters = (CheckBox) findViewById(R.id.capitalLetters);

                        numbers = (CheckBox) findViewById(R.id.numbers);

                        specialCharacters = (CheckBox) findViewById(R.id.specialCharacters);

                        recommended = (CheckBox) findViewById(R.id.recommended);

                        boolean small = smallLetters.isChecked();

                        boolean capital = capitalLetters.isChecked();

                        boolean num = numbers.isChecked();

                        boolean special = specialCharacters.isChecked();

                        boolean all = recommended.isChecked();

                        if (!small && !capital && !num && !special && !all) {

                            Toast.makeText(getApplicationContext(), "Please select atleast one checkbox", Toast.LENGTH_LONG).show();

                        } else {

                            Character output[] = new Character[numOfCharactersInPassword];

                            double r;

                            if (all) {

                                small = false;

                                capital = false;

                                num = false;

                                special = false;

                            } else if (small && num && special && capital && !all) {

                                small = false;

                                capital = false;

                                num = false;

                                special = false;

                                all = true;

                            }

                            if (small && !num && !special && !capital && !all) {

                                for (int i = 0; i < numOfCharactersInPassword; i++) {

                                    double value = Math.floor((Math.random() * (122 - 97))) + 97;

                                    output[i] = (char) value;

                                }

                                String val = Arrays.toString(output).replaceAll(", ", "").replace("[", "").replace("]", "");

                                outputText.setText(val);

                            } else if (!small && num && !special && !capital && !all) {

                                for (int i = 0; i < numOfCharactersInPassword; i++) {

                                    double value = Math.floor((Math.random() * (57 - 48))) + 48;

                                    output[i] = (char) value;

                                }

                                String val = Arrays.toString(output).replaceAll(", ", "").replace("[", "").replace("]", "");

                                outputText.setText(val);

                            } else if (!small && !num && special && !capital && !all) {

                                for (int i = 0; i < numOfCharactersInPassword; i++) {

                                    while (true) {

                                        r = Math.floor((Math.random() * (127)));

                                        if ((r >= 32 && r <= 47) || (r >= 58 && r <= 64) || (r >= 91 && r <= 96) || (r >= 123 && r <= 126)) {

                                            output[i] = (char) r;

                                            break;

                                        }

                                    }

                                }

                                String val = Arrays.toString(output).replaceAll(", ", "").replace("[", "").replace("]", "");

                                outputText.setText(val);

                            } else if (!small && !num && !special && !capital && all) {

                                for (int i = 0; i < numOfCharactersInPassword; i++) {

                                    while (true) {

                                        r = Math.floor((Math.random() * (127)));

                                        if ((r >= 32 && r <= 47) || (r >= 58 && r <= 64) || (r >= 91 && r <= 96) || (r >= 123 && r <= 126) || (r >= 48 && r <= 57) || (r >= 65 && r >= 90) || (r >= 97 && r <= 122)) {

                                            output[i] = (char) r;

                                            break;

                                        }

                                    }

                                }

                                String val = Arrays.toString(output).replaceAll(", ", "").replace("[", "").replace("]", "");

                                outputText.setText(val);

                            } else if (!small && !num && !special && capital && !all) {

                                for (int i = 0; i < numOfCharactersInPassword; i++) {

                                    double value = Math.floor((Math.random() * (90 - 65))) + 65;

                                    output[i] = (char) value;

                                }

                                String val = Arrays.toString(output).replaceAll(", ", "").replace("[", "").replace("]", "");

                                outputText.setText(val);

                            } else if (small && num && !special && !capital && !all) {

                                for (int i = 0; i < numOfCharactersInPassword; i++) {

                                    while (true) {

                                        r = Math.floor((Math.random() * (127)));

                                        if ((r >= 97 && r <= 122) || (r >= 48 && r <= 57)) {

                                            output[i] = (char) r;

                                            break;

                                        }

                                    }

                                }

                                String val = Arrays.toString(output).replaceAll(", ", "").replace("[", "").replace("]", "");

                                outputText.setText(val);

                            } else if (small && !num && special && !capital && !all) {

                                for (int i = 0; i < numOfCharactersInPassword; i++) {

                                    while (true) {

                                        r = Math.floor((Math.random() * (127)));

                                        if ((r >= 97 && r <= 122) || (r >= 32 && r <= 47) || (r >= 58 && r <= 64) || (r >= 91 && r <= 96) || (r >= 123 && r <= 126)) {

                                            output[i] = (char) r;

                                            break;

                                        }

                                    }

                                }

                                String val = Arrays.toString(output).replaceAll(", ", "").replace("[", "").replace("]", "");

                                outputText.setText(val);

                            } else if (small && !num && !special && capital && !all) {

                                for (int i = 0; i < numOfCharactersInPassword; i++) {

                                    while (true) {

                                        r = Math.floor((Math.random() * (127)));

                                        if ((r >= 97 && r <= 122) || (r >= 65 && r <= 90)) {

                                            output[i] = (char) r;

                                            break;

                                        }

                                    }

                                }

                                String val = Arrays.toString(output).replaceAll(", ", "").replace("[", "").replace("]", "");

                                outputText.setText(val);

                            } else if (!small && num && special && !capital && !all) {

                                for (int i = 0; i < numOfCharactersInPassword; i++) {

                                    while (true) {

                                        r = Math.floor((Math.random() * (127)));

                                        if ((r >= 32 && r <= 47) || (r >= 58 && r <= 64) || (r >= 91 && r <= 96) || (r >= 123 && r <= 126) || (r >= 48 && r <= 57)) {

                                            output[i] = (char) r;

                                            break;

                                        }

                                    }

                                }

                                String val = Arrays.toString(output).replaceAll(", ", "").replace("[", "").replace("]", "");

                                outputText.setText(val);

                            } else if (!small && num && !special && capital && !all) {

                                for (int i = 0; i < numOfCharactersInPassword; i++) {

                                    while (true) {

                                        r = Math.floor((Math.random() * (127)));

                                        if ((r >= 65 && r <= 90) || (r >= 48 && r <= 57)) {

                                            output[i] = (char) r;

                                            break;

                                        }

                                    }

                                }

                                String val = Arrays.toString(output).replaceAll(", ", "").replace("[", "").replace("]", "");

                                outputText.setText(val);

                            } else if (!small && !num && special && capital && !all) {

                                for (int i = 0; i < numOfCharactersInPassword; i++) {

                                    while (true) {

                                        r = Math.floor((Math.random() * (127)));

                                        if ((r >= 65 && r <= 90) || (r >= 32 && r <= 47) || (r >= 58 && r <= 64) || (r >= 91 && r <= 96) || (r >= 123 && r <= 126)) {

                                            output[i] = (char) r;

                                            break;

                                        }

                                    }

                                }

                                String val = Arrays.toString(output).replaceAll(", ", "").replace("[", "").replace("]", "");

                                outputText.setText(val);

                            } else if (small && num && special && !capital && !all) {

                                for (int i = 0; i < numOfCharactersInPassword; i++) {

                                    while (true) {

                                        r = Math.floor((Math.random() * (127)));

                                        if ((r >= 48 && r <= 57) || (r >= 97 && r <= 122) || (r >= 32 && r <= 47) || (r >= 58 && r <= 64) || (r >= 91 && r <= 96) || (r >= 123 && r <= 126)) {

                                            output[i] = (char) r;

                                            break;

                                        }

                                    }

                                }

                                String val = Arrays.toString(output).replaceAll(", ", "").replace("[", "").replace("]", "");

                                outputText.setText(val);

                            } else if (small && !num && special && capital && !all) {

                                for (int i = 0; i < numOfCharactersInPassword; i++) {

                                    while (true) {

                                        r = Math.floor((Math.random() * (127)));

                                        if ((r >= 65 && r <= 90) || (r >= 97 && r <= 122) || (r >= 32 && r <= 47) || (r >= 58 && r <= 64) || (r >= 91 && r <= 96) || (r >= 123 && r <= 126)) {

                                            output[i] = (char) r;

                                            break;

                                        }

                                    }

                                }

                                String val = Arrays.toString(output).replaceAll(", ", "").replace("[", "").replace("]", "");

                                outputText.setText(val);

                            } else if (!small && num && special && capital && !all) {

                                for (int i = 0; i < numOfCharactersInPassword; i++) {

                                    while (true) {

                                        r = Math.floor((Math.random() * (127)));

                                        if ((r >= 65 && r <= 90) || (r >= 48 && r <= 57) || (r >= 32 && r <= 47) || (r >= 58 && r <= 64) || (r >= 91 && r <= 96) || (r >= 123 && r <= 126)) {

                                            output[i] = (char) r;

                                            break;

                                        }

                                    }

                                }

                                String val = Arrays.toString(output).replaceAll(", ", "").replace("[", "").replace("]", "");

                                outputText.setText(val);

                            } else if (small && num && !special && capital && !all) {

                                for (int i = 0; i < numOfCharactersInPassword; i++) {

                                    while (true) {

                                        r = Math.floor((Math.random() * (127)));

                                        if ((r >= 65 && r <= 90) || (r >= 48 && r <= 57) || (r >= 97 && r <= 122)) {

                                            output[i] = (char) r;

                                            break;

                                        }

                                    }

                                }

                                String val = Arrays.toString(output).replaceAll(", ", "").replace("[", "").replace("]", "");

                                outputText.setText(val);

                            } else if (!small && !num && !special && !capital && !all) {

                                Toast.makeText(getApplicationContext(), "Please select any check box", Toast.LENGTH_LONG).show();

                            } else {

                                Toast.makeText(getApplicationContext(), "An error occured, please try again", Toast.LENGTH_LONG).show();

                            }

                            if (output.length > 0) {

                                copyToClipboard.setVisibility(View.VISIBLE);

                            }

                        }
                    }

                }
            }
        });

        copyToClipboard = (Button) findViewById(R.id.copy);

        copyToClipboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (sizeOfPassword.getText().toString().trim().length() != 0) {

                    ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clip = ClipData.newPlainText("Password is copied to your clipboard", outputText.getText().toString());
                    clipboard.setPrimaryClip(clip);

                    Toast.makeText(getApplicationContext(), "Your password has been copied to your clipboard", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(getApplicationContext(), "First of all, generate the password of your need and then click on 'copy in the clip board'", Toast.LENGTH_LONG).show();

                }

            }
        });

    }
}
