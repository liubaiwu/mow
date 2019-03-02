package me.look.controller.admin;


import me.look.entity.Account;
import me.look.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/admin")
@Controller
public class AdminController extends BaseController {

    @Autowired
    private AccountService accountService;

    /**
     * 后台首页
     * @return
     */
    @RequestMapping("/index")
    public String Index()
    {

       Account account= accountService.getAccountById(2L);

        return View("index");
    }

    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/login")
    public String Login()
    {
        return View("login");
    }

    /**
     * home主目录
     * @return
     */
    @RequestMapping("/home")
    public String home()
    {
        return View("home");
    }
}
