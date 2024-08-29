import java.io.FileNotFoundException;
import java.util.*;

public class Statistics {
    private List<Cyclist> cyclists;
    private Set<String> setOfTeams;
    private Map<String, String> mapOfTeams;

    public Statistics(String fileName) throws FileNotFoundException {
        TDFFileReader TDFR = new TDFFileReader(fileName);
        cyclists = new ArrayList<>();
        var loadedList = TDFR.readFile();
        cyclists.addAll(loadedList);

    }

    public Set<String> getTeams() {
        setOfTeams = new HashSet<>();
        for (Cyclist c : cyclists) {
            setOfTeams.add(c.getTeam());
        }

        return setOfTeams;
    }

    public Map<String, String> getTeamsWithMembers() {
        mapOfTeams = new HashMap<>();
        for (Cyclist c : cyclists) {
            mapOfTeams.put(c.getName(), c.getTeam());
        }
        return mapOfTeams;
    }

    public String getTeamMembers(String team) {
        String result = "";

        for (Map.Entry<String, String> entry : mapOfTeams.entrySet()) {
            //.entrySet giver adgang til både GetKey() og GetValue()
            //Det fjerner derfor behovet for nestede for each loops.
            if (entry.getValue().equalsIgnoreCase(team)) {
                result += entry.getKey()+"\n";
            }
        }
        return result;

    }

}
