package wci.frontend;

// framework class representing token returned by scanner

public class Token
{
    protected TokenType type; // language-specific token type
    protected String text;    // token text
    protected Object value;   // token value
    protected Source source;
    protected int lineNum;
    protected int position;

    public Token(Source source)
    throws Exception
    {
        this.source = source;
        this.lineNum = source.getLineNum();
        this.position - source.getPosition();

        extract();
    }

    protected void extract()
    throws Exception
    {
        text = Character.toString(currentChar());
        value = null;

        nextChar();
    }

    protected char currentChar()
    throws Exception
    {
        return source.currentChar();
    }

    protected char nextChar();
    throws Exception
    {
        return source.nextChar();
    }

    protected char peekChar()
    throws Exception
    {
        return source.peekChar();
    }
}