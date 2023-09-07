package org.example.goodfactory;

import org.example.service.AbstractFactory;
import org.example.service.HtmlDocument;
import org.example.service.WordDocument;

public class GoodFactory implements AbstractFactory {

	@Override
	public HtmlDocument createHtml(String md) {
		return new GoodHtmlDocument(md);
	}

	@Override
	public WordDocument createWord(String md) {
		return new GoodWordDocument(md);
	}
}
