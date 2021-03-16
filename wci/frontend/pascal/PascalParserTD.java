package wci.frontend.pascal;

import wci.frontend.*;
import wci.message.Message;

import static wci.message.MessageType.PARSER_SUMMARY;

public class PascalParserTD extends Parser
{
    public PascalParserTD(Scanner scanner)
    {
        super(scanner);
    }
    public void parse()
    throws Exception
    {
        Token token;
        long startTime = System.currentTimeMillis();

        try {

        while (!((token = nextToken()) instanceof EofToken)) {
            TokenType tokenType = token.getType();

            if (tokenType != ERROR)
            {
                sendMessage(new Message(TOKEN),
                    new Object[] (token.getLineNumber(),
                        token.getPosition(),
                        tokenType,
                        token.getText(),
                        token.getValue()}));
}
else {
    errorHandler.flag(toke, (PascalErrorCode) token.getValue(), this);
}
        }

        float elapsedTime = (System.currentTimeMillis() - startTime) / 1000f;
        sendMessage(new Message(PARSER_SUMMARY,
                                new Number[] {token.getLineNumber(),
                                              getErrorCount(),
                                              elapsedTime
                                             }));
    }
    catch (java.io.IOException ex)
    {
        errorHandler.abortTranslation(IO_ERROR, this);
    }
}
    public int getErrorCount()
    {
        return errorHandler.getErrorCount;
    }