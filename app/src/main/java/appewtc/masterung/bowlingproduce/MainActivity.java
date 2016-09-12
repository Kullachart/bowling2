package appewtc.masterung.bowlingproduce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private ImageView hub1ImageView, hub2ImageView,
            hub3ImageView, hub4ImageView,
            hub5ImageView, hub6Imageview ;
    private String[] catStrings = new String[]{"Category1", "Category2",
            "Category3", "Category4" ,"Category5", "Category6"};
    private String catUserChooseString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        hub1ImageView = (ImageView) findViewById(R.id.imageView2);
        hub2ImageView = (ImageView) findViewById(R.id.imageView3);
        hub3ImageView = (ImageView) findViewById(R.id.imageView4);
        hub4ImageView = (ImageView) findViewById(R.id.imageView5);
        hub5ImageView = (ImageView) findViewById(R.id.imageView7);  // BL
        hub6Imageview = (ImageView) findViewById(R.id.imageView8);  // BL



        //  hub5ImageView = (ImageView) findViewById(R.id.imageView6);

        //Image Controller
        hub1ImageView.setOnClickListener(this);
        hub2ImageView.setOnClickListener(this);
        hub3ImageView.setOnClickListener(this);
        hub4ImageView.setOnClickListener(this);
        hub5ImageView.setOnClickListener(this);
        hub6Imageview.setOnClickListener(this);


    }   // Main Method

    public String[] getCatStrings() {
        return catStrings;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.imageView2:
                catUserChooseString = catStrings[0];
                break;
            case R.id.imageView3:
                catUserChooseString = catStrings[1];
                break;
            case R.id.imageView4:
                catUserChooseString = catStrings[2];
                break;
            case R.id.imageView5:
                catUserChooseString = catStrings[3];
                break;
            case R.id.imageView7:
                catUserChooseString = catStrings[4];
                break;
            case R.id.imageView8:
                catUserChooseString = catStrings[5];
                break;


        }   // switch

        Intent intent = new Intent(MainActivity.this, ShowListProduct.class);
        intent.putExtra("Category", catUserChooseString);
        startActivity(intent);

    }   // onClick

}   // Main Class
