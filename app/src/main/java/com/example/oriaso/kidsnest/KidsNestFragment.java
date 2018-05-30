package com.example.oriaso.kidsnest;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class KidsNestFragment extends Fragment {
    private static final String TAG = MainActivity.class.getSimpleName();
    RecyclerView rv;
    LinearLayoutManager linearLayoutManager;
    DatabaseReference db;
    FirebaseRecyclerAdapter<KidsNestModel, KidsNestViewHolder> firebasenewsRecycleAdapter;
    ProgressBar progressBarNoticeList;

    public KidsNestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_kids_nest, container, false);
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_kids_nest, container, false);

        //Initialize Firebase DB
        db = FirebaseDatabase.getInstance().getReference();


        //SETUP RECYCLER
        rv = (RecyclerView) rootView.findViewById(R.id.recyclerViewKidsNestList);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setStackFromEnd(false);


        progressBarNoticeList = (ProgressBar) rootView.findViewById(R.id.progressBarKidsNestList);
        progressBarNoticeList.setVisibility(View.VISIBLE);

//        Query query = db.child("KidsNest").orderByChild("visible").equalTo(true);
        Query query = db.child("KidsNest");

        firebasenewsRecycleAdapter = new FirebaseRecyclerAdapter<KidsNestModel, KidsNestViewHolder>(KidsNestModel.class, R.layout.kids_nest_item, KidsNestViewHolder.class, query) {
            @Override
            protected void populateViewHolder(KidsNestViewHolder viewHolder, final KidsNestModel model, final int position) {
                viewHolder.textViewKidsNestListTitle.setText(model.getName());
                viewHolder.textViewKidsNestListEmail.setText(model.getEmail());
//                viewHolder.textViewNoticeListSince.setReferenceTime(new Date((model.getTimestamp() * -1)).getTime());
                Picasso.with(getActivity()).load(model.getImageUrl()).placeholder(R.mipmap.ic_launcher).into(viewHolder.imageViewKidsNestListImage);

                progressBarNoticeList.setVisibility(View.GONE);
                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //firebasenewsRecycleAdapter.getRef(position).removeValue();
                        openKidsNestDetailActivity(model.getName(), model.getId(), model.getEmail(), model.getPhone(), model.getContactPerson(), model.getContactEmail(), model.getContactPhone(), model.imageUrl);
                    }
                });
            }

            private void openKidsNestDetailActivity(String name, String id, String email, String phone, String contact_person, String contact_email, String contact_phone, String imageUrl) {
                Intent kidsNestIntent = new Intent(getActivity(), KidsNestDetailActivity.class);
                kidsNestIntent.putExtra("nameKey", name);
                kidsNestIntent.putExtra("idKey", id);
                kidsNestIntent.putExtra("emailKey", email);
                kidsNestIntent.putExtra("phoneKey", phone);
                kidsNestIntent.putExtra("contactPersonKey", contact_person);
                kidsNestIntent.putExtra("contactEmailKey", contact_email);
                kidsNestIntent.putExtra("contactPhoneKey", contact_phone);
                kidsNestIntent.putExtra("imageKey", imageUrl);
                startActivity(kidsNestIntent);
            }
        };
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(firebasenewsRecycleAdapter);
        return rootView;
    }

}
