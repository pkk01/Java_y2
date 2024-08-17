class Projector {
    public void on() {
        System.out.println("Projector is ON");
    }

    public void off() {
        System.out.println("Project is OFF");
    }

    public void setInput(String input) {
        System.out.println("Project input set to: " + input);
    }
}

class SoundSystem {
    public void on() {
        System.out.println("Sound system is ON");
    }

    public void off() {
        System.out.println("Sound system is OFF");
    }

    public void setSound(int vol) {
        System.out.println("System volume set to: " + vol);
    }
}

class DVDPlayer {
    public void on() {
        System.out.println("DVD Player is ON");
    }

    public void off() {
        System.out.println("DVD player is OFF");
    }

    public void play(String movie) {
        System.out.println("Playing Movie: " + movie);
    }
}

class MovieFacade {
    private Projector pr;
    private DVDPlayer dp;
    private SoundSystem ss;

    public MovieFacade(Projector pr, DVDPlayer dp, SoundSystem ss) {
        this.dp = dp;
        this.pr = pr;
        this.ss = ss;
    }

    public void WatchMovie(String movie) {
        System.out.println("Get ready to watch movie");
        pr.on();
        pr.setInput("DVD");
        ss.on();
        ss.setSound(70);
        dp.on();
        dp.play(movie);
    }

    public void endMovie() {
        System.out.println("The end");
        dp.off();
        ss.off();
        pr.off();
    }
}

public class FacadeMain {
    public static void main(String[] args) {
        DVDPlayer dvdp = new DVDPlayer();
        Projector p = new Projector();
        SoundSystem s = new SoundSystem();
        MovieFacade mf = new MovieFacade(p, dvdp, s);
        mf.WatchMovie("Kalki");
        mf.endMovie();
    }
}
