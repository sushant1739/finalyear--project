package com.bluetooth.bluetooth;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.view.View;
import android.widget.ArrayAdapter;

import android.util.Log;
import android.widget.Toast;

import com.bluetooth.bluetooth.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;


public class MainActivity extends Activity implements LocationListener{
    protected LocationManager locationManager;
    protected LocationListener locationListener;
    protected Context context;
    public static Client wifi_client = null;
    Button btn_click;
    TextView txtLat;
    ListView listView;
    public static String lat;
    public static String lng;
    String provider;
    protected String latitude,longitude;
    protected boolean gps_enabled,network_enabled;
    public static ArrayAdapter<String> adapter;
    public static ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView) findViewById(R.id.listView);
       // btn_click=(Button)findViewById(R.id.btn_click);
        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 5, this);
        /*btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // onLocationChanged(Location location) //method to turn on
            }
        });*/
    }
   

    