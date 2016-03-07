package escobar.jordi.infobosccoma.partyhard.presenters.interfaces;

import android.view.View;

import escobar.jordi.infobosccoma.partyhard.models.business.entities.Party;
import escobar.jordi.infobosccoma.partyhard.views.interfaces.IAfegirFestaView;

/**
 * Created by Pekee on 01/03/2016.
 */
public interface IAfegirFestaViewPresenter {

    void onCreate(IAfegirFestaView view);
    void onClickedAceptar(Party party);
}
