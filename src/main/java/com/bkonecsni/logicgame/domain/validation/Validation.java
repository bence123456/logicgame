package com.bkonecsni.logicgame.domain.validation;

import java.util.List;

public class Validation {

    private List<WinStatement> winStatementList;

    private List<LooseStatement> looseStatementList;

    public Validation(List<WinStatement> winStatementList, List<LooseStatement> looseStatementList) {
        this.winStatementList = winStatementList;
        this.looseStatementList = looseStatementList;
    }

    public List<WinStatement> getWinStatementList() {
        return winStatementList;
    }

    public void setWinStatementList(List<WinStatement> winStatementList) {
        this.winStatementList = winStatementList;
    }

    public List<LooseStatement> getLooseStatementList() {
        return looseStatementList;
    }

    public void setLooseStatementList(List<LooseStatement> looseStatementList) {
        this.looseStatementList = looseStatementList;
    }
}
