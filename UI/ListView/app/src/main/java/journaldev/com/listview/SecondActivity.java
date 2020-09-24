package journaldev.com.listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by anupamchugh on 12/10/15.
 */
public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView txtProduct = (TextView) findViewById(R.id.team_label);

        Intent i = getIntent();
        // getting attached intent data
        String product = i.getStringExtra("team");
        // displaying selected product name
        txtProduct.setText(product);
    }
}
