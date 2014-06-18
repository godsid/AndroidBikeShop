package info.srihawong.bikeshop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import info.srihawong.bikeshop.R;

public class SplashScreenActivity extends Activity {
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        TextView version = (TextView) findViewById(R.id.splash_version);
        version.setText("Version: "+Util.getAppVersionName(getApplicationContext()));

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                Intent intentMain = new Intent(SplashScreenActivity.this, MainActivity.class);
                //Check open from Notification
                /************* Open with Share url*******/
                /*Intent intent = getIntent();
                if(Intent.ACTION_VIEW.equals(intent.getAction())){
                    Log.d("tui", "ACTION_VIEW:" + intent.getDataString());
                    intentMain.putExtra("url",intent.getDataString());
                    //if(intent.getData().getPath().contains("/todayzodiac")){

                    //}
                }*/
                /****************************************/

                startActivity(intentMain);
                finish();
            }
        };
    }
    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable, 3000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(runnable);
    }

    @Override
    public void onBackPressed() {
    }

}
