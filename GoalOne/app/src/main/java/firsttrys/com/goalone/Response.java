package firsttrys.com.goalone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Response extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);

        //get the intent from the previous activity
        Intent gotIntent = getIntent();
        String importantMsg = gotIntent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //Set the text in the new view's text field to the important message
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(importantMsg);
    }
}
