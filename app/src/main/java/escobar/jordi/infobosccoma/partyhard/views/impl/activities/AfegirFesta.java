package escobar.jordi.infobosccoma.partyhard.views.impl.activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.parceler.Parcels;

import java.io.InputStream;
import java.net.URL;

import escobar.jordi.infobosccoma.partyhard.R;
import escobar.jordi.infobosccoma.partyhard.models.business.entities.Party;
import escobar.jordi.infobosccoma.partyhard.presenters.impl.AfegirFestaPresenterImpl;
import escobar.jordi.infobosccoma.partyhard.presenters.interfaces.IAfegirFestaViewPresenter;
import escobar.jordi.infobosccoma.partyhard.views.interfaces.IAfegirFestaView;

public class AfegirFesta extends AppCompatActivity implements IAfegirFestaView {

    IAfegirFestaViewPresenter presenter;

    private EditText titol;
    private EditText ubicacio;
    private EditText descripcio;
    private EditText urlImatge;
    private Button acceptar;
    private Button previsualitzadorUrlImage;
    private ImageView imatge;
    private  Party party;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afegir_festa);

        titol = (EditText)findViewById(R.id.text_insert_titol);
        ubicacio = (EditText) findViewById(R.id.text_insert_ubicacio);
        descripcio = (EditText) findViewById(R.id.text_insert_descripcio);
        urlImatge = (EditText) findViewById(R.id.text_insert_url);

        presenter = new AfegirFestaPresenterImpl();
        presenter.onCreate(this);

        imatge = (ImageView) findViewById(R.id.imageView_afegir_imatge);
        acceptar = (Button) findViewById(R.id.btn_insert_acceptar);
        previsualitzadorUrlImage = (Button) findViewById(R.id.btn_insert_previsualitzaIMG);


       boolean modeTreball =  getIntent().getBooleanExtra("add", true);
        if(modeTreball) {
            party = new Party();
            party.setTitol(titol.getText().toString());
            party.setUbicacio(ubicacio.getText().toString());
            party.setDescripcio(descripcio.getText().toString());
            party.setUrlImage(urlImatge.getText().toString());
        }
        else {
            party=(Party)Parcels.unwrap(getIntent().getParcelableExtra("festa"));
           // mostrarParty(party);
        }

        //setResult(RESULT_OK   ,i);
    }

    public void onClickAceptar(View view){

        //boolean modeTreball =  getIntent().getBooleanExtra("add", true);

        //if(modeTreball) {

            party = new Party();

            party.setTitol(titol.getText().toString());
            party.setUbicacio(ubicacio.getText().toString());
            party.setDescripcio(descripcio.getText().toString());
            party.setUrlImage(urlImatge.getText().toString());

            presenter.onClickedAceptar(party);

        //} else {

          //  party=(Party)Parcels.unwrap(getIntent().getParcelableExtra("party"));
            // mostrarParty(party);

      //  }

        //setResult(RESULT_OK   ,i);

    }

    public void goToMainActivity(Party party){

        Intent intent = new Intent();
        intent.putExtra("PARTY", Parcels.wrap(party));
        setResult(RESULT_OK,intent);
        finish();

    }

    public void DescarregaImatge(View v){
        if(!TextUtils.isEmpty((urlImatge.getText().toString()))) {
            new TascaDescarrega().execute((urlImatge.getText().toString()));
        }
    }

    private class TascaDescarrega extends AsyncTask<String, Void, Bitmap> {

        private Bitmap loadImageFromNetwork(String imageURL){
            try{
                Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(imageURL).getContent());
                return bitmap;
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        protected Bitmap doInBackground(String... urls){
            return loadImageFromNetwork(urls[0]);
        }

        protected void onPostExecute(Bitmap result){
            imatge.setImageBitmap(result);
        }
    }

}
