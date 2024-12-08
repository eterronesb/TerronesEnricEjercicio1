import java.util.List;

public class ApellidoNombrePerfil {
    //atributos privados
    private String name;
    private String story;
    private String hobby;
    private String foods;
    private String funFacts;
    //constructor de la clase Perfil

    public ApellidoNombrePerfil (String name, String story, String hobby, String foods, String funFacts){

        this.name = name;
        this.story = story;
        this.hobby = hobby;
        this.foods = foods;
        this.funFacts = funFacts;
    }
    public String getName() {
        return name;//devuelve el Nombre
    }
    public String getStory() {
        return "My story: \n" + story;//devuelve la historia
    }

    public String getFoods() {
        return "Favorite foods:\n" + foods;//devuelve la comida
    }

    public String getHobby() {
        return "My hobbys:\n" + hobby;//devuelve los hobbis
    }

    public  String getFunFacts() {
        return funFacts; //devuelve los fun facts
    }

}
