package com.geeks.aizhan_kanybekova_hw_32;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class EmailFragment extends Fragment {

    EditText addressEdT, themeEdT, textEdT;
    Button sendBtn;

    public EmailFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_email, container, false);

        addressEdT = view.findViewById(R.id.addressEdT);
        themeEdT = view.findViewById(R.id.themeEdT);
        textEdT = view.findViewById(R.id.textEdT);
        sendBtn = view.findViewById(R.id.sendBtn);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });

        return view;
    }

    private void sendEmail() {
        String recipient = addressEdT.getText().toString().trim();
        String subject = themeEdT.getText().toString().trim();
        String message = textEdT.getText().toString().trim();

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + recipient));
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);


        Intent chooser = Intent.createChooser(intent, "Choose an email client");
        startActivity(chooser);


    }
}