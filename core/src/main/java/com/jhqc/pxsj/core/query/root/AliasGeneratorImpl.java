package com.jhqc.pxsj.core.query.root;

public class AliasGeneratorImpl implements AliasGenerator {
    private int i = 0;

    @Override
    public String generate(String prefix) {
        return prefix + i++;
    }
}
