package com.example.ntpc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import org.w3c.dom.Entity;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlotGraphActivity extends AppCompatActivity {

    private LineChart lineChartAgSg;
    private LineChart lineChartDev;

    private ArrayList<Float> PastDevArray;
    private ArrayList<Float> PlotYSg;
    private ArrayList<Float> PlotYAg;
    private ArrayList<Float> PlotXBlockNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plot_graph);
        getArrayValues();

        lineChartAgSg = (LineChart) findViewById(R.id.graph);



        lineChartAgSg.getDescription().setEnabled(false);
        lineChartAgSg.setNoDataText("Loading...(Tap anywhere to continue)");

        lineChartAgSg.setDragEnabled(true);
        lineChartAgSg.setScaleEnabled(false);


//        ArrayList<Entry> values = new ArrayList<>();
//
//        values.add(new Entry(4,5));
//        values.add(new Entry(2,5));
//        values.add(new Entry(3,5));
//
//        //int len = PlotXBlockNumber.size();
//        //System.out.println(len);
//        //System.out.println(PlotYAg);
//        /*for( int i = 0; i<len; i++) {
//            float x = (float)PlotXBlockNumber.get(i).floatValue();
//            float y = (float)PlotYAg.get(i).floatValue();
//            values.add(new Entry(x,y));
//        }*/
//
//        LineDataSet set = new LineDataSet(values, "Data set");
//        set.setFillAlpha(110);
//        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
//        dataSets.add(set);
//        LineData data = new LineData(dataSets);
//        lineChart.setData(data);
    }

    public void getArrayValues() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(InputBaseUrlActivity.BaseURl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final PowerPlantData powerPlantData = retrofit.create(PowerPlantData.class);

        Call<PowerPlantDataPojo> call = powerPlantData.getPOJOs();
        call.enqueue(new Callback<PowerPlantDataPojo>() {
            @Override
            public void onResponse(Call<PowerPlantDataPojo> call, Response<PowerPlantDataPojo> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Code: " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                PowerPlantDataPojo powerPlantDataPojo = response.body();
                PastDevArray =  powerPlantDataPojo.getPastDevArray();
                PlotYSg = powerPlantDataPojo.getPlotYSg();
                PlotYAg = powerPlantDataPojo.getPlotYAg();
                PlotXBlockNumber = powerPlantDataPojo.getPlotXBlockNumber();
                System.out.println(PlotXBlockNumber);

                ArrayList<Entry> valuesSg = new ArrayList<>();
                ArrayList<Entry> valuesAg = new ArrayList<>();

                for (int i=0; i<PlotXBlockNumber.size(); i++) {
                    valuesSg.add(new Entry(PlotXBlockNumber.get(i), PlotYSg.get(i)));
                    valuesAg.add(new Entry(PlotXBlockNumber.get(i), PlotYAg.get(i)));

                }

                System.out.println(PlotYAg);

                //int len = PlotXBlockNumber.size();
                //System.out.println(len);
                //System.out.println(PlotYAg);
        /*for( int i = 0; i<len; i++) {
            float x = (float)PlotXBlockNumber.get(i).floatValue();
            float y = (float)PlotYAg.get(i).floatValue();
            values.add(new Entry(x,y));
        }*/
                LineDataSet setSg = new LineDataSet(valuesSg, "SG");
                LineDataSet setAg = new LineDataSet(valuesAg, "AG");

                setSg.setFillAlpha(110);
                setSg.setColors(new int[] {R.color.GraphSG});
                setSg.setLineWidth(2f);
                setSg.setValueTextSize(0);

                setAg.setFillAlpha(110);
                setAg.setLineWidth(2f);
//                setAg.setColors(new int[] { R.color.GraphAG});
                setAg.setValueTextSize(0);
           
                ArrayList<ILineDataSet> dataSetsAgSg = new ArrayList<>();
           
                dataSetsAgSg.add(setSg);
                dataSetsAgSg.add(setAg);

           
                LineData dataSg = new LineData(dataSetsAgSg);
           
                lineChartAgSg.setData(dataSg);
           

            }

            @Override
            public void onFailure(Call<PowerPlantDataPojo> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}