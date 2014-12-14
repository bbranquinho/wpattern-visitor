package br.com.wpattern.visitor.client.visitors;

import br.com.wpattern.visitor.utils.elements.BookElement;
import br.com.wpattern.visitor.utils.elements.QuotationElement;
import br.com.wpattern.visitor.utils.interfaces.IVisitor;

public class ConsoleVisitor implements IVisitor {

	@Override
	public void visit(BookElement book) {
		System.out.println(book);
	}

	@Override
	public void visit(QuotationElement quotation) {
		System.out.println(quotation);
	}

}
