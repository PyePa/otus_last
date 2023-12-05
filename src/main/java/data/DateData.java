package data;

import java.util.Arrays;

public enum DateData {

    JANUARY("января", "01"),
    FEBRUARY("февраля", "02"),
    MARCH("марта", "03"),
    APRIL("апреля", "04"),
    MAY ("мая", "05"),
    JUNE ("июня", "06"),
    JULY ("июля", "07"),
    AUGUST ("августа", "08"),
    SEPTEMBER ("сентября", "09"),
    OCTOBER ("октября", "10"),
    NOVEMBER ("ноября", "11"),
    DECEMBER ("декабря", "12");

    private String name;
    private String id;

    DateData(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public static DateData getDateData(String name) {
        return Arrays.stream(DateData.values())
                .filter((DateData dateData) -> dateData.getName().equals(name))
                .findFirst().get();
    }
}