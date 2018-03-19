package com.example.oriaso.kidsnest;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.curioustechizen.ago.RelativeTimeTextView;

/**
 * Created by oriaso on 3/19/18.
 */

public class KidsNestViewHolder extends RecyclerView.ViewHolder {
    TextView textViewKidsNestListTitle, textViewNoticeListSource;
    ImageView imageViewKidsNestListImage;
    RelativeTimeTextView textViewNoticeListSince;
    View mView;


    public KidsNestViewHolder(View itemView){
        super(itemView);
        this.mView = itemView;
        textViewKidsNestListTitle = (TextView) itemView.findViewById(R.id.textViewKidsNestListTitle);
//        textViewNoticeListSource = (TextView) itemView.findViewById(R.id.textViewNewsListAuthor);
//        textViewNoticeListSince = (RelativeTimeTextView) itemView.findViewById(R.id.textViewNoticeListSince);
        imageViewKidsNestListImage = (ImageView) itemView.findViewById(R.id.imageViewKidsNestListImage);
    }
}
