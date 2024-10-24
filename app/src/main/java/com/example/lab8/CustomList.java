package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    public int getCount(){
        return cities.size();
    }

    public ArrayList<City> getCities() {
        // not implemented yet
        return new ArrayList<>();
    }

    public void addCity(City city){
        cities.add(city);
    }

    /**
     * This checks whether a given city belongs to the list.
     * @param city
     *     This is the city to check
     * @return
     *     Return true if it belongs to the list, folse if not
     */
    public boolean hasCity(City city) {
        for(int i = 0; i < cities.size(); i++) {
            if(city.equals(cities.get(i))) return true;
        }
        return false;
    }

    /**
     * This deletes a city from the list if the city exists. If not, it throws an IllegalArgumentException.
     * @param city
     *     This is the city to delete
     */
    public void delete(City city) {
        if(hasCity(city)) {
            cities.remove(city);
        } else {
            throw new IllegalArgumentException("City to be deleted must exist in the list!");
        }
    }

    /**
     * This returns the number of cities in the list.
     * @return
     *     the number of cities in the list, type int
     */
    public int countCities() {
        return 0; // not implemented yet
    }
}
