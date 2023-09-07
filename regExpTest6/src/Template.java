import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.Map;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 *
 * @author liaoxuefeng
 */
public class Template {

    final String template;
    final Pattern pattern = Pattern.compile("\\$\\{(\\w+)\\}");

    public Template(String template) {
        this.template = template;
    }

    public String render(Map<String, Object> data) {
        Matcher m = pattern.matcher(template);
        StringBuilder result = new StringBuilder();
        // TODO:
        while (m.find()) {
            String s = m.group(1);
            if(data.containsKey(s)){
                Object value = data.get(s);
                if(value instanceof String val){
                    m.appendReplacement(result, val);
                }
            }
        }
        m.appendTail(result);
        return result.toString();
    }

}