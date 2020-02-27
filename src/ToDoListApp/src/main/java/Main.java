import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Request request = new Request();
        System.out.println("----------------------------------------------MY TODOLIST----------------------------------------------");
        boolean isEnd = false;
        System.out.println("Bienvenue sur votre Liste de Tache");
        while(!isEnd)
        {
            System.out.println("Voulez vous afficher vos taches ? (1), creer une nouvelle tache ? (2) ou quitter l'application ? (3)");

            Scanner sc = new Scanner(System.in);

            String str = sc.nextLine();

            if(str.equals("1"))
            {
                List<Task> activities = request.getActivities();

                for(Task activitie : activities){
                    System.out.println("Nom de la tache: " + activitie.nameTask );
                    System.out.println("Description de la tache: " + activitie.description );
                    System.out.println("Importance de la tache: " + activitie.levelImportance + "\n");
                }
            }
            else if(str.equals("2"))
            {
                boolean isOk = false;
                while(!isOk)
                {
                    System.out.println("Saisir un nom de Tache");
                    String name = sc.nextLine();
                    System.out.println("Saisir votre description");
                    String description = sc.nextLine();
                    System.out.println("Saisir le niveau d'importance (1 a 3)");
                    int level  = Integer.parseInt(sc.nextLine());

                    if(level < 1 || level > 3){
                        System.out.println("le level n'est pas possible");
                    }
                    else{
                        isOk = true;
                    }
                    if(name == "")
                    {
                        System.out.println("Veuillez saisir un nom");
                    }
                    else{
                        isOk = true;
                    }
                    if(description == "")
                    {
                        System.out.println("Veuillez saisir une description");
                    }
                    else{
                        isOk = true;
                    }
                    if(isOk)
                    {
                        request.createTask(name,description,level);
                    }

                }

            }
            else if(str.equals("3"))
            {
                isEnd = true;
            }
            else
            {
                System.out.println("Aucune action pour ceci");
            }
        }
    }
}
