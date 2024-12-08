import java.util.Scanner;

public class ApellidoNombreMain {
    public static void main(String[] args) {
        //Creacion de un objeto Perfil con datos
    ApellidoNombrePerfil myProfile = new ApellidoNombrePerfil(
        "Enric Terrones Barceiro",
        "Soy estudiante de DAW y trabajo en un call center",
            "Gimnasio, videojuegos, Futbol",
            "Sushi, pizza, Paella",
            "He recorrido casi todo Portugal, Puedo tener una cancion todo un dia en bucle, Como pan con la pasta"
            );
    Scanner scanner = new Scanner(System.in);
    int option;
    //Mostrar el menu de opciones en la consola
    do {
        System.out.println("\nMenu AboutMe [" +myProfile.getName() + "]");
        System.out.println("[1] Story");
        System.out.println("[2] Favorites");
        System.out.println("[3] Fun Fact");
        System.out.println("[4] Salir");

        if (scanner.hasNextInt()) {
            option = scanner.nextInt();
            scanner.nextLine();
            //Captura y devuelve la opcion seleccionada
            switch (option) {
                case 1:
                    System.out.println("\n"+myProfile.getStory());
                    break;
                case 2:
                    System.out.println("\n"+myProfile.getHobby());
                    System.out.println("\n"+myProfile.getFoods());
                    break;
                case 3:
                    System.out.println("\nFun fact: "+ myProfile.getFunFacts());
                    break;
                case 4:
                    System.out.println("Adios!!");
                    break;
                default:
                    System.out.println("Seleccione una opcion (1,2,3,4)");
            }
        }else {
            System.out.println("Entrada no válida.");
            scanner.nextLine();
            option = 0; //opcion invalida para que continue el bucle
        }
    } while (option != 4);
        scanner.close();
    }
}