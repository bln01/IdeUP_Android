package org.techtown.ideup.UserComplain;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.ideup.R;
import org.techtown.ideup.retrofit.RetrofitClient;
import org.techtown.ideup.retrofit.dto.ComplainDto;
import org.techtown.ideup.retrofit.serviceImpl.ComplainServiceImpl;

import java.io.IOException;
import java.util.ArrayList;

public class UserComplainAdapter extends RecyclerView.Adapter<UserComplainAdapter.ViewHolder> {

    OnUserComplainClickListener listener;
    ArrayList<ComplainDto> complains = new ArrayList<>();

    private final ComplainServiceImpl complainService;

    public UserComplainAdapter(ComplainServiceImpl complainService) {
        this.complainService = complainService;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_user_complain, parent, false);
        return new ViewHolder(itemView, listener, complainService);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ComplainDto complain = complains.get(position);
        holder.setTextView(complain);
//        ChallengeItem item = items.get(position);
//        holder.setItem(item);
    }


    @Override
    public int getItemCount() {
        return complains.size();
    }

    public void addItem(ComplainDto complain){
        complains.add(complain);
    }

    public void setItems(ArrayList<ComplainDto> complains){ //ArrayList전체를 설정할 수 있는 함수
        this.complains = complains;
    }


    public ComplainDto getItem(int position){
        return complains.get(position);
    }

    public void setComplain(int position, ComplainDto complain){
        complains.set(position, complain);
    }

    public void setOnItemClickListener(OnUserComplainClickListener listener){ //아이템뷰에 onClickListener 설정하기
        this.listener=listener;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private Button likeBT;
        private Button replyBT;
        private Long projectId;
        private ComplainServiceImpl complainService;

        public void setTextView(ComplainDto complain){
            textView.setText(complain.getComplainContent());
            projectId = complain.getId();
        }

        public ViewHolder(final View itemView, final OnUserComplainClickListener listener, final ComplainServiceImpl complainService) {
            super(itemView);

            this.complainService = complainService;
            textView = itemView.findViewById(R.id.complainText);
            likeBT = itemView.findViewById(R.id.likeBT);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            likeBT.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("Test", "좋아요 버튼 클릭");
                    try {
                        complainService.postLike(projectId);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


    }
}
