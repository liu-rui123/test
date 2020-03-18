package client.controller;

import client.dao.PaymentDao;
import com.liu.springCloud.springCloud.entities.CommonResult;
import com.liu.springCloud.springCloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class EurekaServerController {


    @Value("${server.port}")
    private String port;

    @Resource
    private PaymentDao dao;

    @GetMapping("/say/hello")
    public String say(){
        int a=1/0;
/*
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("=========================");
        return "hello port:"+port;
    }

    @GetMapping("/say/all")
    public CommonResult<Payment> all(){
        List<Payment> all = dao.all();
        if(all==null){
            return new CommonResult(500,"查询失败");
        }

        return new CommonResult(200,"查询成功",all);
    }

    @PostMapping("/say/add")
    public CommonResult add(@RequestBody Payment payment){
        Integer integer = dao.create(payment);
        if(integer>0){

            return new CommonResult(200,"添加成功："+payment);
        }
        return new CommonResult(500,"添加失败");

    }

    @PostMapping("/say/update")
    public CommonResult update(@RequestBody Payment payment){
        System.out.println("进入修改！！！");
        Integer integer = dao.update(payment);
        System.out.println(payment);
        if(integer>0){

            return new CommonResult(200,"修改成功："+payment);
        }
        return new CommonResult(500,"修改失败");

    }
    @GetMapping("/say/delete")
    public CommonResult delete(@RequestParam("id") Long id){
        Integer integer = dao.delete(id);
        if(integer>0){

            return new CommonResult(200,"删除成功");
        }
        return new CommonResult(500,"删除失败");

    }
    @GetMapping("/say/getName")
    public CommonResult<Payment> getName(@RequestParam("name") String name){
        Payment all = dao.getPaymentById(name);
        if(all==null){
            return new CommonResult(500,"查询失败");
        }

        return new CommonResult(200,"查询成功",all);
    }
}
