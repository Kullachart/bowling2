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

public class CatAdapter extends BaseAdapter{
    // Explicit
    private Context context;

    public CatAdapter(Context context, String[] tieleString, String[] iconString) {
        this.context = context;
        this.tieleString = tieleString;
        this.iconString = iconString;
    }

    private String[] tieleString, iconString;


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
        View view = layoutInflater.inflate(R.layout.cat_listview, parent, false);

        // Bind Wiget
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView11);
        TextView textView = (TextView) view.findViewById(R.id.textView18);

        // Show View
        Picasso.with(context).load(iconString[position]).into(imageView);
        textView.setText(tieleString[position]);

        return view;
    }
}  // Main Class
