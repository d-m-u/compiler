package wci.backend;

import wci.intermediate ICode;
import wci.intermediate.SymTab;
import wci.message.*;

public abstract class Backend implements MessageProducer
{
    protected static MessageHandler messageHandler;

    static
    {
        messageHandler = new MessageHandler();
    }

    protected SymTab symTab;
    protected Icode iCode;

    public abstract void process(ICode iCode, SymTab symTab)
    throws Exception;

}