package demo9071.server.controller;

import demo9071.protocol.HelloService;
import demo9071.server.dso.service.UserService;
import org.noear.solon.annotation.*;

/**
 * @author noear 2021/6/7 created
 */
@Http
@Socket
@Mapping("/")
@Remoting
public class HelloServiceImpl implements HelloService {

    @Inject
    UserService userService;

    @Override
    public String hello(String name) {
        String name2 = userService.getUser(name);

        return "Hello " + name2;
    }
}