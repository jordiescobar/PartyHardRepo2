package escobar.jordi.infobosccoma.partyhard.views.impl.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.parceler.Parcels;
import org.w3c.dom.Text;

import java.io.InputStream;
import java.net.URL;

import escobar.jordi.infobosccoma.partyhard.R;
import escobar.jordi.infobosccoma.partyhard.models.business.entities.Party;
import escobar.jordi.infobosccoma.partyhard.presenters.impl.DetailViewPresenterImpl;
import escobar.jordi.infobosccoma.partyhard.presenters.interfaces.IDetailViewPresenter;
import escobar.jordi.infobosccoma.partyhard.views.interfaces.IDetailView;

public class DetailActivity extends AppCompatActivity implements IDetailView {

    IDetailViewPresenter presenter;
    ImageView detallImatge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Proximament compartir amb Facebook i WhatsApp", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        detallImatge = (ImageView) findViewById(R.id.detail_imatge);
        presenter = new DetailViewPresenterImpl();
        presenter.onCreate(this, getBaseContext(), getPartyFromIntent(getIntent()));
        presenter.mostrarContingut();

    }

    public void mostrarImatge(String urlImatge){

        new TascaDescarrega().execute(urlImatge);

    }

    private Party getPartyFromIntent(Intent intent){
        return (Party) Parcels.unwrap(intent.getParcelableExtra("Party"));
    }

    private class TascaDescarrega extends AsyncTask<String, Void, Bitmap>{

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
            detallImatge.setImageBitmap(result);
        }
    }

    public void showContingut(Party party){

        TextView titol = (TextView) findViewById(R.id.detail_titol);

        TextView cosParty = (TextView) findViewById(R.id.detail_cosNoticia);

        titol.setText(party.getTitol());
        cosParty.setText(party.getDescripcio());
        mostrarImatge(party.getUrlImage());

    }
}
