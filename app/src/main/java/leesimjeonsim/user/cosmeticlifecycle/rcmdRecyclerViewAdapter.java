package leesimjeonsim.user.cosmeticlifecycle;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class rcmdRecyclerViewAdapter extends RecyclerView.Adapter<rcmdRecyclerViewAdapter.ViewHolder>{
    @NonNull

    private final List<rcmdItemData.rcmdItem> mValues;
    private final rcmdFragmend.OnListFragmentInteractionListener mListener;

    public rcmdRecyclerViewAdapter(List<rcmdItemData.rcmdItem> items, rcmdFragmend.OnListFragmentInteractionListener listener) {
        Log.d("TAG","rcmda");
        mValues = items;
        mListener = listener;
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_rcmditem, parent, false);
        Log.d("TAG","rcmdb");
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.name.setText(mValues.get(position).name);
        holder.rcmd_dday.setText(mValues.get(position).rcmd_dday);
        holder.item_name1.setText(mValues.get(position).item_name1);
        holder.item_brand1.setText(mValues.get(position).item_brand1);

        holder.item_name1.setText(mValues.get(position).item_name2);
        holder.item_brand1.setText(mValues.get(position).item_brand2);
        Log.d("TAG","rcmd"+mValues.get(position).item_brand2);

        holder.item_name1.setText(mValues.get(position).item_name3);
        holder.item_brand1.setText(mValues.get(position).item_brand3);
        Log.d("TAG","rcmdc");
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView name;
        public final TextView rcmd_dday;
        public final TextView item_name1;
        public final TextView item_brand1;
        public final TextView item_name2;
        public final TextView item_brand2;
        public final TextView item_name3;
        public final TextView item_brand3;
        public rcmdItemData.rcmdItem mItem;
        public ViewHolder(@NonNull View view) {
            super(view);
            Log.d("TAG","rcmdd");
            mView = view;
            name = (TextView) view.findViewById(R.id.name);
            rcmd_dday = (TextView) view.findViewById(R.id.rcmd_dday);
            item_name1 = (TextView) view.findViewById(R.id.item_name1);
            item_brand1 = (TextView) view.findViewById(R.id. item_brand1);

            item_name2 = (TextView) view.findViewById(R.id.item_name2);
            item_brand2 = (TextView) view.findViewById(R.id. item_brand2);

            item_name3 = (TextView) view.findViewById(R.id.item_name3);
            item_brand3 = (TextView) view.findViewById(R.id. item_brand3);
        }
    }
}
