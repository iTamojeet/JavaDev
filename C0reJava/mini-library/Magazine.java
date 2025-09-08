// Magazine class
class Magazine {
    private String name;
    private int issueNo;

    public Magazine(String name, int issueNo) {
        this.name = name;
        this.issueNo = issueNo;
    }

    @Override
    public String toString() {
        return "Magazine [Name=" + name + ", Issue=" + issueNo + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Magazine)) return false;
        Magazine m = (Magazine) obj;
        return this.name.equals(m.name) && this.issueNo == m.issueNo;
    }
}
