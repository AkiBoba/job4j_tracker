package ru.job4j.inheritance;

public class TextReport {

    public String generate(String name, String body) {
        return name + System.lineSeparator() + body;
    }
}

class HtmlReport extends TextReport {

    @Override
    public String generate(String name, String body) {
        return "<h1>" + name + "</h1>" + "<br/>" + "<span>" + body + "</span>";
    }
}

class JSONReport extends TextReport {

    @Override
    public String generate(String name, String body) {
        return "{" + System.lineSeparator()
                + "\"name\" : "
                + "\"" + name + "\"" + ","
                + System.lineSeparator()
                + "\"body\" : "
                + "\"" + body + "\"" + System.lineSeparator()
                + "}";
    }
}

class ReportUsage {
    public static void main(String[] args) {
        JSONReport report = new JSONReport();
        String text = report.generate("name", "body");
        System.out.println(text);
    }
}