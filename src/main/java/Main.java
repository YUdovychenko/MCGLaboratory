import com.mcglab.domain.Doctor;
import com.mcglab.service.DoctorService;
import com.mcglab.service.impl.DoctorServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Admin on 30.07.15.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring/config/BeanLocations.xml");
        DoctorService doctorService = context.getBean("doctorService", DoctorServiceImpl.class);
        doctorService.create(new Doctor("Chaikovskii", "Illya", "IChaikovskii", "IChaikovskii"));
    }
}
