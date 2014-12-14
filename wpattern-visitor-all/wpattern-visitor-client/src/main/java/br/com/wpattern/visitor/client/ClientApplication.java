package br.com.wpattern.visitor.client;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

import br.com.wpattern.visitor.client.interfaces.IClientApplication;
import br.com.wpattern.visitor.client.processor.interfaces.IProcessorVisitor;
import br.com.wpattern.visitor.client.visitors.ConsoleVisitor;
import br.com.wpattern.visitor.client.visitors.FileVisitor;
import br.com.wpattern.visitor.utils.interfaces.IVisitor;

@Named
public class ClientApplication implements IClientApplication {

	private static final Logger logger = Logger.getLogger(ClientApplication.class);

	@Inject
	private IProcessorVisitor processorVisitor;

	private static final String FILE_PATH = "src\\main\\resources\\file_visitor.txt";

	@Override
	public void startApplication() {
		IVisitor fileVisitor = null;
		IVisitor consoleVisitor = new ConsoleVisitor();

		try {
			fileVisitor = new FileVisitor(FILE_PATH);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			System.exit(-1);
		}

		this.processorVisitor.addVisitor(fileVisitor);
		this.processorVisitor.addVisitor(consoleVisitor);
	}

}
