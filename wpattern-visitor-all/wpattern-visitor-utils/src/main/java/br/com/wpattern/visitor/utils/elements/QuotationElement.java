package br.com.wpattern.visitor.utils.elements;

import br.com.wpattern.visitor.utils.beans.QuotationBean;
import br.com.wpattern.visitor.utils.interfaces.IElement;
import br.com.wpattern.visitor.utils.interfaces.IVisitor;

public class QuotationElement implements IElement {

	private static final long serialVersionUID = 2675288466482335432L;

	private QuotationBean quotation;

	public QuotationElement(QuotationBean quotation) {
		this.quotation = quotation;
	}

	public QuotationBean getQuotationBean() {
		return this.quotation;
	}

	@Override
	public void execute(IVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return this.quotation.toString();
	}

}
