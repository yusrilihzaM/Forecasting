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
import com.yusril.forecasting.GetHasilDesResponse;
import com.yusril.forecasting.R;
import com.yusril.forecasting.RestClient;
import com.yusril.forecasting.adapter.HasildesAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentHasilDes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentHasilDes extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView no,tahun,bulan,at,ysen,ysensen,a,b,ft;
    private RecyclerView recyclerView;
    private HasildesAdapter adapter;
    private List<DataDesItem> listItem;
    private ArrayList<GetHasilDesResponse> movieList;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentHasilDes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentHasilDes.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentHasilDes newInstance(String param1, String param2) {
        FragmentHasilDes fragment = new FragmentHasilDes();
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
        View view= inflater.inflate(R.layout.fragment_hasil_des, container, false);
        no=view.findViewById(R.id.tvNohdes);
        tahun=view.findViewById(R.id.tvTahundes);
        bulan=view.findViewById(R.id.tvBulanhdes);
        at=view.findViewById(R.id.athdes);
        ysen=view.findViewById(R.id.yseshdes);
        ysensen=view.findViewById(R.id.yseseshdes);
        a=view.findViewById(R.id.ahdes);
        b=view.findViewById(R.id.bhdes);
        ft=view.findViewById(R.id.fthdes);
        RestClient.getService().getHasilHitungDes().enqueue(new Callback<GetHasilDesResponse>() {
            @Override
            public void onResponse(Call<GetHasilDesResponse> call, Response<GetHasilDesResponse> response) {
                listItem = response.body().getDataDes();
                Log.d("API lisitem", String.valueOf(response.body().getDataDes()));
                adapter = new HasildesAdapter(listItem, getContext());
                recyclerView = view.findViewById(R.id.rv_hasil_des);
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