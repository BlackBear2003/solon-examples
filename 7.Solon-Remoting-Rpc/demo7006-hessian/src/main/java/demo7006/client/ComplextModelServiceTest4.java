package demo7006.client;

import org.noear.nami.Nami;
import org.noear.nami.coder.jackson.JacksonDecoder;
import org.noear.nami.coder.jackson.JacksonTypeEncoder;
import org.noear.solon.Solon;
import demo7006.server.dso.IComplexModelService;
import demo7006.server.model.ComplexModel;
import demo7006.server.model.Person;
import demo7006.server.model.Point;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComplextModelServiceTest4 {
    public static void main(String[] args) throws Exception {
        Solon.start(ClientApp.class, args, app->app.enableHttp(false));

        //配置接口代理
        IComplexModelService service =  Nami.builder()
                .encoder(JacksonTypeEncoder.instance)
                .decoder(JacksonDecoder.instance)
                .upstream(()->{
            return "http://localhost:8080";
        }).create(IComplexModelService.class);


        ComplexModel<Point> model = new ComplexModel<Point>();
        model.setId(1);
        Person person = new Person();
        person.setName("Tom");
        person.setAge(86);
        person.setBirthDay(new Date());
        person.setSensitiveInformation("This should be private over the wire");
        model.setPerson(person);

        List<Point> points = new ArrayList<Point>();
        Point point = new Point();
        point.setX(3);
        point.setY(4);
        points.add(point);

        point = new Point();
        point.setX(100);
        point.setY(100);
        points.add(point);

        //远程方法调用
        model.setPoints(points);
        service.save(model);

        model = service.read(model.getId());
        List<Point> points1 = model.getPoints();
        for(Point elem : points1) {
            System.out.println(elem.getX() + "\t" + elem.getY());
        }

    }
}
