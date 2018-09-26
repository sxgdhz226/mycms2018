import org.activiti.engine.RuntimeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ActivitTest.class)
public class ActivitTest {

    @Autowired
    RuntimeService runtimeService;

    @Test
    public void TestStartProcess() {
        System.out.println(runtimeService);
    }

}
