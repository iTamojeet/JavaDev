// DVD class
class DVD {
    private String title;
    private String genre;

    public DVD(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "DVD [Title=" + title + ", Genre=" + genre + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DVD)) return false;
        DVD d = (DVD) obj;
        return this.title.equals(d.title) && this.genre.equals(d.genre);
    }
}
