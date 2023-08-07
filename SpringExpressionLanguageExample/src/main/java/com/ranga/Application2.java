package com.ranga;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Application2 {
	public static void main(String[] args) {
		ExpressionParser expressionParser = new SpelExpressionParser();
		Expression expression = expressionParser.parseExpression("'Hello Ranga'");
		String message = (String) expression.getValue();
		System.out.println(message);		
		
		expression = expressionParser.parseExpression("'Hello Ranga'.concat('Reddy')");
		message = (String) expression.getValue();
		System.out.println(message);
		
		expression = expressionParser.parseExpression("'Hello Ranga'.concat('Reddy').bytes");
		byte[] bytes = (byte[]) expression.getValue();
		System.out.println(bytes);
	}
}
