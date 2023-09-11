package com.Gavai.Parser;

public enum TokenType {

    NUMBER,
    HEX_NUMBER,
    WORD,
    TEXT,

    // keyword
    PRINT,
    IF,
    ELSE,
    WHILE,
    FOR,
    DO,
    BREAK,
    CONTINUE,
    FN,
    RETURN,
    USE,

    PLUS,
    MINUS,
    STAR,
    SLASH,
    EQ,
    EQEQ,
    EXCL,
    EXCLEQ,
    LT,
    LTEQ,
    GT,
    GTEQ,

    BAR,
    BARBAR,
    AMP,
    AMPAMP,

    LPAREN, // (
    RPAREN, // )
    LBRACKET, // [
    RBRACKET, // ]
    LBRACE, // {
    RBRACE, // }
    SEMICOLON,

    EOF

}
