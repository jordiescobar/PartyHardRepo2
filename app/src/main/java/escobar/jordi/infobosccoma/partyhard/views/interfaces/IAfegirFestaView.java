package escobar.jordi.infobosccoma.partyhard.views.interfaces;

import android.view.View;

import escobar.jordi.infobosccoma.partyhard.models.business.entities.Party;

/**
 * Created by Pekee on 05/03/2016.
 */
public interface IAfegirFestaView {

    void onClickAceptar(View view);

    void goToMainActivity(Party party);

    void DescarregaImatge(View v);

}
