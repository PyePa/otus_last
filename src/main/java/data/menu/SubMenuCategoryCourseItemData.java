package data.menu;

public enum SubMenuCategoryCourseItemData implements ISubMenu{

    TESTING("/categories/testing"),

    LESSON_CALENDAR("/events/near");
    private String name;


    SubMenuCategoryCourseItemData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}