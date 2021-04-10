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
import android.widget.TextView;

import com.yusril.forecasting.DataDesItem;
import com.yusril.forecasting.DataSesItem;
import com.yusril.forecasting.GetHasilDesResponse;
import com.yusril.forecasting.GetMapeDesResponse;
import com.yusril.forecasting.HasilHitungSesResponse;
import com.yusril.forecasting.R;
import com.yusril.forecasting.RestClient;
import com.yusril.forecasting.adapter.MapedesAdapter;
import com.yusril.forecasting.adapter.MapesesAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentMapeDes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentMapeDes extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView tv_MAPEdes;

    private RecyclerView recyclerView;
    private MapedesAdapter adapter;
    private List<DataDesItem> listItem;
    private ArrayList<GetHasilDesResponse> movieList;
    public FragmentMapeDes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentMapeDes.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentMapeDes newInstance(String param1, String param2) {
        FragmentMapeDes fragment = new FragmentMapeDes();
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
        View view=inflater.inflate(R.layout.fragment_mape_des, container, false);
        tv_MAPEdes=view.findViewById(R.id.tv_MAPEdes);
        RestClient.getService().getMAPEDES().enqueue(new Callback<GetMapeDesResponse>() {
            @Override
            public void onResponse(Call<GetMapeDesResponse> call, Response<GetMapeDesResponse> response) {
                Log.d("API Result", String.valueOf(String.valueOf(response.body())));
                tv_MAPEdes.setText(String.valueOf(response.body().getDataMapeDes()));
            }

            @Override
            public void onFailure(Call<GetMapeDesResponse> call, Throwable t) {

            }
        });

        RestClient.getService().getHasilHitungDes().enqueue(new Callback<GetHasilDesResponse>() {
            @Override
            public void onResponse(Call<GetHasilDesResponse> call, Response<GetHasilDesResponse> response) {
                listItem = response.body().getDataDes();
                Log.d("API lisitem", String.valueOf(response.body().getDataDes()));
                adapter = new MapedesAdapter(listItem, getContext());
                recyclerView = view.findViewById(R.id.rv_mapedes);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<GetHasilDesResponse> call, Throwable t) {

            }
        });
                return view;
    }
}