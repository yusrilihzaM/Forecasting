package com.yusril.forecasting.fragment.DES;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.yusril.forecasting.DataDesItem;
import com.yusril.forecasting.GetHasilDesResponse;
import com.yusril.forecasting.R;
import com.yusril.forecasting.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentChartDes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentChartDes extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArrayList dataini = new ArrayList();
    LineChart mpLineChart;
    public FragmentChartDes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentChartDes.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentChartDes newInstance(String param1, String param2) {
        FragmentChartDes fragment = new FragmentChartDes();
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
//    private ArrayList<Entry>datavals=new ArrayList<>(){
//                datavals.add(new Entry(0,20));
//                datavals.add(new Entry(1,24));
//                datavals.add(new Entry(2,2));
//                datavals.add(new Entry(3,10));
//    };
private ArrayList<Entry> dataValues1(DataDesItem dataDesItem){
    ArrayList<Entry> dataVals =new ArrayList<>();
    dataVals.add(new Entry((Float.parseFloat(dataDesItem.getHasilForecastDes().toString())), 0));
//    dataVals.add(new Entry(0,20));
//    dataVals.add(new Entry(2,24));
//    dataVals.add(new Entry(2,22));
//    dataVals.add(new Entry(3,10));
//    dataVals.add(new Entry(4,26));
    return  dataVals;
}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =inflater.inflate(R.layout.fragment_chart_des, container, false);
        LineChart mpLineChart = (LineChart) view.findViewById(R.id.linechart);
        mpLineChart.setMaxVisibleValueCount(-1);
        RestClient.getService().getHasilHitungDes().enqueue(new Callback<GetHasilDesResponse>() {
            @Override
            public void onResponse(Call<GetHasilDesResponse> call, Response<GetHasilDesResponse> response) {
//                Log.d("API haha", String.valueOf(response.body().getDataDes().get(1).getJumlahMinyak()));
                List <Double>list=new ArrayList<Double>();
                list.add(0.0);
                for(int i=1;i<response.body().getDataDes().size();i++){
                    list.add(Double.parseDouble(response.body().getDataDes().get(i).getJumlahMinyak()));
                }
                ArrayList<Entry> dataVals =new ArrayList<>();
                ArrayList<Entry> dataVals2 =new ArrayList<>();
                for(int i=1;i<response.body().getDataDes().size();i++){

                    dataVals.add(new Entry(i,Float.parseFloat(response.body().getDataDes().get(i).getJumlahMinyak())));
                    dataVals2.add(new Entry(i,Float.parseFloat(String.valueOf(response.body().getDataDes().get(i).getHasilForecastDes()))));
                }

                LineDataSet lineDataSet1=new LineDataSet(dataVals,"Data Real");
                LineDataSet lineDataSet2=new LineDataSet(dataVals2,"Data Hasil Forecast");
                ArrayList <ILineDataSet>dataSets=new ArrayList<>();
                lineDataSet1.setColor(Color.GREEN);
                lineDataSet2.setColor(Color.BLUE);
                dataSets.add(lineDataSet1);
                dataSets.add(lineDataSet2);
                LineData data=new LineData(dataSets);
                mpLineChart.fitScreen();
                mpLineChart.setData(data);

                mpLineChart.invalidate();
                Log.d("API hah", String.valueOf(response.body().getDataDes().get(1).getHasilForecastDes()));

            }

            @Override
            public void onFailure(Call<GetHasilDesResponse> call, Throwable t) {

            }
        });
        return view;
    }
}