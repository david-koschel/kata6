package kata6.model;

import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class NationalTeamsXml {
    public List<NationalTeam> nationalTeam;
    @XmlRootElement
    static class NationalTeam {
        @SerializedName("name")
        public String name;
        @SerializedName("confederation")
        public String confederation;
        @SerializedName("rank")
        public int fifaRanking;
    }
}
