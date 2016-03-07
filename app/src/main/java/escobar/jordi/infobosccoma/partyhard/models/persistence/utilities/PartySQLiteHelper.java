package escobar.jordi.infobosccoma.partyhard.models.persistence.utilities;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Pekee on 29/02/2016.
 */

public class PartySQLiteHelper extends SQLiteOpenHelper {

    // Sentència SQL per crear la taula de Parties
    private final String SQL_CREATE_PARTIES = "CREATE TABLE parties(" +
            "	codi INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "   titol TEXT, " +
            "	ubicacio TEXT, " +
            "	descripcio TEXT, " +
            "	urlImage TEXT)";

    public PartySQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PARTIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS parties");
        db.execSQL(SQL_CREATE_PARTIES);
        db.execSQL("INSERT INTO parties (titol, ubicacio, descripcio, urlImage) " +
                "VALUES ('Tomorrowland','Belgica', 'Prova de descripcio','https://i.ytimg.com/vi/SjNG_vpdFBA/hqdefault.jpg');");
    }
}
