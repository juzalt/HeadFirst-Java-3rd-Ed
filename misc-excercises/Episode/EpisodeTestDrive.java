class Episode {
    int seriesNumber;
    int episodeNumber;

    void play() {
        System.out.println("Playing episode " + episodeNumber + " in series number " + seriesNumber);
    }

    void skipIntro() {
        System.out.println("Skipping intro...");
    }

    void skipToNext() {
        System.out.println("Loading next episode...");
    }
}

class EpisodeTestDrive {
    public static void main(String[] args) {
        Episode episode = new Episode();
        episode.seriesNumber = 4;
        episode.episodeNumber = 1;
        episode.play();
        episode.skipIntro();

    }
}