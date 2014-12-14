package br.com.wpattern.visitor.utils.interfaces;

import java.io.Serializable;

public interface IElement extends Serializable {

	void execute(IVisitor visitor);

}
