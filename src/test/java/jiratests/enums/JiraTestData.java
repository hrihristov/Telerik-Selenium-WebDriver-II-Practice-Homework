package jiratests.enums;

public enum JiraTestData {
    USER_USERNAME("hristo.hristov.a61@learn.telerikacademy.com"),
    USER_PASSWORD("A229762s");

    JiraTestData(String propName) {
        value = propName;
    }

    public String getValue() {
        return value;
    }

    final String value;
}
