package com.rcpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import javax.servlet.http.HttpServletRequest;




public class MyFirstStrutsClass extends ActionSupport implements ModelDriven<Student_info>
{
    Student_info ob = new Student_info();

    public Student_info getOb() {
        return ob;
    }

    public void setOb(Student_info ob) {
        this.ob = ob;
    }
    HttpServletRequest request ;
    
    
    @Override
    public String execute(){
       boolean result = new UserRegistration().Registration(ob);
       if(result)
       {
           request.setAttribute("msg", "Registration Sucessful");
            return SUCCESS;
       }
       else
           request.setAttribute("msg", "Registration Unsuccesful");
           return ERROR ;
    }


    @Override
    public void validate()
    {
        if(ob.getName().trim().length() == 0)
        {
            addFieldError("name", "Name cant be empty");
        }
        if(ob.getPass().trim().length() < 6)
        {
             addFieldError("pass", ERROR);
        }
    }

    @Override
    public Student_info getModel() {
        return ob;
    }
    
}
