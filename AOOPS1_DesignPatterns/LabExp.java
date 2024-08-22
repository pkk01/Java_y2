interface MusicPlayer {
	void playMusic();
}

class Soptify {
	void musicPlayer() {
		System.out.println("Spotify Playing a Song");
	}
}

class MusicAdapter implements MusicPlayer {
	Soptify s = new Soptify();

	public void playMusic() {
		s.musicPlayer();
	}
}

class MusicPlayback {
	void setEqualizer(int unit) {
		System.out.println("Equalizer is set to: " + unit);
	}

	void setVolume(int vol) {
		System.out.println("Volume is set to: " + vol + "%");
	}
}

class selectMusicPlayer {
	MusicAdapter ma = new MusicAdapter();

	void chooseMusicPlayer(String source) {
		System.out.println("Playing music from: " + source + " in ");
		ma.playMusic();
	}
}

class MyMusic {
	private selectMusicPlayer select;
	private MusicPlayback mp;

	MyMusic(selectMusicPlayer select, MusicPlayback mp) {
		this.select = select;
		this.mp = mp;
	}

	void startMusic(String source, int eq, int vol) {
		select.chooseMusicPlayer(source);
		mp.setEqualizer(eq);
		mp.setVolume(vol);
	}
}

public class LabExp {
	public static void main(String args[]) {
		selectMusicPlayer smp = new selectMusicPlayer();
		MusicPlayback mp = new MusicPlayback();
		MyMusic mm = new MyMusic(smp, mp);
		mm.startMusic("Local", 30, 70);
	}
}