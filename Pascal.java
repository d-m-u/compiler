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


    }
}