package escobar.jordi.infobosccoma.partyhard.presenters.impl;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;

import escobar.jordi.infobosccoma.partyhard.models.business.entities.Party;
import escobar.jordi.infobosccoma.partyhard.presenters.interfaces.IAfegirFestaViewPresenter;
import escobar.jordi.infobosccoma.partyhard.views.interfaces.IAfegirFestaView;

/**
 * Created by Pekee on 01/03/2016.
 */
public class AfegirFestaPresenterImpl extends AppCompatActivity implements IAfegirFestaViewPresenter {

    private IAfegirFestaView view;

    public void onCreate(IAfegirFestaView view) {

        this.view = view;

    }

    public void onClickedAceptar(Party party){

        view.goToMainActivity(party);

    }

}
