package org.beta.android.aakashresearchlabs.test;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Kevin on 6/9/2017.
 */

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ViewHolder>  {


    private Context context;
    List<ChapterClass> chapterList;
    SharedPreferences sharedPreferences;

    public ChapterAdapter(List<ChapterClass> chapterList, Context context){
        super();
        //Getting all the articles
        this.chapterList = chapterList;
        this.context = context;
        sharedPreferences=context.getSharedPreferences(context.getPackageName(),Context.MODE_PRIVATE);
    }

    @Override
    public ChapterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflating the article_view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chapter, parent, false);
        ViewHolder holder=new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ChapterAdapter.ViewHolder holder, int position) {

        final ChapterClass currentChapter=chapterList.get(position);

        holder.title.setText(currentChapter.getCtitle());
        holder.content.setText(currentChapter.getCcontent());
        holder.chapter.setText("Chapter "+(position+1));
        currentChapter.setCompleted(sharedPreferences.getBoolean(currentChapter.getCtitle(),false));
        boolean over=currentChapter.getCompleted();
        if(over)
        {
            holder.mark.setText("Mark as Incomplete");
            holder.markImage.setVisibility(View.VISIBLE);
        }
        else
        {
            holder.mark.setText("Mark as Complete");
            holder.markImage.setVisibility(View.INVISIBLE);

        }


        holder.mark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean over=currentChapter.getCompleted();
                if(over)
                {
                    holder.mark.setText("Mark as Complete");
                    holder.markImage.setVisibility(View.INVISIBLE);

                    int progress = sharedPreferences.getInt(currentChapter.getParentLesson(), 0);
                    sharedPreferences.edit().putInt(currentChapter.getParentLesson(), progress - 1).apply();
                    sharedPreferences.edit().putBoolean(currentChapter.getCtitle(),false).apply();
                    currentChapter.setCompleted(false);
                }
                else
                {
                    holder.mark.setText("Mark as InComplete");
                    holder.markImage.setVisibility(View.VISIBLE);
                    int progress = sharedPreferences.getInt(currentChapter.getParentLesson(), 0);
                    sharedPreferences.edit().putInt(currentChapter.getParentLesson(), progress + 1).apply();
                    sharedPreferences.edit().putBoolean(currentChapter.getCtitle(),true).apply();
                    currentChapter.setCompleted(true);

                }
            }
        });
        holder.goToCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(context,currentChapter.getCclass());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                if(holder.markImage.getVisibility()==View.INVISIBLE){
                    int progress = sharedPreferences.getInt(currentChapter.getParentLesson(), 0);
                    sharedPreferences.edit().putInt(currentChapter.getParentLesson(), progress + 1).apply();
                }

                sharedPreferences.edit().putBoolean(currentChapter.getCtitle(),true).apply();
                currentChapter.setCompleted(true);
                holder.mark.setText("Mark as InComplete");
                holder.markImage.setVisibility(View.VISIBLE);
            }
        });
        //On clicking the view
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return chapterList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        //Defining viewHolder
        TextView chapter,content,title;
        Button goToCourse,mark;
        ImageView markImage;
        public ViewHolder(View itemView) {
            //finding the required views by id
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.Ctitle);
            content=(TextView)itemView.findViewById(R.id.content);
            chapter=(TextView)itemView.findViewById(R.id.chapter);
            goToCourse=(Button)itemView.findViewById(R.id.goToCourse);
            mark=(Button)itemView.findViewById(R.id.mark);
            markImage=(ImageView)itemView.findViewById(R.id.imageMark);
        }

    }

}
