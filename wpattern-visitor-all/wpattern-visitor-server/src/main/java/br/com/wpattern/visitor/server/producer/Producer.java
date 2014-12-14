package br.com.wpattern.visitor.server.producer;

import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Named;

import org.apache.log4j.Logger;

import br.com.wpattern.visitor.server.interfaces.IProducer;
import br.com.wpattern.visitor.utils.beans.BookBean;
import br.com.wpattern.visitor.utils.beans.QuotationBean;
import br.com.wpattern.visitor.utils.elements.BookElement;
import br.com.wpattern.visitor.utils.elements.QuotationElement;
import br.com.wpattern.visitor.utils.interfaces.IElement;
import br.com.wpattern.visitor.utils.interfaces.IProcessor;

@Named
public class Producer implements IProducer {

	private static final Logger logger = Logger.getLogger(Producer.class);

	private static final String[] SYMBOLS = new String[] { "PETR4", "VALE5", "ITUB3", "DI1N13" };

	private static final int PERIOD = 1000;

	private static final Random random = new Random();

	private IProcessor processor;

	@Override
	public void startProducer(IProcessor processor) {
		this.processor = processor;

		Timer timer = new Timer("Producer");
		timer.scheduleAtFixedRate(new ProducerTimerTask(), 0, PERIOD);
	}

	private IElement buildBookElement() {
		BookBean bookBean = new BookBean();

		bookBean.setDate(new Date());
		bookBean.setPrice(random.nextDouble() % 10.15);
		bookBean.setQuantity(random.nextInt() % 1000);

		return new BookElement(bookBean);
	}

	private IElement buildQuationElement() {
		QuotationBean quotationBean = new QuotationBean();

		quotationBean.setSymbol(SYMBOLS[random.nextInt(SYMBOLS.length)]);
		quotationBean.setLastPrice(random.nextDouble() % 131.94);

		return new QuotationElement(quotationBean);
	}

	class ProducerTimerTask extends TimerTask {

		@Override
		public void run() {
			IElement element = null;
			// 0 = BookElement
			// 1 = QuotationElement
			int elementType = random.nextInt(2);

			switch (elementType) {
			case 0:
				element = Producer.this.buildBookElement();
				break;

			case 1:
				element = Producer.this.buildQuationElement();
				break;

			default:
				logger.error("Unknown type of element.");
				break;
			}

			if (element != null) {
				Producer.this.processor.receiveElement(element);
			}
		}

	}

}
