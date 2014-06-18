package info.srihawong.bikeshop;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Banpot.S on 6/18/14 AD.
 */
public class Shop {
    int id;
    String title,website,city,address,open,phone,description;
    Double lat,lng;

    public Shop(JSONObject object) {
        try {
            this.id = object.getInt("id");
            this.title = object.getString("title");
            this.website = object.getString("website");
            this.city = object.getString("city");
            this.address = object.getString("address");
            this.open = object.getString("open");
            this.phone = object.getJSONArray("phone").getString(0);
            this.description = object.getString("description");
            this.lat = object.getDouble("lat");
            this.lng = object.getDouble("lng");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Shop(int id, String title, String website,String city, String address ,String open, String phone, String description, Double lat, Double lng) {
        this.id = id;
        this.title = title;
        this.website = website;
        this.city = city;
        this.address = address;
        this.open = open;
        this.phone = phone;
        this.description = description;
        this.lat = lat;
        this.lng = lng;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
