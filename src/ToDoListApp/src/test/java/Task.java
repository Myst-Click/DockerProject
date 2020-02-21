import javax.swing.*;

public class Task {
    int id = 0;
    String nameTask;
    String levelImportance;

    // Constructeur par defaut
    public Task(){
        System.out.println("A task was created");
        nameTask = " ";
        levelImportance = " ";
        id ++;
    }

    //Constructeur avec parametres
    public Task(String pNameTask, String pLevelImportance){
        System.out.println("Create one task with params");
        pNameTask = nameTask;
        pLevelImportance = levelImportance;
        id ++;
    }

    public String getLevelImportance(){
        return levelImportance;
    }

    public String getNameTask(){
        return  nameTask;
    }

    public int getId(){
        return  id;
    }

    //en commentaire pour l'instant
//    public void setId(int id) {
//        this.id = id;
//    }

    public void setLevelImportance(String pLevelImportance) {
        levelImportance = pLevelImportance;
    }

    public void setNameTask(String pNameTask) {
        nameTask = pNameTask;
    }

    public String toString(){
        return this.id + "/t ==>>" + this.nameTask + this.levelImportance;
    }
}