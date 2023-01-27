package kata6.model;

import java.util.ArrayList;
import java.util.List;

public class NationalTeams {

    List<NationalTeam> nationalTeam;

    public NationalTeams() {
        this.nationalTeam = new ArrayList<>();
    }

    public void addNationalTeam(NationalTeam nationalTeam) {
        this.nationalTeam.add(nationalTeam);
    }
}
