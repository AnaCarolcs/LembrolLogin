package com.lembrol.ana.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.lembrol.ana.Config.FirebaseConfig;
import com.lembrol.ana.Config.Preference;
import com.lembrol.ana.Model.Reminder;
import com.lembrol.ana.R;

import java.util.ArrayList;

public class ListTitleFragment extends Fragment {

    private ListView listView;
    private ArrayAdapter adapter;
    private ArrayList<String> titles;
    private DatabaseReference firebase;

    public ListTitleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Instância objetos
        titles = new ArrayList<>();
        //titles.add("Escola");
        //titles.add("Trabalho");
        //titles.add("Casa");

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_title, container, false);

        //Monta listview e adapter
        listView = (ListView) view.findViewById(R.id.lv_title_list_id);
        adapter = new ArrayAdapter(getActivity(),R.layout.title_list, titles);
        listView.setAdapter(adapter);








        //recuperar contatos do firebase
        Preference preference = new Preference(getActivity());
        String identifierUser = preference.getIdentifier();
        firebase = FirebaseConfig.getFirebase()
                .child("Titles")
                .child(identifierUser);

        //Listener para recuperar titles
        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //Limpar lista
                titles.clear();

                //Listar Titles
                for(DataSnapshot datas: dataSnapshot.getChildren()){

                    Reminder reminder = datas.getValue(Reminder.class);
                    titles.add( reminder.getTitleReminder() );

                }

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });









        return view;
    }

}