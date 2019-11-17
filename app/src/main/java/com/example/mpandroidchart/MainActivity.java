package com.example.mpandroidchart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.AxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPieChart();
    }
    private void initPieChart() {

        PieChart chart = (PieChart) findViewById(R.id.pie_chart);

        ArrayList<Student> listStudent = Student.getSampleStudentData(4);
        ArrayList<PieEntry> entries = new ArrayList<>();


        for (Student student : listStudent) {
            entries.add(new PieEntry(student.getScore(), student.getName()));
        }

        PieDataSet dataset = new PieDataSet(entries, "student");
        dataset.setSelectionShift(10);
        dataset.setValueTextSize(14);
        dataset.setColors(ColorTemplate.PASTEL_COLORS); // set the color
        // dataset.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataset.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataset.setValueLinePart1Length(0.5f);
        dataset.setValueLinePart2Length(0.5f);
        dataset.setValueFormatter(new PercentFormatter());

        PieData data = new PieData(dataset); // initialize Piedata
//      data.setValueFormatter(new PercentFormatter());
        chart.setNoDataText("No data available.");
        chart.setData(data);
        chart.setHoleRadius(30);
        chart.setTransparentCircleRadius(40);
        chart.setDescription("");  // set the description
        chart.animateY(3000);
//        chart.setUsePercentValues(true);
        chart.setEntryLabelTextSize(14);
        chart.setEntryLabelColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimaryDark));

        chart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                // when select.
            }

            @Override
            public void onNothingSelected() {

            }
        });

    }
}

