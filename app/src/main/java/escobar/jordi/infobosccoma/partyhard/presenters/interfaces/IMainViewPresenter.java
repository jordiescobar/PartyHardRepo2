package escobar.jordi.infobosccoma.partyhard.presenters.interfaces;

import android.content.Context;

import escobar.jordi.infobosccoma.partyhard.models.business.entities.Party;
import escobar.jordi.infobosccoma.partyhard.views.interfaces.IMainView;

/**
 * Created by Pekee on 15/02/2016.
 */
public interface IMainViewPresenter {

    void onCreate(IMainView view, Context context);

    void getPartyFormService();

    void showList();

    void onItemClicked(int position);

    void onActionInsertar();

    void addParty(Party party);

    void eliminarParty(int pos);
}
