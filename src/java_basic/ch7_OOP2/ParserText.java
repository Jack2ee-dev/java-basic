package java_basic.ch7_OOP2;

public class ParserText {

    public static void main(String[] args) {
        Parsable parser = ParserManager.getParser("XML");
        parser.parse("document.xml");
        parser = ParserManager.getParser("HTML");
        parser.parse("document2.html");
    }

}

interface Parsable {

    public abstract void parse(String fileName);
}

class ParserManager {

    public static Parsable getParser(String type) {
        if (type.equals("XML")) {
            return new XMLParser();
        }
        return new HTMLParser();
    }
}

class XMLParser implements Parsable {

    @Override
    public void parse(String fileName) {
        System.out.println(fileName + "- XML parsing completed.");
    }
}

class HTMLParser implements Parsable {

    @Override
    public void parse(String fileName) {
        System.out.println(fileName + "- HTML parsing completed.");
    }
}
