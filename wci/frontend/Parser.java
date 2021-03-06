package wci.frontend;

import wci.intermediate.Icode;
import wci.intermediate.SymTab;
import wci.message.*;

// language-independent framework class to be implemented by language-specific subclasses

public abstract class Parser implements MessageProducer
{
    protected static Symtab symTab;                  //generated symbol table
    protected static MessageHandler messageHandler;  //message handler delegate

    static
    {
        symTab = null;
        messageHandler = new MessageHandler();
    }

    protected Scanner scanner;  // scanner to be used with this parser
    protected Icode iCode;      // intermediate code used with this parser

    protected Parser(Scanner scanner)
    {
        this.scanner = scanner;
        this.iCode = null;
    }
        /**
     * Getter.
     * @return the scanner used by this parser.
     */
    public Scanner getScanner()
    {
        return scanner;
    }

    /**
     * Getter.
     * @return the intermediate code generated by this parser.
     */
    public ICode getICode()
    {
        return iCode;
    }

    /**
     * Getter.
     * @return the symbol table generated by this parser.
     */
    public SymTab getSymTab()
    {
        return symTab;
    }

    /**
     * Getter.
     * @return the message handler.
     */
    public MessageHandler getMessageHandler()
    {
        return messageHandler;
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