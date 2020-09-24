package journaldev.com.listview;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // storing string resources into Array
        String[] teams = getResources().getStringArray(R.array.teams);
//        List<String> categories = new ArrayList<String>();
//        categories.add("Item 1");
//        categories.add("Item 2");
//        categories.add("Item 3");
//        categories.add("Item 4");
//        categories.add("Item 5");
//        categories.add("Item 6");
        // Binding resources Array to ListAdapter
        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.textview, teams));

        ListView lv = getListView();

        // listening to single list item on click
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // selected item
                String team = ((TextView) view).getText().toString();

                // Launching new Activity on selecting single List Item
                Intent i = new Intent(getApplicationContext(), SecondActivity.class);
                // sending data to new activity
                i.putExtra("team", team);
                startActivity(i);

            }
        });
    }
}


