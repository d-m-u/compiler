import java.io.BufferedReader;
import java.io.FileReader;

import wci.frontend.*;
import wci.intermediate.*;
import wci.backend.*;
import wci.message.*;

import static wci.message.MessageType.*;

public class Pascal
{
    try
    {
        boolean intermediate = flags.indexOf('i') > -1;
        boolean xref         = flags.indexOf('x') > -1;

        source = new Source(new BufferedReader(new FileReader(filePath)));
        source.addMessageListener(new SourceMessageListener());

        parser = FrontendFactory.createParser("Pascal", "top-down", source);
        parser.addMessageListener(new ParserMessageListener());

        backend = BackendFactory.createBackend(operation);
        backend.addMessageListener(new BackendMessageListener());

        parser.parse();
        source.close();

        iCode = parser.getIcode();
        symTab = parser.getSymTab();

        backend.process(iCode, symTab);
    }
    catch(Exception ex)
    {
        System.out.println("******** Internal translator error. *******");
        ex.printStackTrace();
    }
}

private static final String FLAGS = "[-ix]";
private static final String USAGE = "Usage: Pascal execute|compile " + FLAGS + " <source file path>";

public static void main(String args[])
{
    try
    {
        String operation = args[0];
        if(!(operation.equalsIgnoreCase("compile") || operation.equalsIgnoreCase("execute")))
        {
            throw new Exception();
        }
        int i = 0;
        String flags = "";

        while ((++i < args.length) && (args[i].charAt(0) == '-'))
        {
            flags += args[i].substring(1);
        }
        //here
    }
}