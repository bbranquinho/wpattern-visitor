package br.com.wpattern.visitor.utils.interfaces;

import br.com.wpattern.visitor.utils.elements.BookElement;
import br.com.wpattern.visitor.utils.elements.QuotationElement;

public interface IVisitor {

	void visit(BookElement book);

	void visit(QuotationElement quotation);

}
