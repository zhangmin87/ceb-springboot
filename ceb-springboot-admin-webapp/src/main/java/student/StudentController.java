package student;


import com.alibaba.dubbo.config.annotation.Reference;


import com.ceb.system.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Reference
    private StudentService studentService;

    @RequestMapping(value = "/query",method = {RequestMethod.GET,RequestMethod.POST})
    public Model execute(Model model) {
       String test = studentService.getStudent();
       return  model;
    }
}