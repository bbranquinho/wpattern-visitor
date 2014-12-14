package br.com.wpattern.visitor.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.wpattern.visitor.client.interfaces.IClientApplication;
import br.com.wpattern.visitor.server.interfaces.IServerApplication;

public class FactoryMain {

	private static final String CTX_CLIENT = "ctx-wpattern-visitor-client.xml";
	private static final String CTX_FACTORY = "ctx-wpattern-visitor-factory.xml";
	private static final String CTX_SERVER = "ctx-wpattern-visitor-server.xml";

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(CTX_CLIENT, CTX_FACTORY, CTX_SERVER);

		IServerApplication serverApplication = context.getBean(IServerApplication.class);
		serverApplication.startApplication();

		IClientApplication clientApplication = context.getBean(IClientApplication.class);
		clientApplication.startApplication();
	}

}
