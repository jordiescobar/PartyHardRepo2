package escobar.jordi.infobosccoma.partyhard.models.persistence.daos.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.provider.Telephony;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import escobar.jordi.infobosccoma.partyhard.models.business.entities.Party;
import escobar.jordi.infobosccoma.partyhard.models.persistence.daos.interfaces.PartyDAO;
import escobar.jordi.infobosccoma.partyhard.models.persistence.utilities.SQLiteUtils;

/**
 * Created by Pekee on 29/02/2016.
 */
public class PartySQLiteDAO implements PartyDAO {

    private Context context;

    public PartySQLiteDAO(Context context) {
        this.context = context;
    }

    @Override
    public Party getPartyById(long id) {

        Party person = null;

        SQLiteDatabase conn = SQLiteUtils.getConnection(context);
        Cursor result = conn.query(true, "Parties",
                new String[]{"codi", "titol", "ubicacio", "descripcio", "urlImage"},
                "codi = ?",
                new String[]{String.valueOf(id)},
                null, null, null, null);

        conn.close();
        return SQLiteUtils.getPerson(result);
    }

    @Override
    public List<Party> getAll() {
        List<Party> parties = new ArrayList<>();

        SQLiteDatabase conn = SQLiteUtils.getConnection(context);
        Cursor result = conn.query(true, "parties",
                new String[]{"codi", "titol", "ubicacio", "descripcio", "urlImage"},
                null,null, null, null, null, null);

        while(result.moveToNext()){
            parties.add(SQLiteUtils.getPerson(result));
        }

        conn.close();
        return parties;
    }

    @Override
    public boolean save(Party party) {
        SQLiteDatabase conn = SQLiteUtils.getConnection(context);
        ContentValues dades = new ContentValues();

        dades.put("titol", party.getTitol());
        dades.put("ubicacio", party.getUbicacio());
        dades.put("descripcio", party.getDescripcio());
        dades.put("urlImage", party.getUrlImage());

        try{

            long codi = conn.insertOrThrow("parties", null, dades);
            party.setCodi(codi);
            conn.close();
            return true;

        }catch (SQLiteException e){

            Log.i("Informacio:",e.getMessage() );
            conn.close();
            return false;
        }
    }

    @Override
    public boolean update(Party party) {
        ContentValues dades = new ContentValues();
        SQLiteDatabase conn = SQLiteUtils.getConnection(context);

        dades.put("titol", party.getTitol());
        dades.put("ubicacio", party.getUbicacio());
        dades.put("descripcio", party.getDescripcio());
        dades.put("urlImage", party.getUrlImage());

        return conn.update("parties", dades,
                    "codi = ?", new String[]{String.valueOf(party.getCodi())}) > 0;
    }

    @Override
    public boolean delete(Party party) {
        // obtenir l'objecte BD en mode esriptura
        SQLiteDatabase db = SQLiteUtils.getConnection(context);

        return db.delete("parties", "codi = ?", new String[]{String.valueOf(party.getCodi())}) > 0;
    }
}
