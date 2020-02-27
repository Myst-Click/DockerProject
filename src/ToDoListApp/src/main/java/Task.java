import java.time.LocalDateTime;

public class Task {
    int id;
    String nameTask;
    int levelImportance;
    String description;
    String currentTime;


    //Constructeur avec parametres
    public Task(String pNameTask, int pLevelImportance, String pdescription){
        this.nameTask = pNameTask;
        this.levelImportance = pLevelImportance;
        this.description = pdescription;
        this.currentTime = LocalDateTime.now().toString();
    }

//    public int getLevelImportance(){
//        return levelImportance;
//    }
//
//    public String getNameTask(){
//        return  nameTask;
//    }
//
//    public int getId(){
//        return  id;
//    }

    //en commentaire pour l'instant
//    public void setId(int id) {
//        this.id = id;
//    }

//    public void setLevelImportance(String pLevelImportance) {
//        levelImportance = pLevelImportance;
//    }
//
//    public void setNameTask(String pNameTask) {
//        nameTask = pNameTask;
//    }
//
//    public String toString(){
//        return this.id + "/t ==>>" + this.nameTask + this.levelImportance;
//    }
}
