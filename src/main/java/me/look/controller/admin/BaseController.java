package me.look.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class BaseController {



    @Autowired
    protected HttpServletRequest request;





    /**
     * 后台模板目录
     */
    private static String AdminPath="admin";



    /**获取请求参数*/
    protected String GetParam(String key)
    {
        return request.getParameter(key);
    }


    /**
     * 视图路径
     * @param viewName
     * @return
     */
    protected String View(String viewName)
    {
        return  AdminPath+"/"+viewName;
    }


    /**成功*/
    protected <T> Result Seccuss(T data)
    {
        Result<T> result=new Result<T>(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMsg(),data);
        return  result;
    }
    /**失败*/
    protected <T> Result Fail(T data)
    {
        Result<T> result=new Result<T>(ErrorCode.FAIL.getCode(),ErrorCode.FAIL.getMsg(),data);
        return  result;
    }
    /**失败*/
    protected <T> Result Error(T data)
    {
        Result<T> result=new Result<T>(ErrorCode.ERROR.getCode(),ErrorCode.ERROR.getMsg(),data);
        return  result;
    }

}
