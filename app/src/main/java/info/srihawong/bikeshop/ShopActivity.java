package info.srihawong.bikeshop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import info.srihawong.bikeshop.R;

public class ShopActivity extends Activity {

    Intent reciveIntent;
    int id;
    TextView titleTextView,addressTextView,phoneTextView,emailTextView,websiteTextView,openTextView;
    ImageView mapImageView;
    Double lat,lng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        reciveIntent = getIntent();
        id = reciveIntent.getIntExtra("id", 0);
        AQuery aq = new AQuery(getApplicationContext());
        mapImageView = (ImageView)findViewById(R.id.mapImageView);
        titleTextView = (TextView)findViewById(R.id.titleTextView);
        addressTextView = (TextView)findViewById(R.id.addressTextView);
        phoneTextView = (TextView)findViewById(R.id.phoneTextView);
        emailTextView = (TextView)findViewById(R.id.emailTextView);
        websiteTextView = (TextView)findViewById(R.id.websiteTextView);
        openTextView = (TextView)findViewById(R.id.openTextView);

        mapImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapIntent = new Intent(getBaseContext(),MapsDirectionActivity.class);
                mapIntent.putExtra("lat",lat);
                mapIntent.putExtra("lng",lng);
                startActivity(mapIntent);
            }
        });
        aq.ajax(Config.apiUrl, JSONObject.class,Config.apiCacheTime,new AjaxCallback<JSONObject>(){
            @Override
            public void callback(String url, JSONObject object, AjaxStatus status) {
                if(object!=null){
                    try {
                        JSONArray shopArray = object.getJSONArray("shops");
                        for(int i=0,j=shopArray.length();i<j;i++){
                            JSONObject itemObj = shopArray.getJSONObject(i);
                            if(itemObj.getInt("id")==id){
                                titleTextView.setText(itemObj.getString("title"));
                                addressTextView.setText(itemObj.getString("address"));
                                phoneTextView.setText(itemObj.getString("phone"));
                                emailTextView.setText(itemObj.getString("email"));
                                websiteTextView.setText(itemObj.getString("website"));
                                openTextView.setText(itemObj.getString("open"));
                                lat = itemObj.getDouble("lat");
                                lng = itemObj.getDouble("lng");
                             break;
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                //super.callback(url, object, status);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.shop, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
