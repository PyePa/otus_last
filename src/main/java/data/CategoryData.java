package data;

public enum CategoryData {
    TESTING("Тестирование");

    private String name;

    CategoryData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}