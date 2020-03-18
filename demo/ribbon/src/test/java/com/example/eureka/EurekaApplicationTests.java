package com.example.eureka;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import com.netflix.loadbalancer.reactive.ServerOperation;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import rx.Observable;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@SpringBootTest
class EurekaApplicationTests {

	@Test
	void contextLoads() {
		List<Server>  list= Lists.newArrayList(
				new Server("localhost",8002)
		);
		System.out.println("----1");
		ILoadBalancer loadBalancer= LoadBalancerBuilder.newBuilder()
				.buildFixedServerListLoadBalancer(list);
		System.out.println("----2");
		for (int i=0;i<5;i++){
			String first = LoadBalancerCommand.<String>builder()
					.withLoadBalancer(loadBalancer)
					.build()
					.submit(new ServerOperation<String>() {
						@Override
						public Observable<String> call(Server server) {
							String ards="http://"+server.getHost()+":"+
									server.getPort()+"/say/hello";
							System.out.println("调用地址"+ards);
							try {
								URL url = new URL(ards);
								HttpURLConnection urlConnection =(HttpURLConnection) url.openConnection();
								urlConnection.setRequestMethod("GET");
								urlConnection.connect();
								InputStream inputStream=urlConnection.getInputStream();
								byte []aByte = new byte[inputStream.available()];
								inputStream.read(aByte);
								return Observable.just(new String(aByte));
							} catch (MalformedURLException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}

							return null;
						}
					}).toBlocking().first();
			System.out.println("调用结果："+first);
		}

	}

}
