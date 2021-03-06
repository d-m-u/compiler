package wci.frontend.pascal;

import wci.frontend.*;
import wci.message.Message; 

import static wci.frontend.pascal.PascalTokenType.*;
import static wci.frontend.pascal.PascalErrorCode.*;
import static wci.message.MessageType.SYNTAX_ERROR;

public class PascalErrorHandler
{
	private static final int MAX_ERRORS = 25;
	private static int errorCount = 0;

	public void flag(Token token, PascalErrorCode errorCode, Parser parser)
	{
		parser.sendMessage(new Message(SYNTAX_ERROR, new Object[] {token.getLineNumber(),
			token.getPosition(),
			token.getText(),
			errorCode.toString()}));

		if(++errorCount > MAX_ERRORS) {
			abortTranslation(TOO_MANY_ERRORS, parser);
		}
	}
	public void abortTranslation(PascalErrorCode errorCode, Parser parser)
	{
		String fatalText = "FATAL ERROR: " + errorCode.toString();
		parser.sendMessage(new Message(SYNTAX_ERROR, new Object[] {0, 0, "", fatalText}));
		System.exit(errorCode.getStatus());
	}
}