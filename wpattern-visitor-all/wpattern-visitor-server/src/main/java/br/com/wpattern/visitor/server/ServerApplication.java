package br.com.wpattern.visitor.server;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.wpattern.visitor.server.interfaces.IProducer;
import br.com.wpattern.visitor.server.interfaces.IServerApplication;
import br.com.wpattern.visitor.utils.interfaces.IProcessor;

@Named
public class ServerApplication implements IServerApplication {

	@Inject
	private IProducer producer;

	@Inject
	private IProcessor processor;

	@Override
	public void startApplication() {
		this.producer.startProducer(this.processor);
	}

}
