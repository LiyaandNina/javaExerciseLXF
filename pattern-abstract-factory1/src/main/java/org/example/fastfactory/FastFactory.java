package org.example.fastfactory;

import org.example.service.AbstractFactory;
import org.example.service.HtmlDocument;
import org.example.service.WordDocument;

public class FastFactory implements AbstractFactory {

	@Override
	public HtmlDocument createHtml(String md) {
		return new FastHtmlDocument(md);
	}

	@Override
	public WordDocument createWord(String md) {
		return new FastWordDocument(md);
	}
}
