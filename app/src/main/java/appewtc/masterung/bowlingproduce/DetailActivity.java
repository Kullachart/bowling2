package appewtc.masterung.bowlingproduce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    //Explicit
    private TextView titleTextView,DescripTextView, priceTextView;
    private ImageView imageView;
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Bind Wiget
        titleTextView = (TextView) findViewById(R.id.textView9);
        DescripTextView = (TextView) findViewById(R.id.textView11);
        priceTextView = (TextView) findViewById(R.id.textView10);
        imageView = (ImageView) findViewById(R.id.imageView6);
        button = (Button) findViewById(R.id.button2);


        // SHow Text
        titleTextView.setText(getIntent().getStringExtra("Title"));
        DescripTextView.setText(getIntent().getStringExtra("Descrip"));
        priceTextView.setText(getIntent().getStringExtra("Price"));

        // Show Image
        Picasso.with(this).load(getIntent()
                .getStringExtra("Icon")).resize(300,300).into(imageView);

        // Picasso.with(this).load(getIntent()
        //     .getStringExtra("Icon")).resize(150,180).into(imageView);




        // Button Controller
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Image Controller
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DetailActivity.this, ShowBigActivity.class);
                intent.putExtra("Icon", getIntent().getStringExtra("Icon"));
                startActivity(intent);


            }
        });




    }  // Main Method
}  // Main Class
