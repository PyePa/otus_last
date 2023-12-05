package data;

public enum EventsSortData {
    OPENWEBINAR("Открытый вебинар", "Открытый вебинар");

    private String nameFilter;
    private String namePage;

    EventsSortData(String nameFilter, String namePage ) {
        this.nameFilter = nameFilter;
        this.namePage = namePage;
    }

    public String getNameFilter() {
        return nameFilter;
    }

    public String getNamePage() {
        return namePage;
    }
}