package wci.frontend;

import wci.intermediate.Icode;
import wci.intermediate.SymTab;

// language-independent framework class to be implemented by language-specific subclasses

public abstract class Parser
{
    protected static SymTab symTab;   //generated symbol table
    static
    {
        symTab = null;
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
}

// there will be only one symbol table in front end
// so Parser implements symTab as a class field
// will get initialized once before any Parser objects are created