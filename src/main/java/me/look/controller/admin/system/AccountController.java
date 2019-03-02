package me.look.controller.admin.system;

import me.look.common.enums.AccountLockStatus;
import me.look.common.enums.IsDelete;
import me.look.common.utils.DateUtils;
import me.look.controller.admin.BaseController;
import me.look.controller.admin.ErrorCode;
import me.look.controller.admin.Result;
import me.look.entity.Account;
import me.look.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@RequestMapping("/admin/account")
@Controller
public class AccountController extends BaseController {

    //模板目录
    String viewDic="system/account/";



    @Autowired
    protected AccountService accountService;

    /**账号管理列表页面*/
    @RequestMapping("index")
    public String Index()
    {
        return View(viewDic+"index");
    }

    /**账号添加界面*/
    @RequestMapping("add")
    public String Add()
    {
        return View(viewDic+"add");
    }


    @ResponseBody
    @RequestMapping("doAdd")
    /**添加账号*/
    public Result DoAdd(Account account)
    {
       String name=  GetParam("uid");

       try{
           Date date=new Date();

           String d=DateUtils.GetCurrentDateTimeToString();

           account.setCreatetime(date);
           account.setLogintime(date);
           account.setLockstatus((byte) AccountLockStatus.normal.getKey());
           account.setIsdelete((byte)IsDelete.no.getKey());
           accountService.insert(account);
           return Seccuss("成功");
       }catch (Exception ex){
            return Fail("失败");
       }

    }
}
