import java.util.List;

public class ApellidoNombrePerfil {
    private String name;
    private String story;
    private String hobby;
    private String foods;
    private String funFacts;

    public ApellidoNombrePerfil (String name, String story, String hobby, String foods, String funFacts){

        this.name = name;
        this.story = story;
        this.hobby = hobby;
        this.foods = foods;
        this.funFacts = funFacts;
    }
    public String getName() {
        return name;
    }
    public String getStory() {
        return "My story: \n" + story;
    }

    public String getFoods() {
        return "Favorite foods:\n" + foods;
    }

    public String getHobby() {
        return "My hobbys:\n" + hobby;
    }

    public  String getFunFacts() {
        return funFacts;
    }


}
