package REST;


import DB.DBUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //Denne metode kan bruges til at initializere forskellige ting når vi starter REST op.
        //String[] args = new String[0];
        //DBUtil.main( args );
    }

}
