import compilerTools.Token;

%%
%class Lexer
%type Token
%line
%column
%{
    private Token token(String lexeme, String lexicalComp, int line, int column){
        return new Token(lexeme, lexicalComp, line+1, column+1);
    }
%}
/* Variables básicas de comentarios y espacios */
TerminadorDeLinea = \r|\n|\r\n
EntradaDeCaracter = [^\r\n]
EspacioEnBlanco = {TerminadorDeLinea} | [ \t\f]
ComentarioTradicional = "/*" [^*] ~"*/" | "/*" "*"+ "/"
FinDeLineaComentario = "!!" {EntradaDeCaracter}* {TerminadorDeLinea}?
ContenidoComentario = ( [^*] | \*+ [^/*] )*
ComentarioDeDocumentacion = "/**" {ContenidoComentario} "*"+ "/"

/* Comentario */
Comentario = {ComentarioTradicional} | {FinDeLineaComentario} | {ComentarioDeDocumentacion}

/* Identificador */
Letra = [A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]
Digito = [0-9]
A=[!¡]
Identificador = {Letra}({Letra}|{Digito})*

/* Número */
Numero = 0 | [1-9][0-9]*
%%

/* Comentarios o espacios en blanco */
{Comentario}|{EspacioEnBlanco} { /*Ignorar*/ }
/* ------------------------------------------------------------ */
/* IDENTIFICADOR*/
{Identificador} { return token(yytext(), "IDENTIFICADOR", yyline, yycolumn); }
/* TIPOS DE DATO */
C |
CAD |
SZ |
Z |
R |
Q |
D | 
VOF { return token(yytext(), "Tipo_De_Dato", yyline, yycolumn); }

/* NUMERO*/
 0 | [1-9][0-9]* { return token(yytext(), "NUMERO", yyline, yycolumn); }

/*COLORES*/
BLANCO |
GRISCLARO |
GRIS |
NEGRO |
ROJO |
ROSA |
NARANJA |
AMARILLO |
VERDE |
FUSCIA |
AZULTURQ |
AZUL { return token(yytext(), "COLOR", yyline, yycolumn); }

/*OPERADORES DE AGRUPACION*/
"<(" { return token(yytext(), "LLAVE_ABIERTA", yyline, yycolumn); }
")>" { return token(yytext(), "LLAVE_CERRADA", yyline, yycolumn); }


/*OPERADORES */
"EQU" { return token(yytext(), "OPERADOR_ASIGNACION", yyline, yycolumn); }
"MAS" { return token(yytext(), "OPERADOR_MAS", yyline, yycolumn); }
"MENOS" { return token(yytext(), "OPERADOR_MENOS", yyline, yycolumn); }
"POR" { return token(yytext(), "OPERADOR_MULTIPLICAR", yyline, yycolumn); }
"ENTRE" { return token(yytext(), "OPERADOR_DIVIDIR", yyline, yycolumn); }
"Y" { return token(yytext(), "OPERADOR_AND", yyline, yycolumn); }
"O" { return token(yytext(), "OPERADOR_OR", yyline, yycolumn); }
"DIF" { return token(yytext(), "OPERADOR_DIFERENTEQUE", yyline, yycolumn); }
"MAY" { return token(yytext(), "OPERADOR_MAYORQUE", yyline, yycolumn); }
"MEN" { return token(yytext(), "OPERADOR_MENORQUE", yyline, yycolumn); }
"MAS1" { return token(yytext(), "OPERADOR_INCREMENTO", yyline, yycolumn); }
"MEN1" { return token(yytext(), "OPERADOR_DECREMENTO", yyline, yycolumn); }

/*PUNTUACION */
"!!" { return token(yytext(), "FIN_DE_SENTENCIA", yyline, yycolumn); }

/*PALABRAS RESERVADAS*/

Cond { return token(yytext(), "INICIO_CONDICIONAL", yyline, yycolumn); }
Conds { return token(yytext(), "SEGUIR_CONDICIONAL", yyline, yycolumn); }
Mientras  { return token(yytext(), "CICLO_WHILE", yyline, yycolumn); }
Ciclar  { return token(yytext(), "CICLO_FOR", yyline, yycolumn); }
Hacer  { return token(yytext(), "CICLO_DOWHILE", yyline, yycolumn); }

Este |
Devolver |
CHANGE |
v |
f { return token(yytext(), "PALABRA_RESERVADA", yyline, yycolumn); }

. { return token(yytext(), "Error", yyline, yycolumn); }