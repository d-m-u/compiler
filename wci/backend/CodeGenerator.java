public void process(ICode iCode, SymTab symTab)
throws Exception
{
    long startTime = System.currentTimeMillis();
    float elapsedTime = (System.currentTimeMillis() - startTime) / 1000f;
    int instructionCount = 0;

    sendMessage(new Message(COMPILER_SUMMARY, new Number[] {instructionCount,
                            elapsedTime
                                                           }));
}