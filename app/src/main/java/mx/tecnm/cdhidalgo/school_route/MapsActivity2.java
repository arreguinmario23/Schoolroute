package mx.tecnm.cdhidalgo.school_route;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import mx.tecnm.cdhidalgo.school_route.databinding.ActivityMaps2Binding;
import mx.tecnm.cdhidalgo.school_route.databinding.ActivityMapsBinding;

public class MapsActivity2 extends FragmentActivity implements
        GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener, OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMaps2Binding binding;
    private Button Actualizar;
    private Button Salir;
    private FusedLocationProviderClient fusedLocationClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMaps2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        Salir = findViewById(R.id.btn_continuar);
        Salir.setOnClickListener(view -> {
            Toast.makeText(this, "Hasta pronto", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, MainActivity2.class);
            startActivity(i);
        });
        Actualizar = findViewById(R.id.btn_solicitar);
        Actualizar.setOnClickListener(view -> {
            Toast.makeText(this, "Ubicaciones Actualizadas", Toast.LENGTH_SHORT).show();
        });
        mapFragment.getMapAsync(this);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng alumno1 = new LatLng(19.708189, -100.517606);
        mMap.addMarker(new MarkerOptions().position(alumno1).title("Alumno").icon(BitmapDescriptorFactory.fromResource(R.mipmap.alumno)));
        LatLng alumno2 = new LatLng(19.685262, -100.599361);
        mMap.addMarker(new MarkerOptions().position(alumno2).title("Alumno").icon(BitmapDescriptorFactory.fromResource(R.mipmap.alumno)));
        LatLng alumno3 = new LatLng(19.675224, -100.522459);
        mMap.addMarker(new MarkerOptions().position(alumno3).title("Alumno").icon(BitmapDescriptorFactory.fromResource(R.mipmap.alumno)));
        LatLng alumno4 = new LatLng(19.684325, -100.548229);
        mMap.addMarker(new MarkerOptions().position(alumno4).title("Alumno").icon(BitmapDescriptorFactory.fromResource(R.mipmap.alumno)));
        LatLng alumno5 = new LatLng(19.686476, -100.552423);
        mMap.addMarker(new MarkerOptions().position(alumno5).title("Alumno").icon(BitmapDescriptorFactory.fromResource(R.mipmap.alumno)));
        LatLng alumno6 = new LatLng(19.688186, -100.552347);
        mMap.addMarker(new MarkerOptions().position(alumno6).title("Alumno").icon(BitmapDescriptorFactory.fromResource(R.mipmap.alumno)));
        LatLng alumno7 = new LatLng(19.693385, -100.555637);
        mMap.addMarker(new MarkerOptions().position(alumno7).title("Alumno").icon(BitmapDescriptorFactory.fromResource(R.mipmap.alumno)));
        LatLng alumno8 = new LatLng(19.684260, -100.520073);
        mMap.addMarker(new MarkerOptions().position(alumno8).title("Alumno").icon(BitmapDescriptorFactory.fromResource(R.mipmap.alumno)));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            LatLng sydney = new LatLng(location.getLatitude(),location.getLongitude());
                            //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,15));
                        }
                    }
                });

        // Add a marker in Sydney and move the camera


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);
    }

    @Override
    public boolean onMyLocationButtonClick() {
        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {

    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
