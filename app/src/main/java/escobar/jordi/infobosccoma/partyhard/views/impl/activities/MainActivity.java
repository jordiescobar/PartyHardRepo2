package escobar.jordi.infobosccoma.partyhard.views.impl.activities;

import android.app.MediaRouteButton;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import escobar.jordi.infobosccoma.partyhard.R;
import escobar.jordi.infobosccoma.partyhard.models.business.entities.Party;
import escobar.jordi.infobosccoma.partyhard.presenters.impl.MainViewPresenterImpl;
import escobar.jordi.infobosccoma.partyhard.presenters.interfaces.IMainViewPresenter;
import escobar.jordi.infobosccoma.partyhard.views.impl.adapters.PartyListAdapter;
import escobar.jordi.infobosccoma.partyhard.views.interfaces.IMainView;

public class MainActivity extends AppCompatActivity implements IMainView, AdapterView.OnItemClickListener{

    final int INTENT_REQUEST = 1;

    private ListView list;
    private MediaRouteButton btnRetry;
    private ProgressBar progressBar;
    private IMainViewPresenter presenter;
    private PartyListAdapter adapterList;
    private ArrayList<Party> llistaParties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list = (ListView) findViewById(R.id.main_listView);

        presenter = new MainViewPresenterImpl();
        presenter.onCreate(this, getBaseContext());
        presenter.getPartyFormService();


        registerForContextMenu(list);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_Insertar:
                presenter.onActionInsertar();
                break;
        }

        return true;

        //return super.onOptionsItemSelected(item);
    }

    @Override
    public void createList(PartyListAdapter adapter) {
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public PartyListAdapter createPartyAdapter(List<Party> Parties) {
        return new PartyListAdapter(this, Parties);
    }

    @Override
    public void goToDetailActivity(Party party) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("Party", Parcels.wrap(party));
        startActivity(intent);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showRetryButton() {btnRetry.setVisibility(View.VISIBLE); }

    @Override
    public void hideRetryButton() {
        btnRetry.setVisibility(View.GONE);
    }

    @Override
    public void showList() {
        list.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideList() {
        list.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goToAfegirFesta() {
        Intent intent = new Intent(this, AfegirFesta.class);
        intent.putExtra("add", true);
        startActivityForResult(intent, INTENT_REQUEST);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                Party party = (Party)Parcels.unwrap(data.getParcelableExtra("PARTY"));
                presenter.addParty(party);
            }
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.main_menu_contextual, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int pos = (int) info.id;

        switch (item.getItemId()) {
            case R.id.action_main_context_delete:

                presenter.eliminarParty(pos);
                break;

        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        presenter.onItemClicked(position);
    }
}
