package oop.practice.lab1.task3;
import oop.practice.lab1.task1.Display;
import java.util.ArrayList;
import java.util.List;

public class Assistant {
    private String assistantName;
    private List<Display>assignedDisplays;

    public Assistant(String assistantName) {
        this.assistantName = assistantName;
        this.assignedDisplays = new ArrayList<>();
    }

    public void assignDisplay(Display d) {
        assignedDisplays.add(d);
        System.out.println("Assigned " + d.getModel() + " to " + assistantName);
    }

    public void assist(){
        if (assignedDisplays.size() < 2){
            System.out.println("----------------------------------------");
            System.out.println("Not enough displays to compare.");
        }

        for (int i = 0; i < assignedDisplays.size(); i++) {
            for (int j = i + 1; j < assignedDisplays.size(); j++) {
                Display current = assignedDisplays.get(i);
                Display next = assignedDisplays.get(j);
                System.out.println("----------------------------------------");
                System.out.println("Comparing " + current.getModel() + " with " + next.getModel());
                current.compareWithMonitor(next);
            }
        }
    }

    public Display buyDisplay(Display d) {
        System.out.println("----------------------------------------");
        if (assignedDisplays.remove(d)){
            System.out.println(d.getModel() + " has been purchased and removed from the list.");
            return d;
        } else {
            System.out.println(d.getModel() + " is not available.");
            return null;
        }
    }
}
