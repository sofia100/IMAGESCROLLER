package com.example.android.imagescroller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ImageHolder extends RecyclerView.ViewHolder {
public TextView textViewName;
public ImageView imageView;

public ImageHolder(View itemView) {
        super(itemView);

       }
        void setDetails(Context context,String text,String image)
        {
            textViewName = itemView.findViewById(R.id.text_view_name);
            imageView = itemView.findViewById(R.id.image_view_upload);

            textViewName.setText(text);
            Picasso.get().load(image).into(imageView);
        }
        }
