package escobar.jordi.infobosccoma.partyhard.models.persistence.daos.interfaces;

import java.util.List;

import escobar.jordi.infobosccoma.partyhard.models.business.entities.Party;

/**
 * Created by Pekee on 29/02/2016.
 */
public interface PartyDAO {

    Party getPartyById(long id);
    List<Party> getAll();
    boolean save(Party party);
    boolean update(Party party);
    boolean delete(Party party);

}
