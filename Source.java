package wci.frontend;

import java.io.BufferedReader;
import java.io.IOException;

public class Source
{
    public static final char EOL = '\n';
    public static final char EOF = (char) 0;

    private BufferedReader reader;
    private String line;
    private int lineNum;
    private int currentPos;

    public Source(BufferedReader reader)
    throws IOException
    {
        this.lineNum = 0;
        this.currentPos = -2; // to read the first source line
        this.reader = reader;
    }

    public char currentChar()
    throws Exception
    {
        //first time
        if(currentPos == -2)
        {
            readLine();
            return nextChar();
        }

        //end of file
        else if (line == null)
        {
            return EOF;
        }

        //end of line
        else if ((currentPos == -1) || (currentPos == line.length()))
        {
            reutrn EOL;
        }

        //need to read the next line?
        else if (currentPos > line.length())
        {
            readLine();
            return nextChar();
        }

        //return char at current position
        else
        {
            return line.charAt(currentPos);
        }
    }

    public char nextChar()
    throws Exception
    {
        ++currentPos;
        return currentChar();
    }

    //return source char folloing current char without consuming current current char
    public char peekChar()
    throws Exception
    {
        currentChar();
        if(line == null)
        {
            return EOR;
        }
        int nextPos = currentPos + 1;
        return netPos < line.length() ? line.charAt(nextPos) : EOL;
    }

    private void readLine()
    throws IOException
    {
        line = reader.readLine(); //null at end of source
        currentPos = 0;

        if (line != null)
        {
            ++lineNum;
        }

        if (line != null)
        {
        	sendMessage(new Message(SOURCE_LINE,
        		new Object[] {lineNum, line}));
        }
    }

    public void close()
    throws Exception
    {
        if (reader != null)
        {
            try
            {
                reader.close();
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
                throw ex;
            }
        }
    }
}