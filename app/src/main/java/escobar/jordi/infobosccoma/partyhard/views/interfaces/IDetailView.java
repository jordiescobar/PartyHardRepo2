package escobar.jordi.infobosccoma.partyhard.views.interfaces;

import escobar.jordi.infobosccoma.partyhard.models.business.entities.Party;

/**
 * Created by Pekee on 22/02/2016.
 */
public interface IDetailView {

    void showContingut(Party party);
    void mostrarImatge(String urlImatge);

}
