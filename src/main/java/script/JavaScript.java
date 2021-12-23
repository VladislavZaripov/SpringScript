package script;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaScript {

    private static Logger logger = LoggerFactory.getLogger(JavaScript.class);

    public static void main(String[] args) {

        ScriptEngineManager mgr = new ScriptEngineManager();

        mgr.getEngineFactories().forEach(factory -> {
            String engineName = factory.getEngineName();
            String languageName = factory.getLanguageName();
            String version = factory.getEngineVersion();
            logger.info("EngineName: " + engineName + " LanguageName: " + languageName + " EngineVersion:" + version);
        });

        ScriptEngine jsEngine = mgr.getEngineByName("JavaScript");

        try {
            jsEngine.eval("print('Hello JavaScript in Java')");
        } catch (ScriptException e) {
            logger.error("JavaScript expression cannot be evaluated!", e);
        }
    }
}