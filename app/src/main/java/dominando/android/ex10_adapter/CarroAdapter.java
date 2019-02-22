package dominando.android.ex10_adapter;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class CarroAdapter extends BaseAdapter {

    Context ctx;
    List<Carro> carros;

    public CarroAdapter(Context ctx, List<Carro> carros) {
        this.ctx = ctx;
        this.carros = carros;
    }

    @Override
    public int getCount() {
        return carros.size();
    }

    @Override
    public Object getItem(int position) {
        return carros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1 passo
        Carro carro = carros.get(position);
        // 2 passo
        View linha = LayoutInflater.from(ctx).inflate(R.layout.item_carro, null);
        // 3 passo
        ImageView imgLogo = (ImageView) linha.findViewById(R.id.imgLogo);
        TextView txtModelo = (TextView) linha.findViewById(R.id.txtModelo);
        TextView txtAno = (TextView) linha.findViewById(R.id.txtAno);
        TextView txtCombustivel = (TextView) linha.findViewById(R.id.txtCombustivel);

        Resources res = ctx.getResources();
        TypedArray logos = res.obtainTypedArray(R.array.logos);
        imgLogo.setImageDrawable(logos.getDrawable(carro.fabricante));
        txtModelo.setText(carro.modelo);
        txtAno.setText(String.valueOf(carro.ano));
        txtCombustivel.setText(
                (carro.gasolina ? "G " : "") +
                (carro.etanol ? "E " : "")
        );
        return linha;
    }
}
