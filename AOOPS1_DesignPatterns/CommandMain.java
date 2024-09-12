interface Command {
    void execute();

    void undo();
}

class LightsOn implements Command {
    private Light light;

    public LightsOn(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }

    public void undo() {
        light.off();
    }
}

class LightsOff implements Command {
    private Light light;

    public LightsOff(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }

    public void undo() {
        light.on();
    }
}

// reciver
class Light {
    public void on() {
        System.out.println("Lights ON");
    }

    public void off() {
        System.out.println("Lights OFF");
    }
}
// invoker (remote)

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

    public void pressUndo() {
        command.undo();
    }
}

public class CommandMain {
    public static void main(String[] args) {
        Light livingRoom = new Light();
        Command Lon = new LightsOn(livingRoom);
        Command loff = new LightsOff(livingRoom);
        RemoteControl rc = new RemoteControl();
        rc.setCommand(Lon);
        rc.pressButton();
        rc.setCommand(loff);
        rc.pressButton();
        rc.pressUndo();

    }
}
