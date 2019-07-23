package com.zyx;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.URL;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class Demo1ApplicationTests {

	//Spring boot 获取当前启动端口和IP
	//SpringBootTest.WebEnvironment.RANDOM_PORT经常和测试类中@LocalServerPort一起在注入属性时使用。会随机生成一个端口号。
	//SpringBootTest.WebEnvironment.DEFINED_PORT经常和测试类中@LocalServerPort一起在注入属性时使用。是配置文件中配置指定的端口号。
	@LocalServerPort
	private int port;
	private InetAddress inetAddress;
	private URL url;

	@Autowired
	private TestRestTemplate testRestTemplate;
	@Autowired
	private Environment environment;//通过environment获取配置文件中的属性

	@Before
	public void setUp() throws Exception{
		inetAddress = Inet4Address.getLocalHost();
		String ip = inetAddress.getHostAddress();

		String contextPath = environment.getProperty("server.servlet.context-path");//通过environment获取配置文件中的属性
		this.url = new URL("http://"+ip+":" + port +contextPath+"/demo1");
		System.out.println("url:"+url);//url:http://192.168.18.115:51740/project1/demo1
	}

	@Test
	public void demo1() throws Exception{
		ResponseEntity<String> response = testRestTemplate.getForEntity(url.toString(), String.class);
		assertEquals(response.getBody(),"Hello zyx");

	}

}
