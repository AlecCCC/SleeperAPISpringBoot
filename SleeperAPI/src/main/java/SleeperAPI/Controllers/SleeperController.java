package SleeperAPI.Controllers;

import SleeperAPI.Classes.SleeperUser;
import SleeperAPI.Classes.SleeperLeague;
import SleeperAPI.Services.SleeperService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SleeperController {

    @Autowired
    private SleeperService sleeperService;

    @GetMapping("/lookup")
    public String showForm() {
        return "lookup";
    }

    @PostMapping("/lookup")
    public String lookupUser(
            @RequestParam("username") String username,
            @RequestParam("year") int year,
            Model model) {

        SleeperUser user = sleeperService.getUserByUsername(username);
        if (user == null) {
            model.addAttribute("error", "User not found");
            return "lookup";
        }

        List<SleeperLeague> leagues = sleeperService.getLeaguesByUserIdAndYear(user.getUserId(), year);

        model.addAttribute("user", user);
        model.addAttribute("leagues", leagues);
        model.addAttribute("year", year);

        return "lookup";
    }
}