package myapp.tags;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class SimplePrimeTag extends SimpleTagSupport {
	protected int length = 50;

	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		getJspBody().invoke(null);
		out.print("simpe prime output: Length = " + length);
	}

	public void setLength(String length) {
		try {
			this.length = Integer.parseInt(length);
		} catch (NumberFormatException nfe) {
			this.length = 50;
		}
	}
}