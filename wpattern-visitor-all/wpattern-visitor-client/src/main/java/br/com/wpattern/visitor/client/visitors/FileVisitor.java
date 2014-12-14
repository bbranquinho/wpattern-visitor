package br.com.wpattern.visitor.client.visitors;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

import br.com.wpattern.visitor.utils.elements.BookElement;
import br.com.wpattern.visitor.utils.elements.QuotationElement;
import br.com.wpattern.visitor.utils.interfaces.IVisitor;

public class FileVisitor implements IVisitor {

	private static final Logger logger = Logger.getLogger(FileVisitor.class);

	private final File file;

	private final BufferedWriter output;

	public FileVisitor(String filePath) throws IOException {
		this.file = new File(filePath);
		this.output = new BufferedWriter(new FileWriter(this.file));
	}

	@Override
	public void visit(BookElement book) {
		this.writeTextInFile(String.format("BOOK:%s\n", book.toString()));
	}

	@Override
	public void visit(QuotationElement quotation) {
		this.writeTextInFile(String.format("QUOTATION:%s\n", quotation.toString()));
	}

	private void writeTextInFile(String text) {
		try {
			this.output.write(text);
			this.output.flush();
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}

}
