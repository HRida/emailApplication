package com.example.lab605b.emailapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText To,Subject,Message,CC,BCC;
    Button Send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        To = findViewById(R.id.etTo);
        Subject = findViewById(R.id.etSubject);
        Message = findViewById(R.id.etMsg);
        CC = findViewById(R.id.ccTo);
        BCC = findViewById(R.id.bccTo);
        Send = findViewById(R.id.btnSend);

        Send.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to = To.getText().toString();
                String subject = Subject.getText().toString();
                String message = Message.getText().toString();
                String cc = CC.getText().toString();
                String bcc = BCC.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);

                email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.putExtra(Intent.EXTRA_CC, new String[]{cc});
                email.putExtra(Intent.EXTRA_BCC, new String[]{bcc});

                email.setType("message/rfc822");
                    startActivity(
                            getIntent().createChooser(
                                    email,"Select Email Client"
                            )
                    );
            }
        });
    }
}
