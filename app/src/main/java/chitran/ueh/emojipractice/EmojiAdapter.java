package chitran.ueh.emojipractice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class EmojiAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<Emoji> arraylist;

    public EmojiAdapter(Context context, int layout, List<Emoji> arraylist) {
        this.context = context;
        this.layout = layout;
        this.arraylist = arraylist;
    }

    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private  class ViewHolder{
        TextView txtview;
        ImageView imgemoji;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            viewHolder = new ViewHolder();
            viewHolder.txtview = (TextView) view.findViewById(R.id.txtemoji);
            viewHolder.imgemoji = (ImageView) view.findViewById(R.id.img);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.txtview.setText(arraylist.get(i).name);
        viewHolder.imgemoji.setImageResource(arraylist.get(i).image);
        return view;
    }
}

