package escobar.jordi.infobosccoma.partyhard.views.impl.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import escobar.jordi.infobosccoma.partyhard.R;
import escobar.jordi.infobosccoma.partyhard.models.business.entities.Party;

class Vista{
    public TextView titol;
    public TextView ubicacio;
    public TextView descripcio;
}

/**
 * Created by Pekee on 15/02/2016.
 */
public class PartyListAdapter extends ArrayAdapter<Party> {

    private Context context;
    private List<Party> dades;

    private LayoutInflater inflater;

    public PartyListAdapter(Context context, List<Party> comments) {
        super(context, 0, comments);

        this.context = context;
        this.inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.dades = comments;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View item = convertView;

        Vista vista;

        //Obtimització
        if(item == null){

            item = inflater.inflate(R.layout.item_list, null);

            vista = new Vista();
            vista.titol = (TextView)item.findViewById(R.id.cardview_textview_titol);
            vista.ubicacio = (TextView)item.findViewById(R.id.cardview_textview_ubicacio);
            vista.descripcio = (TextView)item.findViewById(R.id.cardview_textview_descripcio);
            item.setTag(vista);

        } else {
            //La vista ja s'havia generat anteriormet.
            vista = (Vista)item.getTag();
        }

        vista.titol.setText(dades.get(position).getTitol());
        vista.ubicacio.setText(dades.get(position).getUbicacio());
        vista.descripcio.setText(dades.get(position).getDescripcio());

        return item;
    }

}
