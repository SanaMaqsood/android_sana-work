package com.pk.gov.pitb.email;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static com.pk.gov.pitb.email.R.id.email;

public class MainActivity extends AppCompatActivity {
Button btnEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEmail= (Button) findViewById(email);

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String c = "<i>sadkmasldkm</i>asdksmmsm<b>ssss</b>";
                Uri uri = Uri.parse("mailto:" + "sanamaq@gmail.com");

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("message/rfc822");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "salam");
                emailIntent.putExtra(Intent.EXTRA_TEXT, c);
                emailIntent.putExtra(Intent.EXTRA_HTML_TEXT, c); //If you are using HTML in your body text

                startActivity(Intent.createChooser(emailIntent, "Chooser Title"));

//                final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND_MULTIPLE);
//                emailIntent.setType("text/html");
//                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
//                        "sana");
//                emailIntent.putExtra(android.content.Intent.EXTRA_CC,
//                        "sana");
//                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
//                        Html.fromHtml("sana"));
//                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
//                        Html.fromHtml("<!DOCTYPE html>\n" +
//                                "<html> <body> <p><b>This text is bold</b></p> <p><i>This text is italic</i></p> <p>This is<sub> subscript</sub> and <sup>superscript</sup></p> </body> </html>"));
//
//                startActivity(Intent.createChooser(emailIntent, "email"));


//                Intent shareIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"));
//                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Sana");
//                shareIntent.putExtra(
//                        Intent.EXTRA_TEXT,
//                        Html.fromHtml(new StringBuilder()
//                                .append("<p><b>Hi this is test app</b></p>")
//                                .append("<small><p>Hi this is test app</small>")
//                                .toString()));
//
//                startActivity(Intent.createChooser(shareIntent, "Choice App t send email:"));

//                String c = "<i>sadkmasldkm</i>asdksmmsm<b>ssss</b>";

//                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
//                intent.setType("text/html");
//                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "my subject");
//                intent.putExtra(android.content.Intent.EXTRA_HTML_TEXT, Html.fromHtml(c));
//                startActivity(Intent.createChooser(intent,"Email"));

//                String body = "<b><i>sana</i></b>";
//                Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
//                String aEmailList[] = { "user@fakehost.com","user2@fakehost.com" };
//                String aEmailCCList[] = { "user3@fakehost.com","user4@fakehost.com"};
//                String aEmailBCCList[] = { "user5@fakehost.com" };
//                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);
//                emailIntent.putExtra(android.content.Intent.EXTRA_CC, aEmailCCList);
//                emailIntent.putExtra(android.content.Intent.EXTRA_BCC, aEmailBCCList);
//                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "My subject");
////               emailIntent.putExtra(Intent.EXTRA_HTML_TEXT, body);
//                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, fromHtml(body));
//                emailIntent.setType("text/html");
//                startActivity(Intent.createChooser(emailIntent, "Email:"));
            }
        });
    }
}
