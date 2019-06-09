package com.example.android.imagescroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImageActivity extends AppCompatActivity {
    private ListView listView;
    //private ImageAdapter mAdapter;

   // private ProgressBar mProgressCircle;

    ArrayList<ImageUpload> obj;
    private DatabaseReference mDatabaseRef;
    private List<ImageUpload> mUploads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("images");
        listView = findViewById(R.id.list_view);

        Toast.makeText(ImageActivity.this, "welcome here__", Toast.LENGTH_SHORT).show();

     /* mRecyclerView.setHasFixedSize(true);
      mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
*/
      //  mProgressCircle = findViewById(R.id.progress_circle);

        mUploads = new ArrayList<ImageUpload>();

//i think it is unable to refer to the particular folder in database and so app keeps stopping. ;(

    mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Toast.makeText(getApplicationContext(),"here!!!",Toast.LENGTH_SHORT).show();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    collectNames((Map<String,ImageUpload>) dataSnapshot.getValue());
                    /*ImageUpload upload = postSnapshot.getValue(ImageUpload.class);
                    mUploads.add(upload);
                */
                }

               ImageAdapter mAdapter = new ImageAdapter(getApplicationContext(), mUploads);

               listView.setAdapter(mAdapter);
             //   mProgressCircle.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(ImageActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
              //  mProgressCircle.setVisibility(View.INVISIBLE);
            }
        });

   }

    private void collectNames(Map<String, ImageUpload> users) {
        obj= new ArrayList<>();

        //iterate through each user, ignoring their UID
        for (Map.Entry<String, ImageUpload> entry : users.entrySet()){

            //Get user map
            Map singleUser = (Map) entry.getValue();
            //Get phone field and append to list
            obj.add( new ImageUpload( singleUser.get("name").toString(),
                    singleUser.get("uri").toString()));


        }
        ImageAdapter adapter = new ImageAdapter(getApplicationContext(), obj);

        listView.setAdapter(adapter);

    }


}