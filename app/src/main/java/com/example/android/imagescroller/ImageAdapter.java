package com.example.android.imagescroller;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ImageAdapter extends ArrayAdapter<ImageUpload> {
    private Context mContext;
    private List<ImageUpload> mUploads;

    ImageAdapter(Context context, List<ImageUpload> uploads) {
       // mContext = context;

        super(context,0,uploads);
        // mUploads = uploads;
    }
/*
    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.image_item, parent, false);

        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        ImageUpload uploadCurrent = mUploads.get(position);
holder.textViewName.setText(uploadCurrent.getName());
//holder.textViewName.setTextColor(000);
        Picasso.get()
                .load(uploadCurrent.getUri())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public ImageView imageView;

        public ImageViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.text_view_name);
            imageView = itemView.findViewById(R.id.image_view_upload);
        }
    }*/

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.image_item, parent, false);
        }
        // Get the {@link AndroidFlavor} object located at this position in the list
        ImageUpload currentWord = getItem(position);
        //androidflavor=words


        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.text_view_name);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentWord.getName());
        nameTextView.setTextSize(18);
        nameTextView.setTypeface(Typeface.DEFAULT_BOLD);/*
        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView timeToTextView = (TextView) listItemView.findViewById(R.id.time_to);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        timeToTextView.setText(currentWord.getTimeTo());

        TextView timeFrmTextView = (TextView) listItemView.findViewById(R.id.time_from);
        timeFrmTextView.setText(currentWord.getTimeFrom());*/

        ImageView img = listItemView.findViewById(R.id.image_view_upload);
        img.setImageURI(Uri.parse(currentWord.getUri()));

      /*  View textContainer =listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),cid);
        textContainer.setBackgroundColor(color);
       */
        return listItemView;
        //return super.getView(position, convertView, parent);
    }
}