grammar statementList;

statementList:	statement+ ;

statement:	variableDeclaration
	|	ifStatement
	|	block
	|	assignmentStatement
	|   forStatement
	|   returnStatement
	|   modifyStatement ;

variableDeclaration: typeName varName ('=' multipleExpression)? SCOLON ;

typeName: type | listType ;
listType: 'List' LP type RP ;
type: ID ;

elseStatement: 'else' block ;

ifStatement: 'if' LP boolStatement RP block elseStatement? ;

forStatement: 'for ' LP ((type varName ':' varName) | (variableDeclaration boolStatement varName INCORDESC)) RP block ;

block:	'{' statementList '}' ;

assignmentStatement: varName '=' multipleExpression SCOLON ;

modifyStatement: multipleExpression SCOLON ;

boolStatement: multipleExpression SCOLON? ;

returnStatement: 'return' (BOOL | multipleExpression ) SCOLON;
BOOL: 'true' | 'false' ;

multipleExpression: expression (operator expression)* ;

operator: '==' | '>' | '<' | '<=' | '>=' | '!=' | '+' | '-' | '+=' | '-=' | '&&' | '||' | '/' | '*' ;

expression: func | varName | item | loopBreak | NUMBER | STRING | BOOL ;

ID: [a-zA-Z][a-zA-Z]* ;

NUMBER: [0-9] | ([1-9] [0-9]*) ;
STRING : '"' (~[\r\n"])* '"' ;
INCORDESC: '++' | '--' ;

WS : [ \t\r\n]+ -> skip ;

varName : ID ;

func: NEG? (ID '.')? funcname LP params? RP ;
funcname: ID ;
params: param (COMMA param)* ;

param: mparam | item | NUMBER | BOOL;
item: '[' (NUMBER | CHAR | COLOR | SYMBOL) ']' ;
mparam: ID ;
loopBreak: 'break' ;

CHAR:  '&' [A-E] ;
COLOR:  '#' ((HDN HDN HDN HDN HDN HDN) | (HDN HDN HDN)) ;
HDN: [A-F] | [a-f] | [0-9] ;
SYMBOL: 'S' NUMBER ;

LP:  '(' ;
RP:  ')' ;
COMMA: ',' ;
SCOLON: ';' ;
NEG: '!' ;