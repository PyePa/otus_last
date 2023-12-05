package data.courses;

public enum CoursesFormatData {
    JAVA_QA_PRO("//p[contains(text(),'Онлайн')]");

    private String name;

    CoursesFormatData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}