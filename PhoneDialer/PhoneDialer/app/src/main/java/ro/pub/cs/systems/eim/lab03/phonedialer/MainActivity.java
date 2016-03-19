package ro.pub.cs.systems.eim.lab03.phonedialer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    public void buttonClick (View v) {
//        Log.d("clupu","test");
//        switch (R.) {
//            case call:
//                Log.d("clupu","call");
//                break;
//            case backspace:
//                Log.d("clupu","backspace");
//                break;
//            case hangup:
//                Log.d("clupu","hangup");
//                break;
//            default:
//                break;
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        findViewById(R.id.call).setOnClickListener(new HandleClick());
        findViewById(R.id.hangup).setOnClickListener(new HandleClick());
        findViewById(R.id.backspace).setOnClickListener(new HandleClick());
        findViewById(R.id.zero).setOnClickListener(new HandleClick());
        findViewById(R.id.one).setOnClickListener(new HandleClick());
        findViewById(R.id.two).setOnClickListener(new HandleClick());
        findViewById(R.id.three).setOnClickListener(new HandleClick());
        findViewById(R.id.four).setOnClickListener(new HandleClick());
        findViewById(R.id.five).setOnClickListener(new HandleClick());
        findViewById(R.id.six).setOnClickListener(new HandleClick());
        findViewById(R.id.seven).setOnClickListener(new HandleClick());
        findViewById(R.id.eight).setOnClickListener(new HandleClick());
        findViewById(R.id.nine).setOnClickListener(new HandleClick());
        findViewById(R.id.star).setOnClickListener(new HandleClick());
        findViewById(R.id.sharp).setOnClickListener(new HandleClick());
        findViewById(R.id.fav).setOnClickListener(new HandleClick());



//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    private class HandleClick implements View.OnClickListener {
        public void onClick(View v) {
//            ImageButton btn = (ImageButton)arg0;	//cast view to a button
//            Log.d("clupu", "You pressed " + btn.get);
            EditText phoneNumber = (EditText) findViewById(R.id.phone_number);
            Intent intent = new Intent(Intent.ACTION_CALL);
            switch (v.getId()) {
                case R.id.call:
                    Log.d("clupu", "You pressed call");
                    intent.setData(Uri.parse("tel:" + phoneNumber.getText().toString()));
                    startActivity(intent);
                    break;
                case R.id.hangup:
                    Log.d("clupu", "You pressed hangup");
                    finish();
                    break;
                case R.id.backspace:
                    Log.d("clupu", "You pressed backspace");
                    if (phoneNumber.getText().toString().length() > 0)
                    phoneNumber.setText(phoneNumber.getText().toString().substring(0,phoneNumber.getText().toString().length()-1));
                    break;
                case R.id.fav:
                    Log.d("clupu", "You pressed backspace");
                    intent.setData(Uri.parse("tel:" + "0753174860"));
                    startActivity(intent);
                    break;
                default:
                    Log.d("clupu", "You pressed a key");
                    Button button = (Button) findViewById(v.getId());
                    phoneNumber.setText(phoneNumber.getText().toString() + button.getText().toString());
                    break;
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
