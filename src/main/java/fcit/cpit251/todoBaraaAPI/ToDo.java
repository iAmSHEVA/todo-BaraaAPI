package fcit.cpit251.todoBaraaAPI;

import java.util.UUID;

public class ToDo {
    private String name;
    private String id;
    private boolean isComplete;

    public ToDo(){
        this.isComplete = false;
        this.id = UUID.randomUUID().toString();
    }

    public ToDo(String name) {
        this.name = name;
        this.isComplete = false;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isComplete() {
        return this.isComplete;
    }

    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public String toString() {
        return "ToDo: id: " + this.id + "\nName: " + this.name + "\nDone: " + (this.isComplete ? "Yes" : "No");
    }
}
