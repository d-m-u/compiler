package wci.frontend;

import wci.intermediate.Icode;
import wci.intermediate.SymTab;

// language-independent framework class to be implemented by language-specific subclasses

public abstract class Parser implements MessageProducer
{
    protected static Symtab symtab;                  //generated symbol table
    protected static MessageHandler messageHandler;  //message handler delegate

    static
    {
        symtab = null;
        messageHandler = new MessageHandler();
    }

    protected Scanner scanner;  // scanner to be used with this parser
    protected Icode iCode;      // intermediate code used with this parser

    protected Parser(Scanner scanner)
    {
        this.scanner = scanner;
        this.iCode = null;
    }

    public abstract void parse()
    throws Exception;

    public abstract int getErrorCount();

    public Token currentToken()
    {
        return scanner.currentToken();
    }

    public Token nextToken()
    throws Exception
    {
        return scanner.nextToken();
    }

    public void addMessageListener(MessageListener listener)
    {
        messageHandler.addListener(listener);
    }

    public void removeMessageListener(MessageListener listener)
    {
        messageHandler.removeListener(listener);
    }

    public void sendMessage(Message message)
    {
        messageHandler.sendMessage(message);
    }

}

// there will be only one symbol table in front end
// so Parser implements symTab as a class field
// will get initialized once before any Parser objects are created