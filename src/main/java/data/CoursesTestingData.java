package data;

public enum CoursesTestingData {
    JAVA_QA_PRO("java-qa-pro");

    private String name;

    CoursesTestingData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}