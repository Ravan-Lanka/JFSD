package klh.edu.in.Library;

import org.springframework.stereotype.Component;

@Component
public class CBook implements Book{
	
	public void Read() {
		
		System.out.println("Reading C - Book");
		
	}

}
