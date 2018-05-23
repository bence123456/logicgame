grammar validation;

validation: (WIN func+) | statementList ;
BOOL: TRUE | FALSE ;

statementList :	statement+ ;

statement :	variableDeclaration
	|	ifStatement
	|	block
	|	assignmentStatement ;

variableDeclaration : typeName varName ('=' expression)? ';' ;

typeName :	ID ;

varName :	ID ;

ifStatement : 	'if' '(' expression ')' block ;

block :	'{' statementList '}' ;

assignmentStatement : varName '=' expression ';' ;

expression
	: varName
	| NUMBER
	| STRING
	| BOOL
	| NULL
	;

func: funcname LP params? RP ISEQ BOOL ;
funcname: ID ;
params: (param (COMMA param)*) | param  ;
param: item | NUMBER ;

item: '[' ID ']' ;

ID: [a-zA-Z][a-zA-Z0-9_]* ;
NUMBER: [0-9] | ([1-9] [0-9]*) ;

WIN: 'win' COL ;

ISEQ: '==' ;
TRUE: 'true' ;
FALSE: 'false' ;
EMPTY: 'empty' ;

ITEM: 'item' ;
NULL : 'null';
STRING : '"' (~[\r\n"])* '"' ;

LP:  '(' ;
RP:  ')' ;
COMMA: ',' ;
COL: ':' ;

WS : [ \t\r\n]+ -> skip ;