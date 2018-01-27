package com.square.race;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final double miles =1.60934;
    EditText etDistanceI, etHoursI, etMinI, etSecondsI, etSpeedII, etDistanceII, etSpeedIII, etHoursIII, etMinIII, etSecondsIII;
    TextView tvSpeedResultI, tvTimeResultII, tvDistanceResultIII;
    Button btnSpeedI, btnTimeII, btnDistanceIII;
    RadioButton rbDistanceMilesI, rbDistanceKmI, rbMphII, rbKmhII, rbMilesII, rbKmII, rbMphIII, rbKmhIII;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etDistanceI =(EditText)findViewById(R.id.etDistanceI);
        etHoursI=(EditText)findViewById(R.id.etHoursI);
        etMinI=(EditText)findViewById(R.id.etMinI);
        etSecondsI=(EditText)findViewById(R.id.etSecondsI);
        etSpeedII=(EditText)findViewById(R.id.etSpeedII);
        etDistanceII=(EditText)findViewById(R.id.etDistanceII);
        etSpeedIII=(EditText)findViewById(R.id.etSpeedIII);
        etHoursIII=(EditText)findViewById(R.id.etHoursIII);
        etMinIII=(EditText)findViewById(R.id.etMinIII);
        etSecondsIII=(EditText)findViewById(R.id.etSecondsIII);
        tvSpeedResultI=(TextView)findViewById(R.id.tvSpeedResultI);
        tvTimeResultII=(TextView)findViewById(R.id.tvTimeResultII);
        tvDistanceResultIII=(TextView)findViewById(R.id.tvDistanceResultIII);
        rbDistanceMilesI=(RadioButton)findViewById(R.id.rbDistanceMilesI);
        rbDistanceKmI=(RadioButton)findViewById(R.id.rbDistanceKmI);
        rbMphII=(RadioButton)findViewById(R.id.rbMphII);
        rbKmhII=(RadioButton)findViewById(R.id.rbKmhII);
        rbMilesII=(RadioButton)findViewById(R.id.rbMilesII);
        rbKmII=(RadioButton)findViewById(R.id.rbKmII);
        rbMphIII=(RadioButton)findViewById(R.id.rbMphIII);
        rbKmhIII=(RadioButton)findViewById(R.id.rbKmhIII);
        btnSpeedI=(Button)findViewById(R.id.btnSpeedI);
        btnTimeII=(Button)findViewById(R.id.btnTimeII);
        btnDistanceIII=(Button)findViewById(R.id.btnDistanceIII);

        btnSpeedI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //TODO stuff gets here
                if(etDistanceI.getText().toString().isEmpty()){
                    etDistanceI.requestFocus();
                    Toast toast = Toast.makeText(getApplicationContext(), "Fill the distance field",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
                    toast.show();
                }
                else if(etHoursI.getText().toString().trim().isEmpty()){
                    etHoursI.requestFocus();
                    Toast toast = Toast.makeText(getApplicationContext(), "Fill the hours field",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
                    toast.show();
                }
                else if(etMinI.getText().toString().isEmpty()){
                    etMinI.requestFocus();
                    Toast toast = Toast.makeText(getApplicationContext(), "Fill the minutes field",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
                    toast.show();
                }
                else if(etSecondsI.getText().toString().isEmpty()){
                    etSecondsI.requestFocus();
                    Toast toast = Toast.makeText(getApplicationContext(), "Fill the seconds field",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
                    toast.show();
                }
                else {
                    String distanceMiles=rbDistanceMilesI.isChecked()?etDistanceI.getText().toString().trim():(Double.parseDouble(etDistanceI.getText().toString().trim())/miles)+"";
                    String distanceKm=rbDistanceKmI.isChecked()?etDistanceI.getText().toString().trim():(Double.parseDouble(etDistanceI.getText().toString().trim())*miles)+"";
                    String time=(Integer.parseInt(etHoursI.getText().toString().trim())+(((Integer.parseInt(etMinI.getText().toString().trim())*60)+Integer.parseInt(etSecondsI.getText().toString().trim()))/3600.0))+"";
                    String speedMiles=Math.floor(Double.parseDouble(distanceMiles)/Double.parseDouble(time) * 100) / 100+"";
                    String speedKm=Math.floor(Double.parseDouble(distanceKm)/Double.parseDouble(time)* 100) / 100+"";
                    if(rbDistanceMilesI.isChecked())tvSpeedResultI.setText("       "+speedMiles+" mph");
                    if(rbDistanceKmI.isChecked())tvSpeedResultI.setText("       "+speedKm+" kmh");
                }
            }
        });

        btnTimeII.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO stuff gets here
                if(etDistanceII.getText().toString().isEmpty()){
                    etDistanceII.requestFocus();
                    Toast toast = Toast.makeText(getApplicationContext(), "Fill the distance field",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
                    toast.show();
                }
                else if(etSpeedII.getText().toString().trim().isEmpty()){
                    etSpeedII.requestFocus();
                    Toast toast = Toast.makeText(getApplicationContext(), "Fill the speed field",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
                    toast.show();
                }
                else{
                    String speed=etSpeedII.getText().toString().trim();
                    String distanceMiles=rbMilesII.isChecked()?etDistanceII.getText().toString().trim():(Double.parseDouble(etDistanceII.getText().toString().trim())/miles)+"";
                    String distanceKm=rbKmII.isChecked()?etDistanceII.getText().toString().trim():(Double.parseDouble(etDistanceII.getText().toString().trim())*miles)+"";


                    if(rbMilesII.isChecked()&&rbMphII.isChecked())tvTimeResultII.setText("       "+
                            hour2HourMinSec(Double.parseDouble(distanceMiles)/Double.parseDouble(speed))
                            );
                    if(rbMilesII.isChecked()&&rbKmhII.isChecked())tvTimeResultII.setText("       "+
                            hour2HourMinSec((Double.parseDouble(distanceMiles)*miles)/Double.parseDouble(speed))
                    );
                    if(rbKmII.isChecked()&&rbKmhII.isChecked())tvTimeResultII.setText("       "+
                            hour2HourMinSec((Double.parseDouble(distanceKm))/Double.parseDouble(speed))
                    );
                    if(rbKmII.isChecked()&&rbMphII.isChecked())tvTimeResultII.setText("       "+
                            hour2HourMinSec((Double.parseDouble(distanceKm))/Double.parseDouble(speed)*miles)
                    );
                }
            }
        });

        btnDistanceIII.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO stuff gets here
                if(etSpeedIII.getText().toString().isEmpty()){
                    etSpeedIII.requestFocus();
                    Toast toast = Toast.makeText(getApplicationContext(), "Fill the speed field",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
                    toast.show();
                }
                else if(etHoursIII.getText().toString().trim().isEmpty()){
                    etHoursIII.requestFocus();
                    Toast toast = Toast.makeText(getApplicationContext(), "Fill the hours field",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
                    toast.show();
                }
                else if(etMinIII.getText().toString().isEmpty()){
                    etMinIII.requestFocus();
                    Toast toast = Toast.makeText(getApplicationContext(), "Fill the minutes field",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
                    toast.show();
                }
                else if(etSecondsIII.getText().toString().isEmpty()){
                    etSecondsIII.requestFocus();
                    Toast toast = Toast.makeText(getApplicationContext(), "Fill the seconds field",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
                    toast.show();
                }
                else {
                    String speed=etSpeedIII.getText().toString().trim();
                    String time=(Integer.parseInt(etHoursIII.getText().toString().trim())+(((Integer.parseInt(etMinIII.getText().toString().trim())*60)+Integer.parseInt(etSecondsIII.getText().toString().trim()))/3600.0))+"";
                    String distance=Math.floor(Double.parseDouble(speed)*Double.parseDouble(time)* 100) / 100+"";
                    if(rbMphIII.isChecked())tvDistanceResultIII.setText("       "+distance+" Miles");
                    if(rbKmhIII.isChecked())tvDistanceResultIII.setText("       "+distance+" Km");
                }
            }
        });

    }

    private String hour2HourMinSec(double v) {
        double finalBuildTime = v;
        int hours = (int) finalBuildTime;
        int minutes = (int) (finalBuildTime * 60) % 60;
        int seconds = (int) (finalBuildTime * (60*60)) % 60;
        return(String.format("%s:%s:%s", hours, minutes, seconds));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        rbDistanceMilesI=(RadioButton)findViewById(R.id.rbDistanceMilesI);
        rbDistanceKmI=(RadioButton)findViewById(R.id.rbDistanceKmI);
        rbMphII=(RadioButton)findViewById(R.id.rbMphII);
        rbKmhII=(RadioButton)findViewById(R.id.rbKmhII);
        rbMilesII=(RadioButton)findViewById(R.id.rbMilesII);
        rbKmII=(RadioButton)findViewById(R.id.rbKmII);
        rbMphIII=(RadioButton)findViewById(R.id.rbMphIII);
        rbKmhIII=(RadioButton)findViewById(R.id.rbKmhIII);
        switch (item.getItemId()) {
            case R.id.km:
                rbDistanceMilesI.setChecked(false);
                rbDistanceKmI.setChecked(true);
                rbMphII.setChecked(false);
                rbKmhII.setChecked(true);
                rbMilesII.setChecked(false);
                rbKmII.setChecked(true);
                rbMphIII.setChecked(false);
                rbKmhIII.setChecked(true);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
