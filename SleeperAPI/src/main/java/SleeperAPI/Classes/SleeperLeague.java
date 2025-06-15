package SleeperAPI.Classes;


import com.fasterxml.jackson.annotation.JsonProperty;


public class SleeperLeague {

    @JsonProperty("avatar")
    private String avatar;

    @JsonProperty("name")
    private String name;

    @JsonProperty("league_id")
    private String league_id;

    @JsonProperty("season")
    private String season;


    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeague_id() {
        return league_id;
    }

    public void setLeague_id(String league_id) {
        this.league_id = league_id;
    }


}
