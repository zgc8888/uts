package java.com.uts.listener;


import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.com.uts.netty.ServerNetty;

/**
 * Created by Administrator on 2018/3/6 0006.
 */
@Component("SpringListener")
public class SpringListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if(contextRefreshedEvent.getApplicationContext().getParent()==null){
            //需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
            System.out.println("spring 加载完毕..");
            try {
                ServerNetty.getIntance().start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
