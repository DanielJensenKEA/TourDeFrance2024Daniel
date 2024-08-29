import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        try {
            Statistics s = new Statistics("tdffinishers2024");

            System.out.println(s.getTeams());

            Iterator<String> teams = s.getTeams().iterator();
            int count = 1;

            while(teams.hasNext()) {
                System.out.print(count+" ");
                System.out.println(teams.next());
                count++;
            }
            System.out.println("There are a total of "+(count-1)+" teams present.");

            System.out.println(s.getTeamsWithMembers());


            //Iterator segment.
            Iterator<String> riderIterator = s.getTeamsWithMembers().keySet().iterator();
            Iterator<String> teamIterator = s.getTeamsWithMembers().values().iterator();

            int countMembers = 1;

            while(riderIterator.hasNext()) {
                System.out.print(countMembers+" ");
                countMembers++;
                System.out.println(riderIterator.next()+" : "+teamIterator.next());


            }
            System.out.println("There are a total of "+(countMembers-1)+" across "+(count)+" teams.");

            String teamToFind = "BAHRAIN VICTORIOUS";
            System.out.println("\nSearching for members of TEAM: "+teamToFind.toUpperCase());
            System.out.println(s.getTeamMembers(teamToFind));

        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
