package org.techtown.ideup.ListTeam;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.techtown.ideup.ProjectList.ProjectListAdapter;
import org.techtown.ideup.R;
import org.techtown.ideup.retrofit.dto.TeamDto;
import org.techtown.ideup.retrofit.serviceImpl.TeamServiceImpl;

import java.io.IOException;
import java.util.ArrayList;


public class ListTeamFragment extends Fragment {

    private final TeamServiceImpl teamService;

    public ListTeamFragment(TeamServiceImpl teamService) {
        this.teamService = teamService;
    }

    private RecyclerView listTeam_RV;
    private TeamAdapter teamAdapter;
    private EditText search_edit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list_team, container, false);

        init(rootView);
        setRecyclerview(rootView);
//        addDummy();
        ArrayList<TeamDto> teamList = new ArrayList<>();

        try {
            teamList = teamService.getTeamList();
        } catch (IOException e) {
            e.printStackTrace();
        }

        TeamAdapter adapter = new TeamAdapter();

        for(TeamDto team : teamList){
            adapter.addItem(new Team(R.drawable.ic_launcher_foreground, team.getTeamName(), team.getTeamInfo()));
        }
        listTeam_RV.setAdapter(adapter);

        return rootView;
    }

    private void init(ViewGroup rootView){
        search_edit = rootView.findViewById(R.id.search_edit);
        search_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    
    private void setRecyclerview(ViewGroup rootView){
        listTeam_RV = rootView.findViewById(R.id.listTeam_RV);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        listTeam_RV.setLayoutManager(layoutManager);
        teamAdapter = new TeamAdapter();
        listTeam_RV.setAdapter(teamAdapter);
    }

    private void addDummy(){
        teamAdapter.addItem(new Team(R.drawable.ic_launcher_foreground, "OO팀", "OO을 위한 OO을 주제로 개발 중인 OO팀입니다."));
        teamAdapter.addItem(new Team(R.drawable.ic_launcher_foreground, "OO팀", "저희와 함께 하실 분들 컴온요 베이베"));
        teamAdapter.addItem(new Team(R.drawable.ic_launcher_foreground, "OO팀", "얄리얄리얄라셩 얄라리얄라"));
        teamAdapter.addItem(new Team(R.drawable.ic_launcher_foreground, "OO팀", "눈누난나"));
        teamAdapter.addItem(new Team(R.drawable.ic_launcher_foreground, "OO팀", "드랍 더 빝~!"));
    }
}