package com.Gavai.Parser.ast;

import com.Gavai.lib.Value;

public interface Expression extends Node{

    Value eval();
}
