package com.app.api;

import com.jk.core.exceptions.handler.ExceptionHandler;
import com.jk.core.exceptions.handler.JKExceptionHandler;

import javax.swing.*;

@ExceptionHandler
public class CustomExceptionHandler implements JKExceptionHandler<ArrayIndexOutOfBoundsException> {

	@Override
	public void handle(ArrayIndexOutOfBoundsException throwable, boolean throwRuntimeException) {
		JOptionPane.showMessageDialog(null, "My ArrayIndexException Handler");
	}

}
