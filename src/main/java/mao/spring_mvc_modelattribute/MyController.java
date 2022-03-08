package mao.spring_mvc_modelattribute;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Project name(项目名称)：Spring_MVC_ModelAttribute
 * Package(包名): mao.spring_mvc_modelattribute
 * Class(类名): MyController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/3/8
 * Time(创建时间)： 20:09
 * Version(版本): 1.0
 * Description(描述)： @ModelAttribute，用来将请求参数绑定到 Model 对象。
 */

@Controller
public class MyController
{
    //private static final Logger log = LoggerFactory.getLogger(MyController.class);
    private static final Log log = LogFactory.getLog(MyController.class);

    /**
     * My model.
     *
     * @param name  the name
     * @param model the model
     */
    // 方法无返回值
    @ModelAttribute
    public void myModel(@RequestParam(required = false) String name, Model model)
    {
        log.info("执行myModel...");
        model.addAttribute("name", name);
    }

    /**
     * Test 1 string.
     *
     * @return the string
     */
    @RequestMapping("test1")
    public String test1()
    {
        return "main";
    }


    /**
     * Test 2 string.
     *
     * @return the string
     */
    @RequestMapping("test2")
    public String test2()
    {
        return "main";
    }

    /**
     * My model 2 string.
     *
     * @param name3 the name 3
     * @return the string
     */
    // 方法有返回值
    @ModelAttribute("name3")
    public String myModel2(@RequestParam(required = false) String name3)
    {
        log.info("myModel2");
        return name3;
    }

    /**
     * Test 3 string.
     *
     * @return the string
     */
    @RequestMapping("test3")
    public String test3()
    {
        return "main3";
    }

    /**
     * Test 4 string.
     *
     * @param user the user
     * @return the string
     */
    @RequestMapping("/test4")
    public String test4(@ModelAttribute("user") User user)
    {
        if ("test".equals(user.getName()) && "123456".equals(user.getPassword()))
        {
            log.info("成功");
            return "success";
        }
        else
        {
            log.info("失败");
            return "error";
        }
    }

    /**
     * Test 5 string.
     *
     * @param name the name
     * @return the string
     */
    @RequestMapping(value = "/test5")
    @ModelAttribute("name")
    public String test5(@RequestParam(required = false) String name)
    {
        return name;
    }
}
