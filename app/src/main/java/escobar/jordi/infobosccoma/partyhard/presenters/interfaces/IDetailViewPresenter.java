package escobar.jordi.infobosccoma.partyhard.presenters.interfaces;

import android.content.Context;

import escobar.jordi.infobosccoma.partyhard.models.business.entities.Party;
import escobar.jordi.infobosccoma.partyhard.views.interfaces.IDetailView;

/**
 * Created by Pekee on 15/02/2016.
 */
public interface IDetailViewPresenter {

    void onCreate(IDetailView view, Context context, Party party);

    void mostrarContingut();

}
