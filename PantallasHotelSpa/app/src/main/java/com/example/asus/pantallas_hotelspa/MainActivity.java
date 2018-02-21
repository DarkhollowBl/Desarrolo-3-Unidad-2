package com.example.asus.pantallas_hotelspa;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private Places[] places = {
            new Places(R.drawable.turi1, "Museo", "San Luis", "10 a.m - 9 p.m"),
            new Places(R.drawable.turi2, "Casa Dolores","Iberoamericana", "10 a.m - 6 p.m"),
            new Places(R.drawable.turi3, "Jardin","Centro", "Sin Horario"),
            new Places(R.drawable.turi4, "Plaza","Centro", "Sin Horario")
    };
    private ListView lsvPlaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lsvPlaces = findViewById(R.id.lsv_places);
        RestaurantAdapter adapter = new RestaurantAdapter(
                this,places);
        lsvPlaces.setAdapter(adapter);

        lsvPlaces.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String selectedOption = ((Places)adapterView.getItemAtPosition(i)).getName();
        // String selectedOption1 = ((TextView)view.findViewById(R.id.txv_name)).getText().toString();
        Toast.makeText(this, "You selected :" + selectedOption, Toast.LENGTH_SHORT).show();
    }

    public class ViewHolder{
        TextView txvName;
        TextView txvLocation;
        TextView txvType;
        ImageView imvPhoto;
    }

    class RestaurantAdapter extends ArrayAdapter<Places>{
        public RestaurantAdapter(@NonNull Context context, Places[] data){
            super(context, R.layout.cell_layout, data);
        }
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            View cell = convertView;
            ViewHolder holder;
            if (cell==null){
                LayoutInflater inflater =
                        LayoutInflater.from(getContext());
                cell = inflater.inflate(R.layout.cell_layout,null);
                holder = new ViewHolder();
                holder.imvPhoto = cell.findViewById(R.id.imv_photo);
                holder.txvName = cell.findViewById(R.id.txv_name);
                holder.txvLocation = cell.findViewById(R.id.txv_location);
                holder.txvType = cell.findViewById(R.id.txv_type);
                cell.setTag(holder);
            }else{
                holder = (ViewHolder) cell.getTag();
            }
            holder.imvPhoto.setImageResource(places[position].getImageId());
            holder.txvName.setText(places[position].getName());
            holder.txvLocation.setText(places[position].getLocation());
            holder.txvType.setText(places[position].getType());
            return cell;
        }
    }
}
