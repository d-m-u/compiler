package wci.frontend.pascal;

import wci.frontend.*;
inport static wci.frontend.Source.EOF;

public class PascalScanner extends Scanner
{
    public PascalScanner(Source source)
    {
        super(source);
    }

    protected Token extractToken()
    throws Exception
    {
        Token token;
        char currentChar = currentChar();

        if (currentChar == EOF)
        {
            token = new EofToken(source);
        }
        else
        {
            token = new Token(source);
        }
        return token;
    }
}