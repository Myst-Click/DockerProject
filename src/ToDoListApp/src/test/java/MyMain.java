import java.util.List;
import java.util.*;

public class MyMain {
    public static void main(String[] args) throws Exception {
        System.out.println("----------------------------------------------MY TODOLIST----------------------------------------------");
        var isEnd = false;
        while(!isEnd)
        {
            System.out.println("Bienvenue sur votre Liste de Tache");
            System.out.println("Voulez vous afficher vos taches ? (1) ou creer une nouvelle tache ? (2)");

            Scanner sc = new Scanner(System.in);

            String str = sc.nextLine();

            if(str == "1")
            {
                List<Task> activities = request.getActivities();

                for(Task activitie : activities){
                    System.out.println("Nom de la tache: " + activitie.nameTask );
                    System.out.println("Description de la tache: " + activitie.description );
                    System.out.println("Importance de la tache: " + activitie.levelImportance + "\n");
                }
            }
            else if(str == "2")
            {
                var isOk = false;
                while(!isOk)
                {
                    System.out.println("Saisir un nom de Tache");
                    String name = sc.nextLine();
                    System.out.println("Saisir votre description");
                    String description = sc.nextLine();
                    System.out.println("Saisir le niveau d'importance (1 a 3)");
                    int level  = Integer.parseint(sc.nextLine());
    
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

                    
                }
                


            }
            else 
            {
                System.out.println("Aucune action pour ceci");
            }
        }
    }
}
