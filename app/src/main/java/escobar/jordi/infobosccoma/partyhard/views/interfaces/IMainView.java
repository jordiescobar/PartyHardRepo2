package escobar.jordi.infobosccoma.partyhard.views.interfaces;

import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import escobar.jordi.infobosccoma.partyhard.models.business.entities.Party;
import escobar.jordi.infobosccoma.partyhard.views.impl.adapters.PartyListAdapter;

/**
 * Created by Pekee on 15/02/2016.
 */
public interface IMainView {

    void createList(PartyListAdapter adapter);

    PartyListAdapter createPartyAdapter(List<Party> Parties);

    void goToDetailActivity(Party party);

    void showProgressBar();

    void hideProgressBar();

    void showRetryButton();

    void hideRetryButton();

    void showList();

    void hideList();

    void showMessage(String message);

    void goToAfegirFesta();
}
