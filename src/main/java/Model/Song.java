package Model;

public class Song {

        private int songid;
        private String songname;
        private String artistname;
        private String albumname;
        private String songgenre;
        private String duration;

        public Song(int songid, String songname, String artistname, String albumname, String songgenre, String duration) {
            this.songid = songid;
            this.songname = songname;
            this.artistname = artistname;
            this.albumname= albumname;
            this.songgenre = songgenre;
            this.duration = duration;
        }

        public Song(String songname, String artistname, String songgenre, String duration) {
            this.songname = songname;
            this.artistname = artistname;
            this.albumname= albumname;
            this.songgenre = songgenre;
            this.duration = duration;
        }

        public Song() {
        }

        public int getSongid() {
            return songid;
        }

        public void setSongid(int songid) {
            this.songid = songid;
        }

        public String getSongname() {
            return songname;
        }

        public void setSongname(String songname) {
            this.songname = songname;
        }

        public String getArtistname() {
            return artistname;
        }

        public void setArtistname(String artistname) {
            this.artistname = artistname;
        }

    public String getAlbumname() {
        return artistname;
    }

    public void setAlbumname(String artistname) {
        this.artistname = artistname;
    }

        public String getSonggenre() {
            return songgenre;
        }

        public void setSonggenre(String songgenre) {
            this.songgenre = songgenre;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        @Override
        public String toString() {
            return String.format("%10s\t%20s\t%20s\t%20s\t%20s\t%10s",
                    songid, songname, artistname, albumname, songgenre, duration);
        }
}

