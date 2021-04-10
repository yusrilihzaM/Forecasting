package com.yusril.forecasting.fragment.SES;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yusril.forecasting.DataSesItem;
import com.yusril.forecasting.GetMapeResponse;
import com.yusril.forecasting.HargaMinyak;
import com.yusril.forecasting.HasilHitungSesResponse;
import com.yusril.forecasting.R;
import com.yusril.forecasting.RestClient;
import com.yusril.forecasting.adapter.MapesesAdapter;
import com.yusril.forecasting.adapter.MinyakAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentMapeSes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentMapeSes extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView txtMAPEses;
    private RecyclerView recyclerView;
    private MapesesAdapter adapter;
    private List<DataSesItem> listItem;
    private ArrayList<HasilHitungSesResponse> movieList;
    public FragmentMapeSes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentMapeSes.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentMapeSes newInstance(String param1, String param2) {
        FragmentMapeSes fragment = new FragmentMapeSes();
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
        View view =inflater.inflate(R.layout.fragment_mape_ses, container, false);
        txtMAPEses=view.findViewById(R.id.tv_MAPEses);
        RestClient.getService().getMAPESES().enqueue(new Callback<GetMapeResponse>() {
            @Override
            public void onResponse(Call<GetMapeResponse> call, Response<GetMapeResponse> response) {
//                Toast.makeText(halaman_alpha.this, "Ambil Alpha Berhasil", Toast.LENGTH_SHORT).show();
//                listItem = response.body().getDataAlpha();
                Log.d("API Result", String.valueOf(response.body().getDataMapeSes()));
//                Log.d("API lisitem", String.valueOf(listItem.get(0)));
                txtMAPEses.setText(String.valueOf(response.body().getDataMapeSes()));
            }

            @Override
            public void onFailure(Call<GetMapeResponse> call, Throwable t) {

            }
        });
       RestClient.getService().getHasilHitungSes().enqueue(new Callback<HasilHitungSesResponse>() {
           @Override
           public void onResponse(Call<HasilHitungSesResponse> call, Response<HasilHitungSesResponse> response) {
               listItem = response.body().getDataSes();
               Log.d("API lisitem", String.valueOf(response.body().getDataSes()));
               adapter = new MapesesAdapter(listItem, getContext());
               recyclerView = view.findViewById(R.id.rv_mapese);
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