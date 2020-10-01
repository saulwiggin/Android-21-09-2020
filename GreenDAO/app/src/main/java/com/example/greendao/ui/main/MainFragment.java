package com.example.greendao.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.greendao.MainActivity;
import com.example.greendao.R;
import com.example.greendao.entities.DaoMaster;
import com.example.greendao.entities.DaoSession;
import com.example.greendao.entities.User;
import com.example.greendao.entities.UserDao;

import org.greenrobot.greendao.database.Database;

public class MainFragment extends Fragment implements View.OnClickListener {

    private MainViewModel mViewModel;
    private View v;
    private Button b;
    private String TAG ="TAG SAVE DATABASE BUTTON";
    private String name;
    private EditText mName;
    private String DOB;
    private EditText mDOB;
    private String job;
    private EditText mJob;
    private String Employer;
    private EditText mEmployer;
    private DaoSession daoSession;
    private Context context;
    private UserDao userDao;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.main_fragment, container, false);
        b = (Button) v.findViewById(R.id.button);
        b.setOnClickListener((View.OnClickListener) this);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button:
                Log.d(TAG,"Button clicked");
                initDAO();
                //saveUser();
                //initRecyclerView();
        }
    }

    private void initDAO(){
        Log.d(TAG,"initialize the GreenDAO database");
        daoSession = new DaoMaster(
                new DaoMaster.DevOpenHelper(this, "user_table.db").getWritableDb()).newSession();

    }

    private void saveUser(){
        User user = new User();
        mName   = (EditText) v.findViewById(R.id.name);
        name = mName.getText().toString();
        user.setName(name);
        mDOB   = (EditText) v.findViewById(R.id.dob);
        DOB = mDOB.getText().toString();
        user.setDob(DOB);
        mJob   = (EditText) v.findViewById(R.id.job);
        job = mJob.getText().toString();
        user.setDob(job);
        mEmployer   = (EditText) v.findViewById(R.id.employer);
        Employer = mEmployer.getText().toString();
        user.setDob(Employer);

        userDao = daoSession.getUserDao();
        userDao.insert(user);
        
        Log.d(TAG,"save user object" + user);

    }

    private void initRecyclerView(){
        ((MainActivity)getActivity()).openRecyclerView();
    }
}