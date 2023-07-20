package com.example.provider.fitter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * Ŀ�귽��ִ��ǰ
     * �÷����ڿ������������󷽷�ǰִ�У��䷵��ֵ��ʾ�Ƿ��жϺ�������
     * ���� true ��ʾ��������ִ�У����� false ��ʾ�жϺ�������
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try {
            Object login_User = request.getSession().getAttribute("login");
            if (login_User == null) {


//                Object login_User = request.getSession().getAttribute("login");


                    request.setAttribute("msg", "你没有权限!");
                    request.getRequestDispatcher("/tologin").forward(request, response);
                    return false;



            }

        else {

                return true;
            }

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

//        try {
//            Object loginUser = request.getSession().getAttribute("login");
//            if (loginUser == null) {
//                //δ��¼�����ص�½ҳ
//                request.setAttribute("msg", "you are no permission!");
//                System.out.println(request.getAttribute("msg"));
//                request.getRequestDispatcher("/tologin").forward(request, response);
//                return false;
//            } else {
//                //阻止
//                return true;
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            return  false;
//        }



    }
    /**
     * Ŀ�귽��ִ�к�
     * �÷����ڿ������������󷽷�����֮�󡢽�����ͼ֮ǰִ��
     * ����ͨ���˷������������е�ģ�ͺ���ͼ����һ���޸�
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandleִ��{}", modelAndView);
    }
    /**
     * ҳ����Ⱦ��
     * �÷�������ͼ��Ⱦ������ִ��
     * ����ͨ���˷���ʵ����Դ������¼��־��Ϣ�ȹ���
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletionִ���쳣{}", ex);
    }
}
