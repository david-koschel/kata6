package kata6;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import kata6.model.NationalTeam;
import kata6.model.NationalTeams;
import kata6.model.NationalTeamsXml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import static java.util.stream.Collectors.joining;

public class Kata6 {

    public static void main(String[] args) throws IOException, JAXBException {

        String url = "https://www.fifa.com/api/ranking-overview?locale=es&dateId=id13869";
        Gson gson = new Gson();
        JsonArray jsonArray = gson.fromJson(read(url), JsonObject.class)
                .get("rankings").getAsJsonArray();

        NationalTeams realNationalTeams = new NationalTeams();
        for (int i = 0; i < 5; i++) {
            realNationalTeams.addNationalTeam(NationalTeam.of(jsonArray.get(i).getAsJsonObject()));
        }

        nationalTeamsJsonToXml(gson.toJson(realNationalTeams));
    }

    private static void nationalTeamsJsonToXml(String json) throws JAXBException {
        Gson gson = new Gson();
        NationalTeamsXml nationalTeams = gson.fromJson(json, NationalTeamsXml.class);

        JAXBContext context = JAXBContext.newInstance(NationalTeamsXml.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(nationalTeams, System.out);

    }

    private static String read(String url) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
            return reader.lines().collect(joining());
        }
    }
}
