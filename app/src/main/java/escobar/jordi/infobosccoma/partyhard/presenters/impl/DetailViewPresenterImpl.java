package escobar.jordi.infobosccoma.partyhard.presenters.impl;

import android.content.Context;

import escobar.jordi.infobosccoma.partyhard.models.business.entities.Party;
import escobar.jordi.infobosccoma.partyhard.presenters.interfaces.IDetailViewPresenter;
import escobar.jordi.infobosccoma.partyhard.views.interfaces.IDetailView;

/**
 * Created by Pekee on 22/02/2016.
 */
public class DetailViewPresenterImpl implements IDetailViewPresenter {

    private Party party;
    private IDetailView view;
    private Context context;

    @Override
    public void onCreate(IDetailView view, Context context, Party party) {

        this.party = party;
        this.view = view;
        this.context = context;
        this.view.mostrarImatge(party.getUrlImage());

    }

    @Override
    public void mostrarContingut() {
        view.showContingut(party);
    }


}
