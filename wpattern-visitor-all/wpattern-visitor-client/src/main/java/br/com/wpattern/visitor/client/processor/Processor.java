package br.com.wpattern.visitor.client.processor;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import br.com.wpattern.visitor.client.processor.interfaces.IProcessorVisitor;
import br.com.wpattern.visitor.utils.interfaces.IElement;
import br.com.wpattern.visitor.utils.interfaces.IProcessor;
import br.com.wpattern.visitor.utils.interfaces.IVisitor;

@Named
public class Processor implements IProcessor, IProcessorVisitor {

	private final List<IVisitor> visitors;

	public Processor() {
		this.visitors = new ArrayList<IVisitor>();
	}

	@Override
	public void addVisitor(IVisitor visitor) {
		this.visitors.add(visitor);
	}

	@Override
	public void receiveElement(IElement element) {
		for (IVisitor visitor : this.visitors) {
			element.execute(visitor);
		}
	}

}
