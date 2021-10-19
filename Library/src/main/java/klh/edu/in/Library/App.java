package klh.edu.in.Library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	/*
    	 * Spring Frame work holds IOC
    	 * IOC has 2 interfaces:
    	 * 		Bean factory - for small application programs
    	 * 		Application Context - for enterprise application  
    	 * 
    	 */
    	
    	
        //Book c = new CBook();
        //c.Read();
        
        //Book jb = new JavaBook();
        //jb.Read();
    	
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml"); 
    	
    	Book obj = (Book)context.getBean("book");
    	obj.Read();
    	
    }
}
