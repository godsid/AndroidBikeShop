package info.srihawong.bikeshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Banpot.S on 6/18/14 AD.
 */
public class NearByAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<Shop> shopArrayList;
    private LayoutInflater mInflater;

    public NearByAdapter(Context context, ArrayList<Shop> shopArrayList) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.shopArrayList = shopArrayList;
    }

    @Override
    public int getCount() {
        return shopArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return shopArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return shopArrayList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NearByItemView nearByItemView;
        Shop shop = shopArrayList.get(position);
        if(convertView==null){
            convertView = mInflater.inflate(R.layout.list_nearby,null);
            nearByItemView = new NearByItemView();
            nearByItemView.titleTextView =  (TextView) convertView.findViewById(R.id.titleTextView);
            nearByItemView.addressTextView = (TextView) convertView.findViewById(R.id.addressTextView);
            nearByItemView.distanceTextView = (TextView) convertView.findViewById(R.id.distanceTextView);
            convertView.setTag(nearByItemView);
        }else{
            nearByItemView = (NearByItemView) convertView.getTag();
        }

        nearByItemView.titleTextView.setText(shop.getTitle());
        nearByItemView.addressTextView.setText(shop.getCity());

        return convertView;
    }
}

class NearByItemView{
    TextView titleTextView,addressTextView,distanceTextView;
}
