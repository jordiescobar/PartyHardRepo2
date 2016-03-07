package escobar.jordi.infobosccoma.partyhard.models.persistence.utilities;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import escobar.jordi.infobosccoma.partyhard.models.business.entities.Party;

/**
 * Created by Pekee on 29/02/2016.
 */
public class SQLiteUtils {

    static final String NOM_DB = "Parties.db";
    static final int VERSIO_DB = 2;

    public static SQLiteDatabase getConnection(Context context){
        return new PartySQLiteHelper(context, NOM_DB, null, VERSIO_DB).getWritableDatabase();
    }


    public static Party getPerson(Cursor reader){
        Party party = new Party();

        party.setCodi(reader.getLong(reader.getColumnIndex("codi")));
        party.setTitol(reader.getString(reader.getColumnIndex("titol")));
        party.setDescripcio(reader.getString(reader.getColumnIndex("descripcio")));
        party.setUbicacio(reader.getString(reader.getColumnIndex("ubicacio")));
        party.setUrlImage(reader.getString(reader.getColumnIndex("urlImage")));

        return party;
    }
}
