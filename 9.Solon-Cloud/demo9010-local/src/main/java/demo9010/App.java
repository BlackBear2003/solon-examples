package demo9010;

import org.noear.solon.Solon;
import org.noear.solon.core.event.AppLoadEndEvent;
import org.noear.solon.core.event.PluginLoadEndEvent;
import org.noear.solon.i18n.I18nUtil;

import java.util.Locale;

/**
 * @author noear 2022/11/21 created
 */
public class App {
    public static void main(String[] args) throws Exception {
        Solon.start(App.class, args, app -> {
            //插件加载完之后
            app.onEvent(PluginLoadEndEvent.class, e -> {
                System.out.println("云端配置服务通过配置load的：" + Solon.cfg().get("demo.db1.url"));
            });

            //应用加载完之后
            app.onEvent(AppLoadEndEvent.class, e -> {
                //在 Config::init2 里，用 CloudI18nBundleFactory 替换了本地的
                System.out.println("云端国际化读取：" + I18nUtil.getMessage(Locale.CHINA, "user.name"));
            });
        });
    }
}