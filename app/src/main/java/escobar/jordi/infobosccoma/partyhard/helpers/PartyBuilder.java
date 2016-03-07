package escobar.jordi.infobosccoma.partyhard.helpers;

import android.provider.Telephony;

import java.util.ArrayList;
import java.util.List;

import escobar.jordi.infobosccoma.partyhard.models.business.entities.Party;

/**
 * Created by Pekee on 16/02/2016.
 */
public class PartyBuilder {


    public static List<Party> getParties() {

        List<Party> persons = new ArrayList<>();

        persons.add(new Party("Dominator","The Hardcore Festival","Dominator se celebra en la playa de E3 en Eersel.","Dominator es un festival anual de Hardstyle organizado por Danza-Q. Es conocido como uno de los mayores festivales de Hardstyle del mundo. La gente se congrega en los Países Bajos, lugar donde se celebra el evento, para disfrutar de la mejor música Hardstyle.\n" +
                "\n" +
                "La primera edición del Dominator Festival se celebró el 30 de julio de 2006 en El Rutbeek en Enschede. En 2006 Dominator no fue organizado, aunque en 2007 regresó, esta vez en el Parque de la Ciudad de Groninga. La tercera edición fue el 26 de julio de 2008 en un área de recreación de Vlietland en Leidschendam. Desde 2009, Dominator se celebra en la playa de E3 en Eersel."));

        persons.add(new Party("Tomorrowland","Festival de música electrónica","se celebra al aire libre en el pueblo belga de Boom", "Tomorrowland es un festival de música electrónica que se celebra al aire libre en el pueblo belga de Boom desde el año 2005. Está organizado por ID&T, la principal empresa en temas de entretenimientos y medios de comunicación.\n" +
                "\n" +
                "Al igual que su equivalente holandés, el Mysteryland (en vigor desde 1993 en los Países Bajos), es un festival mundialmente conocido, es simplemente un éxito. El festival está basado en la magia y los diferentes escenarios están ambientados en torno a un cuento de hadas. Actualmente, Tomorrowland cuenta con un total de 10 áreas diferentes, en las que se reparten los diversos Deejays que se congregan allí todos los veranos, contando el último año con celebridades como Afrojack, Above & Beyond, Basto, Carl Cox, De Jeugd van Tegenwoordig, Fedde Le Grand, Ferry Corsten, Sander van Doorn, Swedish House Mafia, Avicii, Faithless, Dj Tiësto, Laidback Luke, David Guetta, Steve Aoki, Kaskade o 2 Many Djs."));

        persons.add((new Party("ViñaRock","Festival de Arte Nativo","-","Segundo año que Viña Rock 2015 ofrecerá en streaming algunos de los conciertos más importantes del Escenario Negrita y Zhem para todos aquellos que no puedan asistir al evento, podrás disfrutar de varios conciertos en directo sin moverte de casa!")));

        for(int i = 4; i < 20; i++){
            persons.add(new Party(String.format("Prova Titul Festa %d", i),
                    String.format("Subtitul Festa %d", i),
                    String.format("Ubicaco de la festa %d", i),
                    String.format("Descripció de la festa %d Descripcio descripció descripció descripció descripció descripció descripció descripció", i)));
        }
        return persons;
    }

}
