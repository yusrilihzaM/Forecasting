package com.yusril.forecasting.fragment.SES;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.yusril.forecasting.HasilHitungSesResponse;
import com.yusril.forecasting.R;
import com.yusril.forecasting.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentChart#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentChart extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentChart() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentChart.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentChart newInstance(String param1, String param2) {
        FragmentChart fragment = new FragmentChart();
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
        
        View view=inflater.inflate(R.layout.fragment_chart, container, false);
        LineChart mpLineChart = (LineChart) view.findViewById(R.id.chartses);
        mpLineChart.setMaxVisibleValueCount(-1);
        RestClient.getService().getHasilHitungSes().enqueue(new Callback<HasilHitungSesResponse>() {
            @Override
            public void onResponse(Call<HasilHitungSesResponse> call, Response<HasilHitungSesResponse> response) {
                List<Double> list=new ArrayList<Double>();
                list.add(0.0);
                for(int i=1;i<response.body().getDataSes().size();i++){
                    list.add(Double.parseDouble(response.body().getDataSes().get(i).getJumlahMinyak()));
                }
                ArrayList<Entry> dataVals =new ArrayList<>();
                ArrayList<Entry> dataVals2 =new ArrayList<>();
                for(int i=1;i<response.body().getDataSes().size();i++){

                    dataVals.add(new Entry(i,Float.parseFloat(response.body().getDataSes().get(i).getJumlahMinyak())));
                    dataVals2.add(new Entry(i,Float.parseFloat(String.valueOf(response.body().getDataSes().get(i).getYAksenSes()))));
                }

                LineDataSet lineDataSet1=new LineDataSet(dataVals,"Data Real");
                LineDataSet lineDataSet2=new LineDataSet(dataVals2,"Data Hasil Forecast");
                ArrayList <ILineDataSet>dataSets=new ArrayList<>();

                dataSets.add(lineDataSet1);
                dataSets.add(lineDataSet2);
                lineDataSet1.setColor(Color.GREEN);
                lineDataSet2.setColor(Color.BLUE);
                mpLineChart.fitScreen();
                LineData data=new LineData(dataSets);
                mpLineChart.setDrawGridBackground(true);
                mpLineChart.setData(data);

                mpLineChart.invalidate();
                Log.d("API hah", String.valueOf(response.body().getDataSes().get(1).getYAksenSes()));
            }

            @Override
            public void onFailure(Call<HasilHitungSesResponse> call, Throwable t) {

            }
        });
        return  view;
    }
}