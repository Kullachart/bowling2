package appewtc.masterung.bowlingproduce;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main2Activity extends AppCompatActivity {

    // Explicit
    private String urlJson = "http://203.147.24.71/ars/get_cat.php";
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = (ListView) findViewById(R.id.livShowCat);

        // Create Listview
        SynCat synCat = new SynCat(Main2Activity.this);
        synCat.execute(urlJson);



    }  // Main method

    private class SynCat extends AsyncTask<String, Void, String> {
        // Explicit
        private Context context;

        public SynCat(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(String... params) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(params[0]).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();



            }catch (Exception e) {
                Log.d("13octV1", "e doInBack ==> " + e.toString());
                return null;

            }


        }  // doInBack

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("13octV1", "JSON ==> " + s);

            try {

                JSONArray jsonArray = new JSONArray(s);

                final String[] catStrings = new String[jsonArray.length()];
                String[] imageStrings = new String[jsonArray.length()];
                final String[] urlStrings = new String[jsonArray.length()];

                for (int i=0;i<jsonArray.length();i++) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    catStrings[i] = jsonObject.getString("Category");
                    imageStrings[i] = jsonObject.getString("Image");
                    urlStrings[i] = jsonObject.getString("urlJSON");

                }  // For

                CatAdapter catAdapter = new CatAdapter(context, catStrings, imageStrings);
                listView.setAdapter(catAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        if (position == (catStrings.length -1)) {

                            Intent intent = new Intent(Main2Activity.this, VideoListView.class);
                            startActivity(intent);

                        } else {
                            Intent intent = new Intent(Main2Activity.this, ShowListProduct.class);
                            intent.putExtra("urlJSON", urlStrings[position]);
                            intent.putExtra("Category", catStrings[position]);
                            startActivity(intent);
                        }

                    }
                });

            }catch (Exception e){
                Log.d("13octV1", "e onPost ==>" + e.toString());
            }



        }
    } // SynCat Class


}
