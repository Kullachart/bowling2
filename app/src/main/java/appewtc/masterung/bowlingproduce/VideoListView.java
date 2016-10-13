package appewtc.masterung.bowlingproduce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class VideoListView extends AppCompatActivity {

    //Explicit
    private ListView listView;
    private String[] strings = new String[]{"VDO 1","VDO 2","VDO 3"};
    private int[] ints = new int[]{R.drawable.video1, R.drawable.video2, R.drawable.video3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list_view);

        listView = (ListView) findViewById(R.id.livShowVideo);
        VideoAdapter videoAdapter = new VideoAdapter(this, strings, ints);
        listView.setAdapter(videoAdapter);

    }  // Main Method
}  // Main Class
