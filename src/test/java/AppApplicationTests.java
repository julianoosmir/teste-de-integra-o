import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@EnableConfigurationProperties
@TestPropertySource(properties = {"spring.datasource.url=jdbc:postgresql://localhost:5432/teste"})
class AppApplicationTests {

	

}
