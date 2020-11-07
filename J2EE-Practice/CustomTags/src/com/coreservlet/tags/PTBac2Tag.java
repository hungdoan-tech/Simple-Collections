
package com.coreservlet.tags;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

import com.coreservlet.models.PTBac2;

import java.io.*;

public class PTBac2Tag extends SimpleTagSupport
{
	private int varA;
	private int varB;
	private int varC;
	
	public int getVarA()
	{
		return varA;
	}
	public void setVarA(int varA)
	{
		this.varA = varA;
	}
	public int getVarB()
	{
		return varB;
	}
	public void setVarB(int varB)
	{
		this.varB = varB;
	}
	public int getVarC()
	{
		return varC;
	}
	public void setVarC(int varC)
	{
		this.varC = varC;
	}
	
	@Override
	public void doTag() throws JspException, IOException
	{	
		JspWriter out = getJspContext().getOut();
		
		PTBac2 pt = new PTBac2(this.varA,this.varB,this.varC);
		out.println(pt.GPT());
	}
}
