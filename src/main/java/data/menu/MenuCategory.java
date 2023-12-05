package data.menu;

public enum MenuCategory implements ISubMenu{
    TEST("Тестирование"),
    EVENTS_CALENDAR("Календарь мероприятий");
    private String name;

    MenuCategory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}