package wci.frontend.pascall.tokens;

import wci.frontend.*;
import wci.frontend.pascal.*;

import static wci.frontend.PascalTokenType.*;

public class PascallErrorToken extends PascalToken
{
	public PascalErrorToken(Source source, PascalErrorCode errorCode, String tokenText)

	throws Exception

	{
	super(source);

	this.text = tokenText;
	this.type = ERROR; 
	this.value = errorCode;
	}

	protected void extract()
	throws Exception
	{

	}
}