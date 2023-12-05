package data.courses;

public enum CoursesDurationData {
    JAVA_QA_PRO("//p[contains(text(),'4 месяца')]");

    private String name;

    CoursesDurationData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}