package com.yusril.forecasting.fragment.SES;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yusril.forecasting.DataSesItem;
import com.yusril.forecasting.HasilHitungSesResponse;
import com.yusril.forecasting.R;
import com.yusril.forecasting.RestClient;
import com.yusril.forecasting.adapter.HasilAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentHasilSes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentHasilSes extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private HasilAdapter adapter;
    private List<DataSesItem> listItem;
    private ArrayList<HasilHitungSesResponse> movieList;
    private View view;
    public FragmentHasilSes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentHasilSes.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentHasilSes newInstance(String param1, String param2) {
        FragmentHasilSes fragment = new FragmentHasilSes();
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
        view =inflater.inflate(R.layout.fragment_hasil_ses, container, false);
        RestClient.getService().getHasilHitungSes().enqueue(new Callback<HasilHitungSesResponse>() {
            @Override
            public void onResponse(Call<HasilHitungSesResponse> call, Response<HasilHitungSesResponse> response) {
                listItem = response.body().getDataSes();
                Log.d("API lisitem", String.valueOf(response.body().getDataSes()));
                adapter = new HasilAdapter(listItem, getContext());
                recyclerView = view.findViewById(R.id.rv_hasil_ses);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<HasilHitungSesResponse> call, Throwable t) {

            }
        });

        return view;
    }

}