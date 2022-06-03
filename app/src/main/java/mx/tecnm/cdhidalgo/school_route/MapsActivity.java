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
import android.view.View;
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

import mx.tecnm.cdhidalgo.school_route.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements
        GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener, OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private Button Soli;
    private Button Salir;

    private FusedLocationProviderClient fusedLocationClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        Salir = findViewById(R.id.btn_continuar);
        Salir.setOnClickListener(view -> {
            Toast.makeText(this, "Adios Jaguar", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, MainActivity2.class);
            startActivity(i);
        });
        Soli = findViewById(R.id.btn_solicitar);
        Soli.setOnClickListener(view -> {
            Toast.makeText(this, "Mensaje Enviado", Toast.LENGTH_SHORT).show();
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
        LatLng combi1 = new LatLng(19.708189, -100.517606);
        mMap.addMarker(new MarkerOptions().position(combi1).title("Combi").icon(BitmapDescriptorFactory.fromResource(R.mipmap.combi2)));
        LatLng combi2 = new LatLng(19.685262, -100.599361);
        mMap.addMarker(new MarkerOptions().position(combi2).title("Combi").icon(BitmapDescriptorFactory.fromResource(R.mipmap.combi1)));
        LatLng combi3 = new LatLng(19.684597, -100.548199);
        mMap.addMarker(new MarkerOptions().position(combi3).title("Combi").icon(BitmapDescriptorFactory.fromResource(R.mipmap.combi2)));
        LatLng combi4 = new LatLng(19.679546, -100.535240);
        mMap.addMarker(new MarkerOptions().position(combi4).title("Combi").icon(BitmapDescriptorFactory.fromResource(R.mipmap.combi1)));
        LatLng combi5 = new LatLng(19.675288, -100.522446);
        mMap.addMarker(new MarkerOptions().position(combi5).title("Combi").icon(BitmapDescriptorFactory.fromResource(R.mipmap.combi2)));
        LatLng combi6 = new LatLng(19.688274, -100.553440);
        mMap.addMarker(new MarkerOptions().position(combi6).title("Combi").icon(BitmapDescriptorFactory.fromResource(R.mipmap.combi1)));
        LatLng combi7 = new LatLng(19.691082, -100.556398);
        mMap.addMarker(new MarkerOptions().position(combi7).title("Combi").icon(BitmapDescriptorFactory.fromResource(R.mipmap.combi2)));
        LatLng combi8 = new LatLng(19.694478, -100.563079);
        mMap.addMarker(new MarkerOptions().position(combi8).title("Combi").icon(BitmapDescriptorFactory.fromResource(R.mipmap.combi1)));
        LatLng combi9 = new LatLng(19.703582, -100.571620);
        mMap.addMarker(new MarkerOptions().position(combi9).title("Combi").icon(BitmapDescriptorFactory.fromResource(R.mipmap.combi2)));
        //Combias ruta B
        LatLng combi10 = new LatLng(19.681364, -100.553156);
        mMap.addMarker(new MarkerOptions().position(combi10).title("Combi").icon(BitmapDescriptorFactory.fromResource(R.mipmap.combi1)));
        LatLng combi11 = new LatLng(19.685489, -100.568635);
        mMap.addMarker(new MarkerOptions().position(combi11).title("Combi").icon(BitmapDescriptorFactory.fromResource(R.mipmap.combi2)));
        LatLng combi12 = new LatLng(19.698316, -100.588202);
        mMap.addMarker(new MarkerOptions().position(combi12).title("Combi").icon(BitmapDescriptorFactory.fromResource(R.mipmap.combi1)));
        //Combis ruta C
        PolylineOptions polylineOptions = new PolylineOptions()
                .add(new LatLng(19.708189, -100.517606))
                .add(new LatLng(19.708161, -100.517636))
                .add(new LatLng(19.708058, -100.517734))
                .add(new LatLng(19.707870, -100.517895))
                .add(new LatLng(19.707784, -100.517956))
                .add(new LatLng(19.707612, -100.518026))
                .add(new LatLng(19.707463, -100.518053))
                .add(new LatLng(19.707317, -100.518056))
                .add(new LatLng(19.707133, -100.518026))
                .add(new LatLng(19.706944, -100.517958))
                .add(new LatLng(19.706674, -100.517781))
                .add(new LatLng(19.706626, -100.517808))
                .add(new LatLng(19.706535, -100.518074))
                .add(new LatLng(19.706373, -100.518509))
                .add(new LatLng(19.706133, -100.519053))
                .add(new LatLng(19.705903, -100.519479))
                .add(new LatLng(19.705698, -100.519812))
                .add(new LatLng(19.705511, -100.520045))
                .add(new LatLng(19.705349, -100.520171))
                .add(new LatLng(19.705185, -100.520241))
                .add(new LatLng(19.704955, -100.520246))
                .add(new LatLng(19.704644, -100.520281))
                .add(new LatLng(19.704419, -100.520337))
                .add(new LatLng(19.704202, -100.520431))
                .add(new LatLng(19.703747, -100.520731))
                .add(new LatLng(19.703548, -100.520938))
                .add(new LatLng(19.703346, -100.521308))
                .add(new LatLng(19.703136, -100.521595))
                .add(new LatLng(19.703040, -100.521702))
                .add(new LatLng(19.702911, -100.521788))
                .add(new LatLng(19.702757, -100.521836))
                .add(new LatLng(19.702229, -100.521967))
                .add(new LatLng(19.701287, -100.522184))
                .add(new LatLng(19.700423, -100.522340))
                .add(new LatLng(19.699491, -100.522402))
                .add(new LatLng(19.699115, -100.522461))
                .add(new LatLng(19.699115, -100.522461))
                .add(new LatLng(19.698038, -100.522648))
                .add(new LatLng(19.697359, -100.522809))
                .add(new LatLng(19.696692, -100.523016))
                .add(new LatLng(19.695927, -100.523260))
                .add(new LatLng(19.695604, -100.523373))
                .add(new LatLng(19.695430, -100.523470))
                .add(new LatLng(19.695099, -100.523776))
                .add(new LatLng(19.694617, -100.524315))
                .add(new LatLng(19.694165, -100.524835))
                .add(new LatLng(19.693988, -100.525020))
                .add(new LatLng(19.693950, -100.525055))
                .add(new LatLng(19.693114, -100.525256))
                .add(new LatLng(19.691594, -100.525562))
                .add(new LatLng(19.690579, -100.525718))
                .add(new LatLng(19.690220, -100.525745))
                .add(new LatLng(19.689998, -100.525734))
                .add(new LatLng(19.689526, -100.525624))
                .add(new LatLng(19.688970, -100.525364))
                .add(new LatLng(19.688422, -100.524919))
                .add(new LatLng(19.687922, -100.524385))
                .add(new LatLng(19.687361, -100.523800))
                .add(new LatLng(19.686803, -100.523250))
                .add(new LatLng(19.686192, -100.522579))
                .add(new LatLng(19.685498, -100.521863))
                .add(new LatLng(19.684859, -100.521181))
                .add(new LatLng(19.684445, -100.520752))
                .add(new LatLng(19.684074, -100.520393))
                .add(new LatLng(19.683827, -100.520197))
                .add(new LatLng(19.683537, -100.520028))
                .add(new LatLng(19.683320, -100.519953))
                .add(new LatLng(19.682966, -100.519913))
                .add(new LatLng(19.682645, -100.519929))
                .add(new LatLng(19.682221, -100.520090))
                .add(new LatLng(19.681514, -100.520347))
                .add(new LatLng(19.680822, -100.520580))
                .add(new LatLng(19.680203, -100.520792))
                .add(new LatLng(19.680077, -100.520813))
                .add(new LatLng(19.679625, -100.520969))
                .add(new LatLng(19.679087, -100.521149))
                .add(new LatLng(19.678703, -100.521270))
                .add(new LatLng(19.678087, -100.521509))
                .add(new LatLng(19.677646, -100.521675))
                .add(new LatLng(19.677376, -100.521764))
                .add(new LatLng(19.676909, -100.521938))
                .add(new LatLng(19.676631, -100.522032))
                .add(new LatLng(19.676313, -100.522104))
                .add(new LatLng(19.675891, -100.522131))
                .add(new LatLng(19.675709, -100.522120))
                .add(new LatLng(19.675631, -100.522136))
                .add(new LatLng(19.675487, -100.522208))
                .add(new LatLng(19.675343, -100.522337))
                .add(new LatLng(19.675224, -100.522648))
                .add(new LatLng(19.675176, -100.522857))
                .add(new LatLng(19.675176, -100.523055))
                .add(new LatLng(19.675176, -100.523167))
                .add(new LatLng(19.675320, -100.523585))
                .add(new LatLng(19.675557, -100.524269))
                .add(new LatLng(19.675827, -100.525052))
                .add(new LatLng(19.675917, -100.525300))
                .add(new LatLng(19.676218, -100.526142))
                .add(new LatLng(19.676539, -100.527019))
                .add(new LatLng(19.676850, -100.527867))
                .add(new LatLng(19.677148, -100.528707))
                .add(new LatLng(19.677431, -100.529469))
                .add(new LatLng(19.677744, -100.530322))
                .add(new LatLng(19.678012, -100.531033))
                .add(new LatLng(19.678267, -100.531784))
                .add(new LatLng(19.678530, -100.532476))
                .add(new LatLng(19.678752, -100.533093))
                .add(new LatLng(19.678946, -100.533654))
                .add(new LatLng(19.679194, -100.534335))
                .add(new LatLng(19.679484, -100.535097))
                .add(new LatLng(19.679749, -100.535832))
                .add(new LatLng(19.680004, -100.536575))
                .add(new LatLng(19.680186, -100.537060))
                .add(new LatLng(19.680426, -100.537757))
                .add(new LatLng(19.680658, -100.538355))
                .add(new LatLng(19.680835, -100.538760))
                .add(new LatLng(19.680954, -100.539007))
                .add(new LatLng(19.681191, -100.539519))
                .add(new LatLng(19.681492, -100.540093))
                .add(new LatLng(19.681833, -100.540723))
                .add(new LatLng(19.682141, -100.541289))
                .add(new LatLng(19.682459, -100.541868))
                .add(new LatLng(19.682795, -100.542471))
                .add(new LatLng(19.683111, -100.543029))
                .add(new LatLng(19.683470, -100.543705))
                .add(new LatLng(19.683821, -100.544325))
                .add(new LatLng(19.684099, -100.544835))
                .add(new LatLng(19.684432, -100.545420))
                .add(new LatLng(19.684763, -100.546002))
                .add(new LatLng(19.685079, -100.546592))
                .add(new LatLng(19.685344, -100.547096))
                .add(new LatLng(19.685554, -100.547474))
                .add(new LatLng(19.685551, -100.547528))
                .add(new LatLng(19.685412, -100.547638))
                .add(new LatLng(19.684985, -100.547936))
                .add(new LatLng(19.684455, -100.548290))
                .add(new LatLng(19.683993, -100.548612))
                .add(new LatLng(19.683677, -100.548813))
                .add(new LatLng(19.683659, -100.548853))
                .add(new LatLng(19.683699, -100.549245))
                .add(new LatLng(19.683744, -100.549674))
                .add(new LatLng(19.683635, -100.549687))
                .add(new LatLng(19.683721, -100.550489))
                .add(new LatLng(19.683772, -100.550999))
                .add(new LatLng(19.683850, -100.551852))
                .add(new LatLng(19.683901, -100.552521))
                .add(new LatLng(19.684323, -100.552500))
                .add(new LatLng(19.684896, -100.552476))
                .add(new LatLng(19.685325, -100.552468))
                .add(new LatLng(19.685833, -100.552449))
                .add(new LatLng(19.686346, -100.552417))
                .add(new LatLng(19.686722, -100.552404))
                .add(new LatLng(19.686846, -100.552409))
                .add(new LatLng(19.686874, -100.552758))
                .add(new LatLng(19.686912, -100.553131))
                .add(new LatLng(19.686920, -100.553238))
                .add(new LatLng(19.687208, -100.553241))
                .add(new LatLng(19.687637, -100.553241))
                .add(new LatLng(19.688044, -100.553236))
                .add(new LatLng(19.688238, -100.553233))
                .add(new LatLng(19.688271, -100.553587))
                .add(new LatLng(19.688344, -100.554121))
                .add(new LatLng(19.688397, -100.554617))
                .add(new LatLng(19.688470, -100.555094))
                .add(new LatLng(19.688522, -100.555606))
                .add(new LatLng(19.688562, -100.555947))
                .add(new LatLng(19.688632, -100.556559))
                .add(new LatLng(19.688638, -100.556609))
                .add(new LatLng(19.689596, -100.556467))
                .add(new LatLng(19.689805, -100.556447))
                .add(new LatLng(19.690003, -100.556430))
                .add(new LatLng(19.690199, -100.556419))
                .add(new LatLng(19.690351, -100.556414))
                .add(new LatLng(19.690825, -100.556401))
                .add(new LatLng(19.691018, -100.556403))
                .add(new LatLng(19.691075, -100.556403))
                .add(new LatLng(19.690981, -100.555755))
                .add(new LatLng(19.690915, -100.554975))
                .add(new LatLng(19.690901, -100.554944))
                .add(new LatLng(19.691239, -100.554912))
                .add(new LatLng(19.691710, -100.554818))
                .add(new LatLng(19.692387, -100.554760))
                .add(new LatLng(19.693065, -100.554665))
                .add(new LatLng(19.693284246692492, -100.55463369009304))
                .add(new LatLng(19.693370, -100.554969))
                .add(new LatLng(19.693541, -100.555601))
                .add(new LatLng(19.693673, -100.556054))
                .add(new LatLng(19.693706, -100.556223))
                .add(new LatLng(19.693672, -100.556353))
                .add(new LatLng(19.693629, -100.556433))
                .add(new LatLng(19.693583, -100.556877))
                .add(new LatLng(19.693545, -100.557020))
                .add(new LatLng(19.693452, -100.557379))
                .add(new LatLng(19.693439, -100.557633))
                .add(new LatLng(19.693497, -100.557858))
                .add(new LatLng(19.693559, -100.558404))
                .add(new LatLng(19.693560, -100.558576))
                .add(new LatLng(19.693549, -100.558741))
                .add(new LatLng(19.694144, -100.558802))
                .add(new LatLng(19.695235, -100.558907))
                .add(new LatLng(19.696078, -100.558987))
                .add(new LatLng(19.696654, -100.559051))
                .add(new LatLng(19.696654, -100.559051))
                .add(new LatLng(19.695200, -100.560963))
                .add(new LatLng(19.694998, -100.561256))
                .add(new LatLng(19.694953, -100.561384))
                .add(new LatLng(19.694779, -100.561966))
                .add(new LatLng(19.694490, -100.562977))
                .add(new LatLng(19.694469, -100.563129))
                .add(new LatLng(19.694542, -100.563157))
                .add(new LatLng(19.694577, -100.563216))
                .add(new LatLng(19.695014, -100.563285))
                .add(new LatLng(19.695804, -100.563458))
                .add(new LatLng(19.696276, -100.563587))
                .add(new LatLng(19.697359, -100.564070))
                .add(new LatLng(19.697788, -100.564277))
                .add(new LatLng(19.697881, -100.564295))
                .add(new LatLng(19.698247, -100.564603))
                .add(new LatLng(19.698830, -100.565134))
                .add(new LatLng(19.699014, -100.565292))
                .add(new LatLng(19.699167, -100.565380))
                .add(new LatLng(19.699540, -100.565534))
                .add(new LatLng(19.699899, -100.565679))
                .add(new LatLng(19.699755, -100.566309))
                .add(new LatLng(19.699619, -100.566985))
                .add(new LatLng(19.699445, -100.567975))
                .add(new LatLng(19.699291, -100.568796))
                .add(new LatLng(19.700410, -100.569094))
                .add(new LatLng(19.701698, -100.569435))
                .add(new LatLng(19.702736, -100.569735))
                .add(new LatLng(19.703698, -100.569960))
                .add(new LatLng(19.704204, -100.570071))
                .add(new LatLng(19.704777, -100.570028))
                .add(new LatLng(19.704026, -100.571021))
                .add(new LatLng(19.703334, -100.571938))
                .add(new LatLng(19.703132, -100.572252))
                .add(new LatLng(19.702945, -100.572625))
                .add(new LatLng(19.702781, -100.573081))
                .add(new LatLng(19.702728, -100.574001))
                .add(new LatLng(19.702735, -100.577046))
                .add(new LatLng(19.702666, -100.577421))
                .add(new LatLng(19.702482, -100.577836))
                .add(new LatLng(19.702271, -100.578121))
                .add(new LatLng(19.702038, -100.578339))
                .add(new LatLng(19.700685, -100.579059))
                .add(new LatLng(19.698962, -100.579931))
                .add(new LatLng(19.698564, -100.580260))
                .add(new LatLng(19.698306, -100.580781))
                .add(new LatLng(19.698239, -100.581264))
                .add(new LatLng(19.698683, -100.583840))
                .add(new LatLng(19.699312, -100.587592))
                .add(new LatLng(19.699633, -100.589974))
                .add(new LatLng(19.699738, -100.590804))
                .add(new LatLng(19.699551, -100.592597))
                .add(new LatLng(19.699173, -100.595641))
                .add(new LatLng(19.698756, -100.599269))
                .add(new LatLng(19.698515, -100.601218))
                .add(new LatLng(19.698181, -100.604095))
                .add(new LatLng(19.697558, -100.603929))
                .add(new LatLng(19.696472, -100.603586))
                .add(new LatLng(19.694982, -100.603151))
                .add(new LatLng(19.694164, -100.602877))
                .add(new LatLng(19.693800, -100.602684))
                .add(new LatLng(19.690217, -100.601501))
                .add(new LatLng(19.687641, -100.600672))
                .add(new LatLng(19.687244, -100.600537))
                .add(new LatLng(19.687184, -100.600622))
                .add(new LatLng(19.687124, -100.600638))
                .add(new LatLng(19.687046, -100.600609))
                .add(new LatLng(19.687011, -100.600548))
                .add(new LatLng(19.687048, -100.600411))
                .add(new LatLng(19.686696, -100.600202))
                .add(new LatLng(19.685868, -100.599727))
                .add(new LatLng(19.685262, -100.599361)).width(5).color(Color.GREEN);
        PolylineOptions rutaB = new PolylineOptions()
                .add(new LatLng( 19.683656, -100.548860))
                .add(new LatLng(19.682604, -100.549486))
                .add(new LatLng(19.682365, -100.549704))
                .add(new LatLng(19.682011, -100.550141))
                .add(new LatLng(19.681455, -100.550916))
                .add(new LatLng(19.681098, -100.551589))
                .add(new LatLng(19.681068, -100.551938))
                .add(new LatLng(19.681192, -100.552495))
                .add(new LatLng(19.681439, -100.553493))
                .add(new LatLng(19.681750, -100.554826))
                .add(new LatLng(19.682121, -100.556564))
                .add(new LatLng(19.683789, -100.563619))
                .add(new LatLng(19.684212, -100.564652))
                .add(new LatLng(19.684429, -100.565175))
                .add(new LatLng(19.684606, -100.565870))
                .add(new LatLng(19.684838, -100.567093))
                .add(new LatLng(19.684838, -100.567093))
                .add(new LatLng(19.685301, -100.568335))
                .add(new LatLng(19.685486, -100.568634))
                .add(new LatLng(19.686310, -100.568571))
                .add(new LatLng(19.686310, -100.568571))
                .add(new LatLng(19.689646, -100.568112))
                .add(new LatLng(19.691085, -100.567731))
                .add(new LatLng(19.691897, -100.569645))
                .add(new LatLng(19.692921, -100.571875))
                .add(new LatLng(19.693089, -100.572437))
                .add(new LatLng(19.693458, -100.574054))
                .add(new LatLng(19.694397, -100.578195))
                .add(new LatLng(19.694854, -100.580405))
                .add(new LatLng(19.695595, -100.583647))
                .add(new LatLng(19.695911, -100.584943))
                .add(new LatLng(19.696146, -100.585536))
                .add(new LatLng(19.696479, -100.586190))
                .add(new LatLng(19.696668, -100.586485))
                .add(new LatLng(19.698006, -100.587995))
                .add(new LatLng(19.698339, -100.588218))
                .add(new LatLng(19.698621, -100.588289))
                .add(new LatLng(19.699409, -100.588192)).width(5).color(Color.GRAY);
        PolylineOptions rutaC = new PolylineOptions()
                .add(new LatLng(19.708189, -100.517606))
                .add(new LatLng(19.708161, -100.517636))
                .add(new LatLng(19.708058, -100.517734))
                .add(new LatLng(19.707870, -100.517895))
                .add(new LatLng(19.707784, -100.517956))
                .add(new LatLng(19.707612, -100.518026))
                .add(new LatLng(19.707463, -100.518053))
                .add(new LatLng(19.707317, -100.518056))
                .add(new LatLng(19.707133, -100.518026))
                .add(new LatLng(19.706944, -100.517958))
                .add(new LatLng(19.706674, -100.517781))
                .add(new LatLng(19.706626, -100.517808))
                .add(new LatLng(19.706535, -100.518074))
                .add(new LatLng(19.706373, -100.518509))
                .add(new LatLng(19.706133, -100.519053))
                .add(new LatLng(19.705903, -100.519479))
                .add(new LatLng(19.705698, -100.519812))
                .add(new LatLng(19.705511, -100.520045))
                .add(new LatLng(19.705349, -100.520171))
                .add(new LatLng(19.705185, -100.520241))
                .add(new LatLng(19.704955, -100.520246))
                .add(new LatLng(19.704644, -100.520281))
                .add(new LatLng(19.704419, -100.520337))
                .add(new LatLng(19.704202, -100.520431))
                .add(new LatLng(19.703747, -100.520731))
                .add(new LatLng(19.703548, -100.520938))
                .add(new LatLng(19.703346, -100.521308))
                .add(new LatLng(19.703136, -100.521595))
                .add(new LatLng(19.703040, -100.521702))
                .add(new LatLng(19.702911, -100.521788))
                .add(new LatLng(19.702757, -100.521836))
                .add(new LatLng(19.702229, -100.521967))
                .add(new LatLng(19.701287, -100.522184))
                .add(new LatLng(19.700423, -100.522340))
                .add(new LatLng(19.699491, -100.522402))
                .add(new LatLng(19.699115, -100.522461))
                .add(new LatLng(19.699115, -100.522461))
                .add(new LatLng(19.698038, -100.522648))
                .add(new LatLng(19.697359, -100.522809))
                .add(new LatLng(19.696692, -100.523016))
                .add(new LatLng(19.695927, -100.523260))
                .add(new LatLng(19.695604, -100.523373))
                .add(new LatLng(19.695430, -100.523470))
                .add(new LatLng(19.695099, -100.523776))
                .add(new LatLng(19.694617, -100.524315))
                .add(new LatLng(19.694617, -100.524315))
                .add(new LatLng(19.694329, -100.524692))
                .add(new LatLng(19.694334, -100.524764))
                .add(new LatLng(19.694372, -100.524858))
                .add(new LatLng(19.694508, -100.524960))
                .add(new LatLng(19.695248, -100.524818))
                .add(new LatLng(19.695720, -100.524743))
                .add(new LatLng(19.696063, -100.524735))
                .add(new LatLng(19.696414, -100.524786))
                .add(new LatLng(19.696760, -100.524872))
                .add(new LatLng(19.697164, -100.525049))
                .add(new LatLng(19.697439, -100.525239))
                .add(new LatLng(19.697803, -100.525572))
                .add(new LatLng(19.698207, -100.526028))
                .add(new LatLng(19.698785, -100.526717))
                .add(new LatLng(19.699505, -100.527581))
                .add(new LatLng(19.700434, -100.528694))
                .add(new LatLng(19.701507, -100.529992))
                .add(new LatLng(19.701815, -100.530346))
                .add(new LatLng(19.702449, -100.530923))
                .add(new LatLng(19.703388, -100.531704))
                .add(new LatLng(19.704721, -100.532814))
                .add(new LatLng(19.706761, -100.534506))
                .add(new LatLng(19.711789, -100.538630))
                .add(new LatLng(19.712165, -100.539250))
                .add(new LatLng(19.712283, -100.539899))
                .add(new LatLng(19.712204, -100.540434))
                .add(new LatLng(19.711527, -100.542447))
                .add(new LatLng(19.710826, -100.544338))
                .add(new LatLng(19.709931, -100.546518))
                .add(new LatLng(19.709696, -100.546907))
                .add(new LatLng(19.709168, -100.547433))
                .add(new LatLng(19.708355, -100.548136))
                .add(new LatLng(19.708136, -100.548458))
                .add(new LatLng(19.707987, -100.548831))
                .add(new LatLng(19.707815, -100.550419))
                .add(new LatLng(19.707583, -100.552315))
                .add(new LatLng(19.707358, -100.554329))
                .add(new LatLng(19.707080, -100.556644))
                .add(new LatLng(19.706897, -100.560057))
                .add(new LatLng(19.706700, -100.564855))
                .add(new LatLng(19.706554, -100.567271))
                .add(new LatLng(19.706406, -100.567810))
                .add(new LatLng(19.706000, -100.568440))
                .add(new LatLng(19.704785, -100.570042)).width(5).color(Color.RED);
// Get back the mutable Polyline
        Polyline polyline = mMap.addPolyline(polylineOptions);
        Polyline poly = mMap.addPolyline(rutaC);
        Polyline polyb = mMap.addPolyline(rutaB);
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
}