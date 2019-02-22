package dominando.android.ex10_adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Carro> carros;
    CarroAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listView = new ListView(this);
        setContentView(R.layout.activity_main);

        carros = new ArrayList<Carro>();
        carros.add(new Carro("Celta", 2010, 1, true, false));
        carros.add(new Carro("Uno", 2020, 2, true, true));
        carros.add(new Carro("Gol", 2018, 3, true, true));
        carros.add(new Carro("Fiesta", 2008, 4, false, true));
        adapter = new CarroAdapter(this, carros);
        listView.setAdapter(adapter);

    }
}
