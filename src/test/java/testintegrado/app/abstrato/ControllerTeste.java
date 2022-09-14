package testintegrado.app.abstrato;

import javax.transaction.Transactional;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@Transactional
@SpringBootTest
@TestPropertySource(properties = {"spring.datasource.url=jdbc:h2:mem:db;DB_CLOSE_DELAY=-1","spring.datasource.driver-class-name=org.h2.Driver"})
public abstract class ControllerTeste {
    
}
