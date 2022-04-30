package com.example.gongguham_;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private FirebaseAuth mAuth;
    private static final String TAG = "MainActivity";
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


    //    RecyclerView 생성
    private RecyclerView mRecyclerView;
    private PostAdaptor postAdaptor;
    private ArrayList<PostItem> postItems;
    private AppCompatButton btn_add;
    private AppCompatButton btn_state;
    private Spinner sort_spinner;

    String[] sort_by = {"option1", "option2", "option3"};


    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);

//        Add Post Button onClickListener
        btn_add = (AppCompatButton) rootView.findViewById(R.id.btn_add_post);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), AddPostItem.class));
            }
        });
//        State Select Button onClickListener
        btn_state = (AppCompatButton) rootView.findViewById(R.id.btn_select);
        btn_state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivityForResult(new Intent(getActivity(), gpsActivity.class),0);
            }
        });
        //        Spinner 생성
        sort_spinner = (Spinner) rootView.findViewById(R.id.sort_spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item,sort_by);
        sort_spinner.setAdapter(arrayAdapter);
        sort_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("spinner Event", "선택됨");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

//        RecyclerView 생성
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.RecyclePostList);
        postAdaptor = new PostAdaptor(getActivity(), postItems);
        mRecyclerView.setAdapter(postAdaptor);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        postItems = new ArrayList<>();

//        Sample Data
        for(int i = 0; i<30; i++){
            postItems.add(new PostItem("교촌치킨 드실 분!!", "명덕관 1층", "18:30", "5명", i));
        }
        postAdaptor.setPostlist(postItems);



        return rootView;
    }

    private  void startLoginActivity(){
        Intent intent=new Intent(getContext(),loginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    private  void startmemberInitActivity(){
        Intent intent=new Intent(getContext(),memberInitActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 0){
            String state = data.getStringExtra("STATE");
            Log.i("StateSelectResult",state);
        }
    }


}