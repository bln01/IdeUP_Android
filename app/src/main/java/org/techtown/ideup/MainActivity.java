package org.techtown.ideup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.techtown.ideup.InfoTeam.MyTeamFragment;
import org.techtown.ideup.ListTeam.ListTeamFragment;
import org.techtown.ideup.ProjectList.ProjectListFragment;
import org.techtown.ideup.TeamComplain.TeamComplainFragment;
import org.techtown.ideup.UserComplain.UserComplainFragment;
import org.techtown.ideup.UserComplain.UserComplainRegisterFragment;
import org.techtown.ideup.retrofit.serviceImpl.ProjectServiceImpl;

public class MainActivity extends AppCompatActivity {

    ProjectServiceImpl projectService = new ProjectServiceImpl();

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private UserComplainFragment userComplainFragment = new UserComplainFragment();
    private TeamComplainFragment teamComplainFragment = new TeamComplainFragment();
    private UserComplainRegisterFragment userComplainRegisterFragment = new UserComplainRegisterFragment();
    private ProjectListFragment projectListFragment = new ProjectListFragment(projectService);
    private ListTeamFragment listTeamFragment = new ListTeamFragment();
    private MyTeamFragment myTeamFragment = new MyTeamFragment();

//    private org.techtown.ideup.InfoTeam.infoTeamActivity infoTeamActivity = new infoTeamActivity();

    private String state="";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == Activity.RESULT_OK){
            state = data.getStringExtra("UserState");
            if( state.equals("user")){
                getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, userComplainFragment).commitAllowingStateLoss();
            }
            else {
                getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, teamComplainFragment).commitAllowingStateLoss();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent1 = new Intent (this, LoginActivity.class);
        startActivityForResult(intent1, 0);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        if( state.equals("user")){
            getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, userComplainFragment).commitAllowingStateLoss();
        }
        else {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, teamComplainFragment).commitAllowingStateLoss();
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tab1: {
                        if(state.equals("user")){
                            getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, userComplainFragment).commitAllowingStateLoss();
                        }
                        else {
                            getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, teamComplainFragment).commitAllowingStateLoss();
                        }
                        return true;
                    }
                    case R.id.tab2: {
                        if(state.equals("user")) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, listTeamFragment).commitAllowingStateLoss();
                        }
                        else {
                            getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, myTeamFragment).commitAllowingStateLoss();
                        }
                        return true;
                    }
                    case R.id.tab3: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, projectListFragment).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.tab4: {
                        // 4번 버튼.?
                        return true;
                    }
                    default:
                        return false;
                }
            }
        });
    }

    public void setFragment(String fragment){ // 프래그먼트 replace

        if(fragment.equals("userComplain")){ // 소비자문의리스트 프래그먼트
            fragmentManager.beginTransaction().replace(R.id.main_layout, userComplainFragment).commit();
        }
        else if(fragment.equals("teamComplain")){ // 창업팀에서 보는 소비자문의리스트 프래그먼트
            fragmentManager.beginTransaction().replace(R.id.main_layout, teamComplainFragment).commit();
        }
        else if(fragment.equals("userComplainRegister")){ // 소비자문의 등록 프래그먼트
            fragmentManager.beginTransaction().replace(R.id.main_layout,userComplainRegisterFragment).commit();
        }
        else if(fragment.equals("projectList")){ // 프로젝트 프래그먼트
            fragmentManager.beginTransaction().replace(R.id.main_layout,projectListFragment).commit();
        }
        else if(fragment.equals("listTeam")){
            fragmentManager.beginTransaction().replace(R.id.main_layout, listTeamFragment).commit();
        }

    }
}
