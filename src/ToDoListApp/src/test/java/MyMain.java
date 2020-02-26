import java.util.List;

public class MyMain {
    public static void main(String[] args) throws Exception {
        System.out.println("----------------------------------------------MY TODOLIST----------------------------------------------");
        Task task = new Task("keke", 11,"E");
        System.out.println("id = " + task);
        Request request = new Request();
        List<Task> activities = request.getActivities();

        for(Task activitie : activities){
            System.out.println("Nom de la tache: " + activitie.nameTask );
            System.out.println("Description de la tache: " + activitie.description );
            System.out.println("Importance de la tache: " + activitie.levelImportance + "\n");
        }

        //Task task11 = new Task();
        //System.out.println("id = " + task11.id);
    }
}
