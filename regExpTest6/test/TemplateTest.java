import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class TemplateTest extends TestCase {

    public void testRender() {
        Template t = new Template("Hello, ${name}! You are learning ${lang}!");
        Map<String, Object> data = new HashMap<>();
        data.put("name", "Bob");
        data.put("lang", "Java");
        assertEquals("Hello, Bob! You are learning Java!", t.render(data));
    }
}