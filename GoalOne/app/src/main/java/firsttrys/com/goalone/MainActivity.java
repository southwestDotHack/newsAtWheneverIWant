package firsttrys.com.goalone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "firsttrys.com.goalone.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** method called to respond to the user hitting the submit button */
    public void displayResponse(View view) {
        Intent newIntent = new Intent(this, Response.class);
        newIntent.putExtra(EXTRA_MESSAGE, "Ryan is a B word");
        startActivity(newIntent);
    }
}
