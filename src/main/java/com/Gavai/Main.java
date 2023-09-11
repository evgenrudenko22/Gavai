package com.Gavai;

import com.Gavai.Parser.Lexer;
import com.Gavai.Parser.Parser;
import com.Gavai.Parser.Token;
import com.Gavai.Parser.ast.Statement;
import com.Gavai.Parser.visitor.AssyneValidatar;
import com.Gavai.Parser.visitor.FunctionAdder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException
    {
        final String input = new String(Files.readAllBytes(Paths.get("program.ga")), StandardCharsets.UTF_8);

        final List<Token> tokens = new  Lexer(input).tokenize();

        /*
        for (Token token : tokens)
        {
            System.out.println("? " + token);
        }
         */
        final Statement program = new Parser(tokens).parse();
        //System.out.println(program.toString());
        program.accept(new FunctionAdder() );
        program.accept(new AssyneValidatar() );
        program.execute();
    }
}
