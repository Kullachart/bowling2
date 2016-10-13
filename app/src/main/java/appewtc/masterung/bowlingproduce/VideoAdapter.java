package appewtc.masterung.bowlingproduce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by bowlingsakul on 10/13/2016 AD.
 */

public class VideoAdapter extends BaseAdapter{
    // Explicit
    private Context context;
    private String[] tieleString;
    private int[] ints;

    public VideoAdapter(Context context, String[]
                        tieleString, int[] ints) {
        this.context = context;
        this.tieleString = tieleString;
        this.ints = ints;
    }

    @Override
    public int getCount() {
        return tieleString.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.video_listview, parent, false);

        // Bind Wiget
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView12);
        TextView textView = (TextView) view.findViewById(R.id.textView19);

        // Show View
        textView.setText(tieleString[position]);
        imageView.setImageResource(ints[position]);

        return view;
    }
}  // Main Class
