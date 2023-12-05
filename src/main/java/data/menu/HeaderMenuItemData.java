package data.menu;

public enum HeaderMenuItemData {

    LEARNING("Обучение");

    private String name;

    HeaderMenuItemData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}