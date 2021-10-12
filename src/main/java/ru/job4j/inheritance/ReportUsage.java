package ru.job4j.inheritance;

/**
 * @author Vladimir Likhachev
 */
class ReportUsage {
    public static void main(String[] args) {
        JSONReport report = new JSONReport();
        String text = report.generate("name", "body");
        System.out.println(text);
    }
}