package webapplication.jupiter.core;

import net.thucydides.core.guice.Injectors;

import net.thucydides.core.util.EnvironmentVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Properties  {
     private static EnvironmentVariables vars = Injectors.getInjector().getProvider(EnvironmentVariables.class).get();

    public static String getBaseUrl() {
        return getProperty("webdriver.base.url");
    }
    
       
    public static String expName() {return getProperty("serenity.project.name");}
  
    
    
    public static String getProperty(String property) {
        return vars.getProperty(property);
    }
    
 
}
