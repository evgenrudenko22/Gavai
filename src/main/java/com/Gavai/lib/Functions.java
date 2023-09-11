package com.Gavai.lib;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Functions {

    private static final NumberValue ZERO = NumberValue.ZERO;
    private static final Map<String, Function> functions;

    static {
        functions = new HashMap<>();
        functions.put("sin", new Function() {
            @Override
            public Value execute(Value... args) {
                if (args.length != 1) throw new RuntimeException("One args expected");
                return new NumberValue(Math.sin(args[0].asDouble()));
            }
        });
        functions.put("cos", new Function() {
            @Override
            public Value execute(Value... args) {
                if (args.length != 1) throw new RuntimeException("One args expected");
                return new NumberValue(Math.cos(args[0].asDouble()));
            }
        });
        functions.put("input", (Function) (Value... args) -> {
            if (args.length != 0) throw new RuntimeException("Null args expected");
            Scanner scanner = new Scanner(System.in);
            return new StringValue(scanner.nextLine());
        });
        functions.put("echo", (Value... args) ->{
            for (Value arg : args)
            {
                System.out.println(arg.asString());
            }
            return ZERO;
        });
        functions.put("NewArray", new Function() {
            @Override
            public Value execute(Value... args) {
                return createArray(args, 0);
            }

            private ArrayValue createArray(Value[] args, int index)
            {
                final int size = (int) args[index].asDouble();
                final int last = args.length - 1;
                ArrayValue array = new ArrayValue(size);
                if (index == last)
                {
                    for (int i = 0; i < size; i++)
                    {
                        array.set(i, ZERO);
                    }
                } else if (index < last)
                {
                    for (int i = 0; i < size; i++)
                    {
                        array.set(i, createArray(args, index + 1));
                    }
                }
                return array;
            }
        });
    }

    public static boolean isExists(String key)
    {
        return functions.containsKey(key);
    }

    public static Function get(String key)
    {
        if (!isExists(key)) throw new RuntimeException("Unknown function" + key);
        return functions.get(key);
    }

    public static void set(String key, Function function)
    {
        functions.put(key, function);
    }

}
