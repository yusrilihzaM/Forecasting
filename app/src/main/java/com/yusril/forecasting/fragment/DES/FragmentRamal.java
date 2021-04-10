package com.yusril.forecasting.fragment.DES;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yusril.forecasting.DataDesItem;
import com.yusril.forecasting.DataRamalDesItem;
import com.yusril.forecasting.GetHasilDesResponse;
import com.yusril.forecasting.GetRamalDesResponse;
import com.yusril.forecasting.R;
import com.yusril.forecasting.RestClient;
import com.yusril.forecasting.adapter.HasildesAdapter;
import com.yusril.forecasting.adapter.RamalDesAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentRamal#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRamal extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private RamalDesAdapter adapter;
    private List<DataRamalDesItem> listItem;
    private ArrayList<GetRamalDesResponse> movieList;
    public FragmentRamal() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentRamal.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentRamal newInstance(String param1, String param2) {
        FragmentRamal fragment = new FragmentRamal();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_ramal, container, false);
        RestClient.getService().getHasilRamalDes().enqueue(new Callback<GetRamalDesResponse>() {
            @Override
            public void onResponse(Call<GetRamalDesResponse> call, Response<GetRamalDesResponse> response) {

                    listItem = response.body().getDataRamalDes();
                Log.d("API lisitem", String.valueOf(response.body().getDataRamalDes()));
                adapter = new RamalDesAdapter(listItem, getContext());
                recyclerView = view.findViewById(R.id.rv_ramal_des);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(adapter);
            }


            @Override
            public void onFailure(Call<GetRamalDesResponse> call, Throwable t) {

            }
        });
        return view;
    }
}