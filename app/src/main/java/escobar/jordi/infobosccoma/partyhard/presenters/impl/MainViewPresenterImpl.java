package escobar.jordi.infobosccoma.partyhard.presenters.impl;

import android.content.Context;

import java.util.List;

import escobar.jordi.infobosccoma.partyhard.helpers.PartyBuilder;
import escobar.jordi.infobosccoma.partyhard.models.business.entities.Party;
import escobar.jordi.infobosccoma.partyhard.models.persistence.daos.impl.PartySQLiteDAO;
import escobar.jordi.infobosccoma.partyhard.models.persistence.daos.interfaces.PartyDAO;
import escobar.jordi.infobosccoma.partyhard.presenters.interfaces.IMainViewPresenter;
import escobar.jordi.infobosccoma.partyhard.views.interfaces.IMainView;

/**
 * Created by Pekee on 15/02/2016.
 */
public class MainViewPresenterImpl implements IMainViewPresenter{

    private IMainView view;
    private List<Party> parties;
    private Context context;
    PartyDAO partiesdao;

    public void onCreate(IMainView view, Context context) {

        this.view = view;
        this.context = context;
        partiesdao = new PartySQLiteDAO(context);

    }

    @Override
    public void getPartyFormService() {

        //parties = PartyBuilder.getParties();
        showList();
    }

    @Override
    public void showList() {

        parties = partiesdao.getAll(); //getAll fa com una select.
        view.createList(view.createPartyAdapter(parties));
        view.showList();

    }

    @Override
    public void onItemClicked(int position) {

        view.goToDetailActivity(parties.get(position));

    }

    @Override
    public void onActionInsertar() {
        view.goToAfegirFesta();
    }

    public void addParty(Party party){

        partiesdao.save(party);

        showList();

    }

    @Override
    public void eliminarParty(int pos) {

        Party party = parties.get(pos);
        partiesdao.delete(party);

        showList();
    }

}
