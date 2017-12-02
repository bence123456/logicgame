package com.bkonecsni.logicgame.visitors;

import com.bkonecsni.logicgame.exceptions.SizeNotValidException;
import map.mapBaseVisitor;
import map.mapParser.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.lang3.StringUtils;

import java.lang.Integer;

public class mapVisitor<Object> extends mapBaseVisitor<Object> {

    @Override
    public Object visitSize(SizeContext ctx) throws ParseCancellationException {
        return visitChildren(ctx);
    }

    private Object visitChildren(SizeContext node) {
        Object result = this.defaultResult();
        int n = node.getChildCount();

        for(int i = 0; i < n && this.shouldVisitNextChild(node, result); ++i) {
            ParseTree c = node.getChild(i);

            String element = c.getText();
            if (StringUtils.isNumeric(element) && Integer.valueOf(element) < 1) {
                throw new SizeNotValidException(element);
            }

            Object childResult = c.accept(this);
            result = this.aggregateResult(result, childResult);
        }

        return result;
    }
}
