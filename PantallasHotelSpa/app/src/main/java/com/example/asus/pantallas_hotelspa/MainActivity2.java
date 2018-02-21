package com.example.asus.pantallas_hotelspa;

import android.content.Context;
import android.content.Intent;
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

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private Services[] services = {
            new Services(R.drawable.spa1, "Paquete 1","Info" ,"Masaje Rico", "10 a.m - 9 p.m"),
            new Services(R.drawable.spa2, "Paquete 2","Info","Masaje Rico", "10 a.m - 6 p.m"),
            new Services(R.drawable.spa3, "Paquete 3","info","Masaje Rico", "Sin Horario"),
            new Services(R.drawable.spa4, "Paquete 4","Info","Masaje Rico", "Sin Horario")
    };
    private ListView lsvServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_package);
        lsvServices = findViewById(R.id.lsv_services);
        ServiciosAdapter adapter = new ServiciosAdapter(
                this,services);
        lsvServices.setAdapter(adapter);
        lsvServices.setOnItemClickListener(this);
    }
    public void nextActivity(View view){
        startActivity(new Intent(
                this, FinalActivity.class));
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String selectedOption = ((Services)adapterView.getItemAtPosition(i)).getName();
        // String selectedOption1 = ((TextView)view.findViewById(R.id.txv_name)).getText().toString();
        Toast.makeText(this, "You selected :" + selectedOption, Toast.LENGTH_SHORT).show();
    }

    public class ViewHolder{
        TextView txvName;
        TextView txvInfo;
        TextView txvLocation;
        TextView txvType;
        ImageView imvPhoto;
    }

    class ServiciosAdapter extends ArrayAdapter<Services>{
        public ServiciosAdapter(@NonNull Context context, Services[] data){
            super(context, R.layout.cell_package_layout, data);
        }
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            View cell = convertView;
            ViewHolder holder;
            if (cell==null){
                LayoutInflater inflater =
                        LayoutInflater.from(getContext());
                cell = inflater.inflate(R.layout.cell_package_layout,null);
                holder = new ViewHolder();
                holder.imvPhoto = cell.findViewById(R.id.imv_photo);
                holder.txvName = cell.findViewById(R.id.txv_name);
                holder.txvInfo = cell.findViewById(R.id.txv_info);
                holder.txvLocation = cell.findViewById(R.id.txv_description_service);
                holder.txvType = cell.findViewById(R.id.txv_cost);
                cell.setTag(holder);
            }else{
                holder = (ViewHolder) cell.getTag();
            }
            holder.imvPhoto.setImageResource(services[position].getImageId());
            holder.txvName.setText(services[position].getName());
            holder.txvInfo.setText(services[position].getInfo());
            holder.txvLocation.setText(services[position].getLocation());
            holder.txvType.setText(services[position].getType());
            return cell;
        }
    }
}
