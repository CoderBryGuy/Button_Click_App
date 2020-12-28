package com.example.button_click_app;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    EditText userInput;
    private static final String TAG = "MainActivity";
    private final String TEXT_CONTENTS = "TextContents";


//    private int numTimesClicked = 0;

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: in");
        super.onStart();
        Log.d(TAG, "onStart: out");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState: in");
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: out");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: in");
        super.onResume();
        Log.d(TAG, "onResume: out");
    }

    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        Log.d(TAG, "onRestoreInstanceState: in");
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        String savedString = savedInstanceState.getString(TEXT_CONTENTS,"onRestoreInstanceState() failed");
        textView.setText(savedString);
        Log.d(TAG, "onRestoreInstanceState: out");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG , "onCreate: in here");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        userInput = findViewById(R.id.editTextTextPersonName2);
        textView = findViewById(R.id.textView);
        textView.setText("");
        userInput.setText("");
        textView.setMovementMethod(new ScrollingMovementMethod());

        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            String result;

            @Override
            public void onClick(View view) {
//                numTimesClicked = numTimesClicked + 1;
//                result = "The button got tapped " + numTimesClicked + " time" + (numTimesClicked > 1 ? "s" : "") +"\n";
//                textView.append(result);

                result = userInput.getText().toString();
                result += "\n";
                textView.append(result);
                userInput.setText("");
            }
        };
        button.setOnClickListener(ourOnClickListener);
        Log.d(TAG, "onCreate: out");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        Log.d(TAG, "onSaveInstanceState: in");
        outState.putString(TEXT_CONTENTS, textView.getText().toString());
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d(TAG, "onSaveInstanceState: out");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: in");
        super.onPause();
        Log.d(TAG, "onPause: out");
    }


    @Override
    protected void onPostResume() {
        Log.d(TAG, "onPostResume: in");
        super.onPostResume();
        Log.d(TAG, "onPostResume: out");
    }



    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: in");
        super.onStop();
        Log.d(TAG, "onStop: out");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: in");
        super.onDestroy();
        Log.d(TAG, " onDestroy: out");
    }
}