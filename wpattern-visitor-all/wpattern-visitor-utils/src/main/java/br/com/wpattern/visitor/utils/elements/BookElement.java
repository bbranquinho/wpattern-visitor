package br.com.wpattern.visitor.utils.elements;

import br.com.wpattern.visitor.utils.beans.BookBean;
import br.com.wpattern.visitor.utils.interfaces.IElement;
import br.com.wpattern.visitor.utils.interfaces.IVisitor;

public class BookElement implements IElement {

	private static final long serialVersionUID = 2660481763473236848L;

	private BookBean bookBean;

	public BookElement(BookBean bookBean) {
		this.bookBean = bookBean;
	}

	public BookBean getBookBean() {
		return this.bookBean;
	}

	@Override
	public void execute(IVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return this.bookBean.toString();
	}

}
