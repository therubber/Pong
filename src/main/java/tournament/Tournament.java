package tournament;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Tournament {

    private Ranking ranking;
    private List<Team> participants;

    public Tournament(File participantsCsv) {
        ranking = new Ranking();
        participants = loadParticipants(participantsCsv);
    }

    private List<Team> loadParticipants(File participantsCsv) {
        return new ArrayList<>();
    }
}
