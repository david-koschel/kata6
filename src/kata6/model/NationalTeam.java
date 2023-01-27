package kata6.model;

import com.google.gson.JsonObject;

public class NationalTeam {

    private final String name;
    private final String confederation;
    private final int rank;

    public static NationalTeam of(JsonObject jsonObject) {
        String conf = jsonObject.get("tag").getAsJsonObject().get("text").getAsString();
        JsonObject info = jsonObject.get("rankingItem").getAsJsonObject();
        String name = info.get("name").getAsString();
        int rank = info.get("rank").getAsInt();
        return new NationalTeam(name, conf, rank);
    }

    private NationalTeam(String name, String confederation, int fifaRank) {
        this.name = name;
        this.confederation = confederation;
        this.rank = fifaRank;
    }

    @Override
    public String toString() {
        return "NationalTeam{" +
                "name='" + name + '\'' +
                ", confederation='" + confederation + '\'' +
                ", fifaRank=" + rank +
                '}';
    }
}
