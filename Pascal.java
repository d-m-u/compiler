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