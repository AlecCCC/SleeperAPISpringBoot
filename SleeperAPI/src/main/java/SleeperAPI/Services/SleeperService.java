package SleeperAPI.Services;

import SleeperAPI.Classes.SleeperLeague;
import SleeperAPI.Classes.SleeperUser;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class SleeperService {

    private final RestTemplate restTemplate = new RestTemplate();

    public SleeperUser getUserByUsername(String username) {
        String url = "https://api.sleeper.app/v1/user/" + username;
        return restTemplate.getForObject(url, SleeperUser.class);
    }

    public List<SleeperLeague> getLeaguesByUserIdAndYear(String userId, int year) {
        String url = "https://api.sleeper.app/v1/user/" + userId + "/leagues/nfl/" + year;
        SleeperLeague[] leagues = restTemplate.getForObject(url, SleeperLeague[].class);
        return Arrays.asList(leagues);
    }

    public SleeperLeague getLeagueById(String leagueId) {
        String url = "https://api.sleeper.app/v1/league/" + leagueId;
        return restTemplate.getForObject(url, SleeperLeague.class);
    }
}
